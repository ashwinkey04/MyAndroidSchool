@file:Suppress("DEPRECATION")

package com.example.navdrawer
import android.app.Fragment
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by nir21 on 23-01-2018.
 */
fun AppCompatActivity.replaceFragmenty(fragment: Fragment,
                                       allowStateLoss: Boolean = false,
                                       @IdRes containerViewId: Int) {
    val ft = fragmentManager
        .beginTransaction()
        .replace(containerViewId, fragment)
    if (!supportFragmentManager.isStateSaved) {
        ft.commit()
    } else if (allowStateLoss) {
        ft.commitAllowingStateLoss()
    }
}