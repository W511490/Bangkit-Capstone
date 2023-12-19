import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns
import tensorflow as tf
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import MinMaxScaler

# Load Dataset
child_data = pd.read_excel('./dataset_ceriakids2/Data Balita jakarta.xlsx')

# Drop Null value
child_data.dropna(axis= 0, inplace= True)

# Train Model
X = child_data[['UmurBaduta',
                'PBSekarang',
                'BBSekarang',
                'JumlahAnggotaKeluarga',
                'JumlahMakanSehari',
                'TotalPengeluaran']] # Features


y = pd.get_dummies(child_data['Status']) # target

# Normalize Data
scaler = MinMaxScaler()
X_normalized = scaler.fit_transform(X)

# Split Data
# train = 80%
# test = 20%
X_train, X_test, y_train, y_test = train_test_split(X_normalized, y,
                                                    test_size=0.2,
                                                    random_state=42
                                                    )

# Model
model = tf.keras.Sequential([
    tf.keras.layers.Flatten(input_shape= (X_train.shape[1], )),
    tf.keras.layers.Dense(128, activation= 'relu'),
    tf.keras.layers.Dense(64, activation= 'relu'),
    tf.keras.layers.Dense(32, activation= 'relu'),
    tf.keras.layers.Dense(2, activation= 'sigmoid')
])

model.compile(
    optimizer= tf.keras.optimizers.Adam(),
    loss= 'binary_crossentropy',
    metrics= ['Accuracy']
)

model.summary()

# Train Model
model.fit(
    X_train, y_train,
    validation_data= (X_test, y_test),
    verbose= 1,
    epochs= 50,
    batch_size= 32
)

# Evaluasi model
loss, accuracy = model.evaluate(X_test, y_test)
print(f'Loss: {loss}, Accuracy: {accuracy}')

model.save('ceriakids.h5')