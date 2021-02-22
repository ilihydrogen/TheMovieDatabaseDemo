package ru.mikhailskiy.intensiv.extensions

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes

fun Context.toast(throwable: Throwable) =
    Toast.makeText(this, throwable.localizedMessage, Toast.LENGTH_LONG).show()

fun Context.toast(string: String) =
    Toast.makeText(this, string, Toast.LENGTH_LONG).show()

fun Context.toast(@StringRes strRes: Int) =
    Toast.makeText(this, strRes, Toast.LENGTH_LONG).show()
