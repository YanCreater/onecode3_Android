package com.swpu.ylq.broadcastbestpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        if(savedInstanceState !=null){
            saveAccount.isChecked=savedInstanceState.getBoolean("isCheckedAccount")
            savePassword.isChecked=savedInstanceState.getBoolean("isCheckedPassword")
            accountEdit.setText(savedInstanceState.getString("savedAccount",null))
            passwordEdit.setText(savedInstanceState.getString("savedPassword",null))
        }
        login.setOnClickListener {
            val account = accountEdit.text.toString()
            val password = passwordEdit.text.toString()
            //如果账号是admin且密码是123456就认为登录成功
            if(account == "admin"&&password == "123456")
            {
                val intent = Intent (this,MainActivity::class.java)
                intent.putExtra("savedAccount",savedInstanceState)
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this,"账号或者密码错误",Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        if(saveAccount.isChecked){

            val tempAccount = accountEdit.text.toString()
            outState.putString("savedAccount",tempAccount)
            outState.putBoolean("isCheckedAccount",true)
        }
        if(savePassword.isChecked){
            saveAccount.isChecked=true
            val tempAccount = accountEdit.text.toString()
            outState.putString("savedAccount",tempAccount)
            outState.putBoolean("isCheckedAccount",true)
            val tempPassword = passwordEdit.text.toString()
            outState.putString("savedPassword",tempPassword)
            outState.putBoolean("isCheckedPassword",true)
        }
    }
}
