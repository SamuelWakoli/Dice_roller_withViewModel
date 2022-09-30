package com.inystudio.dicerollerwithviewmodel

import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {


    //var for config changes
    var diceResult: Int = 1

    //var for activity state changes
    var diceResultName = "com.inystudio.dicerollerwithviewmodel.MainViewModel.diceResult"
}