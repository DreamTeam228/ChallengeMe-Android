package com.example.challengeme.ui.qr

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel



import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.pdf417.encoder.BarcodeMatrix
import com.google.zxing.qrcode.QRCodeWriter
import com.google.zxing.qrcode.encoder.QRCode
import com.journeyapps.barcodescanner.BarcodeEncoder
import java.lang.Exception
import java.util.*


class QRCodeViewModel : ViewModel() {
        // тут у нас опять обзерв в режиме реального времени
    // в принципе можно тут собирать qr-код
    // идея для кр-кода - передавать строку с датой-временем, разделитель, челленджми, разделитель, айди юзера
    //на сервере можно раздербанить, посмотреть валидность (что это не кр-код 3 дневной давности) и оперировать
    private val _qrCode = MutableLiveData<Bitmap>().apply {
        value.apply {
            val bitMatrix = QRCodeWriter().encode(Date().toString(),BarcodeFormat.QR_CODE,150,150)
            value = BarcodeEncoder().createBitmap(bitMatrix)
        }
    }

    val qrCode: LiveData<Bitmap> = _qrCode


    fun generateQR() {
        try {
            val currentDate = Date().toString()
            val textToCode = "ChallengeMe!"
            val qrCodeWriter = QRCodeWriter()
            val bitMatrix = qrCodeWriter.encode(currentDate, BarcodeFormat.QR_CODE, 150, 150)
            val qr = BarcodeEncoder().createBitmap(bitMatrix)
            _qrCode.value = qr
        } catch (e:Exception) {
            e.printStackTrace()
        }

    }
}