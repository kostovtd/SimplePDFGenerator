package com.example.kostovtd.simplepdfgenerator

import android.graphics.pdf.PdfDocument
import android.os.Bundle
import android.os.Environment
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonEmptyPdf.setOnClickListener {
            createEmptyPdf()
        }

        buttonPdfWithText.setOnClickListener {
            Toast.makeText(this@MainActivity, "PDF with text clicked", Toast.LENGTH_LONG).show()
        }

        buttonPdfWithImage.setOnClickListener {
            Toast.makeText(this@MainActivity, "PDF with image clicked", Toast.LENGTH_LONG).show()
        }
    }


    private fun createEmptyPdf() {
        Log.d(TAG, "createEmptyPdf: hit")
        val pdfDocument = PdfDocument()
        val pageInfo = PdfDocument.PageInfo.Builder(100, 100, 1).create()
        val page = pdfDocument.startPage(pageInfo)

        pdfDocument.finishPage(page)

        try {
            val fileName = "empty"
            val fileExtension = ".pdf"
            val storageDir = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)
            val file = File.createTempFile(fileName, fileExtension, storageDir)
            val fileOutputStream = FileOutputStream(file)
            pdfDocument.writeTo(fileOutputStream)
            pdfDocument.close()
            Snackbar.make(rootContainer, "File created", Snackbar.LENGTH_LONG).show()
        } catch (e: FileNotFoundException) {
            Log.e(TAG, e.message)
        }
    }


    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }
}