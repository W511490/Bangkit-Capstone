package com.example.ceriakids.ui.addchild

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ceriakids.databinding.ActivityAddChildBinding
import com.example.ceriakids.ui.profil.ProfilFragment
import com.example.ceriakids.ui.report.ReportFragment

class AddChildActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddChildBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddChildBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnChild.setOnClickListener {
            val name = binding.EtNameChild.text.toString().trim()
            val date = binding.EtDateChild.text.toString().trim()
            val gender = if (binding.RbMan.isChecked) "Laki-laki" else "Perempuan"

            if (name.isNotEmpty() && date.isNotEmpty()) {
                // Simpan data ke RecyclerView di ProfileFragment
                val profilFragment = supportFragmentManager.findFragmentByTag("profileFragment") as? ProfilFragment
                profilFragment?.addDataToRecyclerView(name, date, gender)

                // Simpan data untuk ReportActivity
                val intent = Intent(this@AddChildActivity, ReportFragment::class.java)
                intent.putExtra("name", name)
                intent.putExtra("date", date)
                intent.putExtra("gender", gender)
                startActivity(intent)

                finish()
            } else {
                Toast.makeText(this, "Mohon lengkapi semua Data", Toast.LENGTH_SHORT).show()
            }
        }

//        fun addDataToRecyclerView(name: String, date: String, gender: String) {
//            // Lakukan logika untuk menambahkan data ke adapter RecyclerView di sini
//            // Misalnya, jika Anda memiliki adapter bernama childAdapter:
//            val newChild = Child(name, date, gender)
//            childAdapter.addData(newChild)
//        }
    }
}