package com.rasel.expendablefloatingactionbar

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var fab_main: FloatingActionButton
    private lateinit var fab1_mail: FloatingActionButton
    private lateinit var fab3_share: FloatingActionButton
    private lateinit var fab2_bookmark: FloatingActionButton
    private lateinit var fab_open: Animation
    private lateinit var fab_close: Animation
    private lateinit var fab_clock: Animation
    private lateinit var fab_anticlock: Animation
    var isOpen = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab_main = findViewById(R.id.fab)
        fab1_mail = findViewById(R.id.fab1)
        fab2_bookmark = findViewById(R.id.fab2)
        fab3_share = findViewById(R.id.fab3)
        fab_close = AnimationUtils.loadAnimation(applicationContext, R.anim.fab_close)
        fab_open = AnimationUtils.loadAnimation(applicationContext, R.anim.fab_open)
        fab_clock = AnimationUtils.loadAnimation(applicationContext, R.anim.fab_rotate_clock)
        fab_anticlock = AnimationUtils.loadAnimation(applicationContext, R.anim.fab_rotate_anticlock)

        fab_main.setOnClickListener{
            isOpen = if (isOpen) {
                fab3_share.startAnimation(fab_close)
                fab2_bookmark.startAnimation(fab_close)
                fab1_mail.startAnimation(fab_close)
                fab_main.startAnimation(fab_anticlock)
                fab3_share.setClickable(false)
                fab2_bookmark.setClickable(false)
                fab1_mail.setClickable(false)
                false
            } else {
                fab3_share.startAnimation(fab_open)
                fab2_bookmark.startAnimation(fab_open)
                fab1_mail.startAnimation(fab_open)
                fab_main.startAnimation(fab_clock)
                fab3_share.setClickable(true)
                fab2_bookmark.setClickable(true)
                fab1_mail.setClickable(true)
                true
            }
        }
        fab3_share.setOnClickListener{ Toast.makeText(applicationContext, "Share", Toast.LENGTH_SHORT).show() }
        fab1_mail.setOnClickListener{ Toast.makeText(applicationContext, "Email", Toast.LENGTH_SHORT).show() }
    }
}