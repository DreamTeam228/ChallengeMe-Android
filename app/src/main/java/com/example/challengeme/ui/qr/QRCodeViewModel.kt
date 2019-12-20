package com.example.challengeme.ui.qr

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.challengeme.data.globalData.userRepository
import com.google.zxing.BarcodeFormat;
import com.google.zxing.qrcode.QRCodeWriter
import com.journeyapps.barcodescanner.BarcodeEncoder
import java.lang.Exception
import java.util.*


class QRCodeViewModel : ViewModel() {
    val userId = userRepository.instance.user!!.id
    // ��� � ��� ����� ������ � ������ ��������� �������
    // � �������� ����� ��� �������� qr-���
    // ���� ��� ��-���� - ���������� ������ � �����-��������, �����������, ����������, �����������, ���� �����
    //�� ������� ����� ������������, ���������� ���������� (��� ��� �� ��-��� 3 ������� ��������) � �����������
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
            val textToCode = "$currentDate::$userId"
            val qrCodeWriter = QRCodeWriter()
            val bitMatrix = qrCodeWriter.encode(textToCode, BarcodeFormat.QR_CODE, 150, 150)
            val qr = BarcodeEncoder().createBitmap(bitMatrix)
            _qrCode.value = qr
        } catch (e:Exception) {
            e.printStackTrace()
        }

    }
}