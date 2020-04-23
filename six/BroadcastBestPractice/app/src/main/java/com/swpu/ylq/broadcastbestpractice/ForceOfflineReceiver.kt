package com.swpu.ylq.broadcastbestpractice

import android.app.AlertDialog
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class ForceOfflineReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
      AlertDialog.Builder(context).apply {
          setTitle("Warning")
          setMessage("You are forced to be offline,Please try ti login again.")
          setCancelable(false)
          setPositiveButton("OK"){_,_ ->
              ActicityCollector.finishAll()
              val  i=Intent(context,LoginActivity::class.java)
              context.startActivity(i)
          }
          show()
      }
    }
}
