package com.eliseche.androidseed.extensions

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

// Handles TextChangedListener to provide a simpler onChange callback
fun EditText.onChange(block: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            block(s.toString())
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    })
}