package com.dc.hellokntlin.util

import android.content.Context
import android.view.Gravity
import android.widget.Toast

/**
 * Toast
 * Created by dc on 2017-08-28
 */

object ToastUtil {

    fun show(context: Context, obj: Any?) {
        if (obj != null) {
            val toast = Toast.makeText(context, obj.toString(), Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.show()
        } else {
            val toast = Toast.makeText(context, "null 空字符", Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.show()
        }
    }


}
