package com.example.rich.hellocompat

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v4.content.ContextCompat
import android.view.View
import java.util.*


class MainActivity : AppCompatActivity() {

    private var mHelloTextView: TextView? = null
    private val mColorArray = arrayOf("red", "pink", "purple", "deep_purple", "indigo", "blue",
            "light_blue", "cyan", "teal", "green", "light_green", "lime", "yellow", "amber",
            "orange", "deep_orange", "brown", "grey", "blue_grey", "black")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mHelloTextView = hello_textview
        // restore saved instance state (the text color)
        if (savedInstanceState != null) {
            mHelloTextView!!.setTextColor(savedInstanceState.getInt("color"))
        }
    }

    public override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        // save the current text color
        outState.putInt("color", mHelloTextView!!.getCurrentTextColor())
    }

    fun changeColor(view: View) {
        // get a random color name from the color array (20 colors)
        val random = Random()
        val colorName = mColorArray[random.nextInt(20)]

        // get the color identifier that matches the color name
        val colorResourceName = resources.getIdentifier(colorName, "color",
                applicationContext.packageName)

        // get the color ID from the resources
        val colorRes = ContextCompat.getColor(this, colorResourceName)

        // Set the text color
        mHelloTextView!!.setTextColor(colorRes)
    }
}
