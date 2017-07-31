package com.logic.mestv.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnErrorListener;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.logic.mestv.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class PdfViewActivity extends AppCompatActivity {

    @InjectView(R.id.pdfView)
    PDFView pdfView;
    @InjectView(R.id.next)
    Button bNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_view);
        ButterKnife.inject(this);
        pdfView.fromUri(Uri.parse("http://file.chmsp.com.cn/colligate/file/00100000224821.pdf")).onLoad(new OnLoadCompleteListener() {
            @Override
            public void loadComplete(int nbPages) {
                Log.d("mestv", "load complete");
            }
        }).onError(new OnErrorListener() {
            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }
        });

        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });


    }
}
