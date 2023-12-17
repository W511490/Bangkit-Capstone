package com.example.ceriakids.ui.editprofil

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.DatePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ceriakids.databinding.ActivityEditProfilBinding
import com.example.ceriakids.ui.login.LoginActivity
import com.example.ceriakids.ui.main.MainActivity
import java.util.Calendar

class EditProfilActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditProfilBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfilBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.editDate.setOnClickListener {
            showDatePicker()
        }

        binding.btnSave.setOnClickListener {
            saveProfil()
        }

        setupView()
    }

    private fun setupView() {
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        supportActionBar?.title = "Lengkapi Profil"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }


    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view: DatePicker, year: Int, monthOfYear: Int, dayOfMonth: Int ->
                val selectedDate = "$dayOfMonth/${monthOfYear + 1}/$year"
                binding.editDate.setText(selectedDate)
            }, year, month, day
        )
        datePickerDialog.show()
    }

    private fun saveProfil() {
        val name = binding.nameInput.editText?.text.toString()
        val date = binding.editDate.text.toString()
        val phone = binding.EtPhone.text.toString()
        val email = binding.EtEmail.text.toString()

        if (name.isNotEmpty() && date.isNotEmpty() && phone.isNotEmpty()) {
            // Semua bidang telah diisi, Anda bisa menambahkan logika untuk menyimpan data di sini
            // Misalnya, Anda bisa menyimpan data ke database atau tempat penyimpanan lainnya
            val intent = Intent(this@EditProfilActivity, MainActivity::class.java)
            startActivity(intent)
            // Tampilkan pesan bahwa data berhasil disimpan
            Toast.makeText(this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show()

            // Lanjutkan ke langkah selanjutnya, seperti menutup aktivitas ini atau melakukan sesuatu yang sesuai dengan alur aplikasi Anda
        } else {
            // Salah satu atau beberapa bidang masih kosong, tampilkan pesan kesalahan
            Toast.makeText(this, "Harap isi semua bidang", Toast.LENGTH_SHORT).show()
        }
    }
}