package com.example.challengeme.ui.qr

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.journeyapps.barcodescanner.BarcodeEncoder

/*
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
*/

class QRCodeViewModel : ViewModel() {
        // тут у нас опять обзерв в режиме реального времени
    // в принципе можно тут собирать qr-код
    // идея для кр-кода - передавать строку с датой-временем, разделитель, челленджми, разделитель, айди юзера
    //на сервере можно раздербанить, посмотреть валидность (что это не кр-код 3 дневной давности) и оперировать
    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
            // Генерируем куАр строку

            /*try {
                val bm : BitMatrix = encodeAsBitmap("challengeme", BarcodeFormat.QR_CODE, 150, 150)
            }

            try {
                val bitMatrix: BitMatrix =
                    multiFormatWriter.encode(text, BarcodeFormat.QR_CODE, 200, 200)
                val barcodeEncoder = BarcodeEncoder()
                val bitmap = barcodeEncoder.createBitmap(bitMatrix)
                qrCode.setImageBitmap(bitmap)
            } catch (e: WriterException) {
                e.printStackTrace()
            }*/
    }

    val qrCodeString: LiveData<String> = _text


    // метод генерации
}