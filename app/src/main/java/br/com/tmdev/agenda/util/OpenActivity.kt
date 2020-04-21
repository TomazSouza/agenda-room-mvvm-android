package br.com.tmdev.agenda.util

import android.app.Activity
import android.content.Intent
import android.os.Bundle

class OpenActivity private constructor() {

    companion object {

        fun start(activity: Activity?, clazz: Class<*>?,
                  finish: Boolean?, args: Bundle?) {

            val intent = Intent(activity, clazz)

            if (args != null) {
                intent.putExtras(args)
                activity?.startActivity(intent)
            } else {
                activity?.startActivity(intent)
            }

            if (finish != null && finish) {
                activity?.finish()
            }
        }

    }

}