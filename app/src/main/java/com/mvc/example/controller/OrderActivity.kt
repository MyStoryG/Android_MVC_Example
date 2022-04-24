package com.mvc.example.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.mvc.example.R
import com.mvc.example.model.Americano
import com.mvc.example.model.TotalPrice

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val americanoModel = Americano()
        val totalPriceModel = TotalPrice()

        val americanoDeleteButton = findViewById<Button>(R.id.americanoDeleteButton)
        val americanoAddButton = findViewById<Button>(R.id.americanoAddButton)
        val americanoCountText = findViewById<TextView>(R.id.americanoCountText)
        val totalPriceText = findViewById<TextView>(R.id.totalPriceText)

        americanoDeleteButton.setOnClickListener {
            americanoModel.delete()
            americanoCountText.text = "${americanoModel.quantity}"
            totalPriceModel.decreaseTotalPrice(americanoModel.price)
            totalPriceText.text = "${totalPriceModel.totalPrice}"
        }

        americanoAddButton.setOnClickListener {
            americanoModel.add()
            americanoCountText.text = "${americanoModel.quantity}"
            totalPriceModel.increaseTotalPrice(americanoModel.price)
            totalPriceText.text = "${totalPriceModel.totalPrice}"
        }
    }
}