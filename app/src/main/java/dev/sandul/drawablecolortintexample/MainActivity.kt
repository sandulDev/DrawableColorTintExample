package dev.sandul.drawablecolortintexample

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.annotation.ColorInt
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat


class MainActivity : AppCompatActivity() {
    lateinit var imageView: ImageView
    lateinit var customColorButton: Button
    lateinit var defaultColorButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        defaultColorButton = findViewById(R.id.defaultButton)
        customColorButton = findViewById(R.id.customButton)
        imageView = findViewById(R.id.imageView)
        defaultColorButton.setOnClickListener { applyColorTintToDrawable(Color.parseColor("#8F8F8F")) }
        customColorButton.setOnClickListener { applyColorTintToDrawable(Color.RED) }
    }

    private fun applyColorTintToDrawable(@ColorInt color: Int) {
        val drawable =
            ContextCompat.getDrawable(baseContext, R.drawable.ic_baseline_emoji_people_24)
        if (drawable != null) {
            val wrappedDrawable = DrawableCompat.wrap(drawable)
            val mutableDrawable = wrappedDrawable.mutate()
            DrawableCompat.setTint(mutableDrawable, color)
            imageView.setImageDrawable(drawable)
        }
    }
}