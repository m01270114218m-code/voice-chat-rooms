package com.voicerooms.app

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.view.Gravity
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.ScaleAnimation
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {
    private val purple = Color.rgb(125, 76, 190)
    private val white = Color.WHITE
    private val muted = Color.rgb(185, 178, 205)

    override fun onCreate(state: Bundle?) {
        super.onCreate(state)
        setContentView(home())
    }

    private fun home(): LinearLayout {
        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(24, 42, 24, 18)
            background = getDrawable(com.voicerooms.app.R.drawable.bg_farh)
        }

        val brand = TextView(this).apply {
            text = "فرح شات"
            textSize = 30f
            typeface = Typeface.DEFAULT_BOLD
            setTextColor(white)
        }
        root.addView(brand)

        val subtitle = TextView(this).apply {
            text = "غرف صوتية • هدايا • مؤثرات 3D"
            textSize = 14f
            setTextColor(muted)
            setPadding(0, 4, 0, 20)
        }
        root.addView(subtitle)

        val featured = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            setPadding(16, 14, 16, 14)
            background = getDrawable(com.voicerooms.app.R.drawable.card_room)
        }

        val mic = ImageView(this).apply {
            setImageResource(com.voicerooms.app.R.drawable.ic_mic)
            setPadding(14, 14, 14, 14)
            background = circleBackground(purple)
        }
        featured.addView(mic, LinearLayout.LayoutParams(62, 62))

        val fText = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(14, 0, 0, 0)
        }
        fText.addView(label("الغرفة المميزة", 12f, muted))
        fText.addView(label("Royal Lounge", 20f, white, true))
        fText.addView(label("8 مقاعد • مباشر الآن", 13f, muted))
        featured.addView(fText, LinearLayout.LayoutParams(0, -2, 1f))
        root.addView(featured, LinearLayout.LayoutParams(-1, -2))

        mic.startAnimation(ScaleAnimation(0.94f, 1.06f, 0.94f, 1.06f,
            ScaleAnimation.RELATIVE_TO_SELF, 0.5f,
            ScaleAnimation.RELATIVE_TO_SELF, 0.5f).apply {
            duration = 900
            repeatMode = ScaleAnimation.REVERSE
            repeatCount = ScaleAnimation.INFINITE
        })

        root.addView(label("الغرف الصوتية", 21f, white, true).apply { setPadding(0, 26, 0, 12) })

        val rooms = listOf(
            Triple("Royal Lounge", "قاعة ملكية • 8 مقاعد", com.voicerooms.app.R.drawable.ic_star),
            Triple("Galaxy Night", "ليلة مجرية • 8 مقاعد", com.voicerooms.app.R.drawable.ic_people),
            Triple("Diamond Club", "نادي الماس • 8 مقاعد", com.voicerooms.app.R.drawable.ic_gift)
        )

        rooms.forEach { room ->
            val card = LinearLayout(this).apply {
                orientation = LinearLayout.HORIZONTAL
                gravity = Gravity.CENTER_VERTICAL
                setPadding(14, 12, 14, 12)
                background = getDrawable(com.voicerooms.app.R.drawable.card_room)
                isClickable = true
                setOnClickListener { pulse(this) }
            }
            val icon = ImageView(this).apply {
                setImageResource(room.third)
                setPadding(12, 12, 12, 12)
                background = circleBackground(Color.rgb(62, 42, 92))
            }
            card.addView(icon, LinearLayout.LayoutParams(54, 54))
            val textBox = LinearLayout(this).apply {
                orientation = LinearLayout.VERTICAL
                setPadding(14, 0, 0, 0)
            }
            textBox.addView(label(room.first, 17f, white, true))
            textBox.addView(label(room.second, 12f, muted))
            card.addView(textBox, LinearLayout.LayoutParams(0, -2, 1f))
            val join = label("دخول", 13f, white, true).apply {
                setPadding(16, 10, 16, 10)
                background = roundedPurple()
            }
            card.addView(join)
            root.addView(card, LinearLayout.LayoutParams(-1, 78).apply { bottomMargin = 10 })
        }

        val nav = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER
            setPadding(6, 10, 6, 0)
        }
        listOf(
            Pair(com.voicerooms.app.R.drawable.ic_home, "الرئيسية"),
            Pair(com.voicerooms.app.R.drawable.ic_people, "الغرف"),
            Pair(com.voicerooms.app.R.drawable.ic_gift, "الهدايا"),
            Pair(com.voicerooms.app.R.drawable.ic_profile, "حسابي")
        ).forEach { item ->
            val cell = LinearLayout(this).apply {
                orientation = LinearLayout.VERTICAL
                gravity = Gravity.CENTER
            }
            cell.addView(ImageView(this).apply { setImageResource(item.first) },
                LinearLayout.LayoutParams(26, 26))
            cell.addView(label(item.second, 10f, muted))
            nav.addView(cell, LinearLayout.LayoutParams(0, 54, 1f))
        }
        root.addView(nav)
        return root
    }

    private fun label(text: String, size: Float, color: Int, bold: Boolean = false) =
        TextView(this).apply {
            this.text = text
            textSize = size
            setTextColor(color)
            if (bold) typeface = Typeface.DEFAULT_BOLD
        }

    private fun circleBackground(color: Int) =
        GradientDrawable().apply { shape = GradientDrawable.OVAL; setColor(color) }

    private fun roundedPurple() =
        GradientDrawable().apply { cornerRadius = 28f; setColor(purple) }

    private fun pulse(view: View) {
        view.startAnimation(AlphaAnimation(1f, 0.65f).apply { duration = 120; repeatCount = 1; repeatMode = AlphaAnimation.REVERSE })
    }
}
