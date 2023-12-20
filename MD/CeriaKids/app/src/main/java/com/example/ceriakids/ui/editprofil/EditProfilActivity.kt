package com.example.ceriakids.ui.editprofil

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.DatePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ceriakids.R
import com.example.ceriakids.databinding.ActivityEditProfilBinding
import com.example.ceriakids.ui.main.MainActivity
import java.util.Calendar

class EditProfilActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditProfilBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.Tvreset.setOnClickListener {
            resetInput()
        }

        binding.editDate.setOnClickListener {
            showDatePicker()
        }

        binding.btnSave.setOnClickListener {
            saveProfil()
        }

        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.RbMan -> {
                    // Jika RadioButton "Laki-laki" dipilih, nonaktifkan RadioButton "Perempuan"
                    binding.RbWomen.isChecked = false
                }

                R.id.RbWomen -> {
                    // Jika RadioButton "Perempuan" dipilih, nonaktifkan RadioButton "Laki-laki"
                    binding.RbMan.isChecked = false
                }
            }
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

    private fun resetInput() {
        binding.nameInput.editText?.setText("")
        binding.editDate.setText("")
        binding.EtPhone.setText("")
        binding.EtEmail.setText("")
        binding.RbMan.setText("")
        binding.RbWomen.setText("")
        binding.RbMan.text = getString(R.string.man)
        binding.RbWomen.text = getString(R.string.women)
        binding.radioGroup.clearCheck()
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
            val intent = Intent(this@EditProfilActivity, MainActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show()
            resetInput()
        } else {
            Toast.makeText(this, "Harap isi semua bidang", Toast.LENGTH_SHORT).show()
        }
    }
}