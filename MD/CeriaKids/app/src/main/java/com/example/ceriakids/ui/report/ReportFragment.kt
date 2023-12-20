package com.example.ceriakids.ui.report

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ceriakids.R
import com.example.ceriakids.ui.addreport.AddReportActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ReportFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_report, container, false)

        val fabAddReport = view.findViewById<FloatingActionButton>(R.id.fabreport)
        fabAddReport.setOnClickListener {
            val intent = Intent(activity, AddReportActivity::class.java)
            startActivity(intent)
        }

        return view
    }
}