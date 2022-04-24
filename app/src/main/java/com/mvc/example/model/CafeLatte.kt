package com.mvc.example.model

class CafeLatte : Beverage() {
    var price = 2500

    override fun add() {
        ++quantity
    }

    override fun delete() {
        --quantity
        if (quantity < 0) {
            quantity = 0
        }
        quantity
    }
}