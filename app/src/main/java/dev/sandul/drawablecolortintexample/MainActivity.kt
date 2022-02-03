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
    private lateinit var imageView: ImageView
    private lateinit var redColorButton: Button
    private lateinit var greyColorButton: Button
    private lateinit var greenColorButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        greyColorButton = findViewById(R.id.greyButton)
        redColorButton = findViewById(R.id.redButton)
        greenColorButton = findViewById(R.id.greenButton)
        imageView = findViewById(R.id.imageView)

        greyColorButton.setOnClickListener {
            applyColorTintToDrawable(Color.GRAY)
            imageView.clearColorFilter()
        }
        redColorButton.setOnClickListener {
            applyColorTintToDrawable(Color.RED)
            imageView.clearColorFilter()
        }
        greenColorButton.setOnClickListener { imageView.setColorFilter(Color.GREEN) }
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