package com.example.sharedialog

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.sharedialog.databinding.ActivityMainBinding
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSend.setOnClickListener {
            alertDialog()
        }
    }


    private fun alertDialog() {
        val alertDialog = Dialog(this)
        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        alertDialog.setCancelable(false)
        alertDialog.setContentView(R.layout.alert_dialog)
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val btnShare: Button = alertDialog.findViewById(R.id.btn_share_dialog)
        val btnCancel: TextView = alertDialog.findViewById(R.id.tv_cancel_dialog)

        btnCancel.setOnClickListener {
            alertDialog.dismiss()
        }

        btnShare.setOnClickListener {
            val url = "https://www.instagram.com/dbaudunova"
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, url)
            startActivity(Intent.createChooser(intent, "Share via"))
        }
        alertDialog.show()
    }

}