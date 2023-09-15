package com.example.myreader

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.github.barteksc.pdfviewer.PDFView
import java.net.URI

class PdfActivity : AppCompatActivity() {


    lateinit var pdf: PDFView
    val PDF_SELECTION_CODE = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf)

        pdf = findViewById(R.id.pdf_view)

        selectPdf()
    }

    private fun selectPdf() {

        val browse = Intent(Intent.ACTION_GET_CONTENT)
        browse.type = "application/pdf"
        browse.addCategory(Intent.CATEGORY_OPENABLE)
        startActivityForResult(Intent.createChooser(browse,"Select PDF"), PDF_SELECTION_CODE)
    }


    fun showPdfFromUri(uri: Uri?) {
        pdf.fromUri(uri)
            .defaultPage(0)
            .spacing(10)
            .load()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PDF_SELECTION_CODE && resultCode == Activity.RESULT_OK && data != null) {
            Log.d("deep", "hi")
            val selectedPdf = data.data
            showPdfFromUri(selectedPdf)
        }
    }
}