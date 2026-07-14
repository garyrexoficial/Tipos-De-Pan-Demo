package com.garyrex.tiposdepandemo.ui.transform

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TransformViewModel : ViewModel() {

    private val _texts = MutableLiveData<List<String>>().apply {
        value = listOf(
            "Concha",
            "Bolillo",
            "Cuernito",
            "Oreja",
            "Pan de muerto",
            "Rosca de reyes",
            "Telera",
            "Chocolatín",
            "Rebanada",
            "Bigote",
            "Mantecada",
            "Empanada",
            "Bisquet",
            "Dona",
            "Mollete",
            "Cocol"
        )
    }

    val texts: LiveData<List<String>> = _texts
}
