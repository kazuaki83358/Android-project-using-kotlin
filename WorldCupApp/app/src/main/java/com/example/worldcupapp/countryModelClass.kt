package com.example.worldcupapp

class countryModelClass(val countryName: String, val cupsWin: String, val countryFlag: Int) {

    fun getImageResourceId(): Int {
        // Assuming that the countryFlag directly represents the resource ID
        return countryFlag
    }
}
