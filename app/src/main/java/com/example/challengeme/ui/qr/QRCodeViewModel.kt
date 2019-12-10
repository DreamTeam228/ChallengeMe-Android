package com.example.challengeme.ui.qr

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class QRCodeViewModel : ViewModel() {
        // тут у нас опять обзерв в режиме реального времени
    // в принципе можно тут собирать qr-код
    // идея для кр-кода - передавать строку с датой-временем, разделитель, челленджми, разделитель, айди юзера
    //на сервере можно раздербанить, посмотреть валидность (что это не кр-код 3 дневной давности) и оперировать
    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
            // Генерируем куАр строку
    }

    val qrCodeString: LiveData<String> = _text


    // метод генерации
}