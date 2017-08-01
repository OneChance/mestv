package com.logic.mestv.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnErrorListener;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnRenderListener;
import com.logic.mestv.R;
import com.logic.mestv.files.FileDownloadBytes;
import com.logic.mestv.files.FileBytesListener;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class PdfViewActivity extends AppCompatActivity implements FileBytesListener {

    @InjectView(R.id.pdfView)
    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_view);
        ButterKnife.inject(this);
        new FileDownloadBytes().getFile("http://10.4.200.76//ceeg/attach/flow/2017/07/25/%E5%8F%8C%E6%96%B9%E7%9B%96%E7%AB%A0%E5%8E%9F%E4%BB%B6.pdf", this);
    }

    @Override
    public void fileCompleted(byte[] bytes) {

        pdfView.fromBytes(bytes).onRender(new OnRenderListener() {
            @Override
            public void onInitiallyRendered(int pages, float pageWidth, float pageHeight) {
                pdfView.fitToWidth();
            }
        }).onLoad(new OnLoadCompleteListener() {
            @Override
            public void loadComplete(int nbPages) {

            }
        }).onError(new OnErrorListener() {
            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }
        }).load();
    }
}
