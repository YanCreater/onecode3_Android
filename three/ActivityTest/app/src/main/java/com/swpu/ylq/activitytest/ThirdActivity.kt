package com.swpu.ylq.activitytest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_third.*

class ThirdActivity : AppCompatActivity() ,View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        button3.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.button3 ->{
               progressBar.progress=progressBar.progress+10
                AlertDialog.Builder(this).apply {
                    setTitle("This is Dialog")
                    setMessage("Something important")
                    setCancelable(false)
                    setPositiveButton("OK"){
                        dialog, which ->
                    }
                    setNegativeButton("Cancel"){
                        dialog, which ->
                    }
                    show()
                }
            }
        }
    }
}
