const express = require("express");
const path = require("path");
const port = 3100;
const app = express();
const dataMakanan = require("./data/data");

app.get("/articles", (req, res) => {
  res.json(dataMakanan);
});

const imagesFolder = path.join(__dirname, "images");

app.get("/api/image/:imageName", (req, res) => {
  const imageName = req.params.imageName;
  const imagePath = path.join(imagesFolder, imageName);

  res.sendFile(imagePath, (err) => {
    if (err) {
      console.error(err);
      res.status(404).send("Image not found");
    }
  });
});

app.listen(port, () => {
  console.log(`Server berjalan di http://localhost:${port}`);
});
