
package com.qwenai.app

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.widget.*

class MainActivity : Activity() {

    private val bg = Color.rgb(18, 18, 25)
    private val accent = Color.rgb(120, 95, 255)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.statusBarColor = bg
        window.navigationBarColor = bg

        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(bg)
            setPadding(18, 20, 18, 12)
        }

        val title = TextView(this).apply {
            text = "QWEN AI"
            textSize = 27f
            setTextColor(Color.WHITE)
            gravity = Gravity.CENTER
        }

        val subtitle = TextView(this).apply {
            text = "Your personal AI assistant"
            textSize = 13f
            setTextColor(Color.LTGRAY)
            gravity = Gravity.CENTER
        }

        val chat = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(4, 20, 4, 12)
        }

        val scroll = ScrollView(this).apply {
            addView(chat)
        }

        val welcome = TextView(this).apply {
            text = "Hello. I'm QWEN AI.\n\nYour private AI assistant is getting ready."
            textSize = 17f
            setTextColor(Color.WHITE)
            setPadding(16, 18, 16, 18)
            setBackgroundColor(Color.rgb(38, 38, 52))
        }

        chat.addView(welcome)

        val inputRow = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
        }

        val input = EditText(this).apply {
            hint = "Ask QWEN anything..."
            setHintTextColor(Color.GRAY)
            setTextColor(Color.WHITE)
            textSize = 15f
            setSingleLine(true)
            setPadding(14, 10, 14, 10)
            setBackgroundColor(Color.rgb(38, 38, 52))
        }

        val send = Button(this).apply {
            text = "Send"
            setTextColor(Color.WHITE)
            setBackgroundColor(accent)
        }

        inputRow.addView(input, LinearLayout.LayoutParams(0, 55, 1f))
        inputRow.addView(send)

        send.setOnClickListener {
            val message = input.text.toString().trim()

            if (message.isNotEmpty()) {
                val userMessage = TextView(this).apply {
                    text = "You: $message"
                    textSize = 16f
                    setTextColor(Color.WHITE)
                    setPadding(14, 14, 14, 14)
                    setBackgroundColor(Color.rgb(55, 48, 85))
                }

                chat.addView(userMessage)

                val reply = TextView(this).apply {
                    text = "QWEN AI: The AI engine will be connected in the next step."
                    textSize = 15f
                    setTextColor(Color.LTGRAY)
                    setPadding(14, 14, 14, 14)
                }

                chat.addView(reply)
                input.text.clear()
                scroll.post { scroll.fullScroll(ScrollView.FOCUS_DOWN) }
            }
        }

        root.addView(title)
        root.addView(subtitle)

        root.addView(
            scroll,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                0,
                1f
            )
        )

        root.addView(inputRow)
        setContentView(root)
    }
}
