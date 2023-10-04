package com.example.oekakiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.SurfaceView
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val surfaceView: SurfaceView = findViewById(R.id.surfaceView)
        /// CustomSurfaceViewのインスタンスを生成しonTouchリスナーをセット
        val customSurfaceView = CustomSurfaceView(this, surfaceView)
        val blackBtn: Button = findViewById(R.id.blackBtn)
        val redBtn: Button = findViewById(R.id.redBtn)
        val greenBtn: Button = findViewById(R.id.greenBtn)
        val resetBtn: Button = findViewById(R.id.resetBtn)

        surfaceView.setOnTouchListener { v, event ->
            customSurfaceView.onTouch(event)
        }

        /// カラーチェンジボタンにリスナーをセット
        /// CustomSurfaceViewのchangeColorメソッドを呼び出す

        blackBtn.setOnClickListener {
            customSurfaceView.changeColor("black")
        }

        redBtn.setOnClickListener {
            customSurfaceView.changeColor("red")
        }

        greenBtn.setOnClickListener {
            customSurfaceView.changeColor("green")
        }

        /// リセットボタン
        resetBtn.setOnClickListener {
            customSurfaceView.reset()
        }
    }

}