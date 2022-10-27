package com.ieseljust.pmdm.exemplesmenus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

// Ara MainActivity ja no deriva de AppCompatActivity
// sinò de ActivityWithMenu
class SecondActivity : ActivityWithMenu() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }
}