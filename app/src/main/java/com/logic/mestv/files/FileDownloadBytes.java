package com.logic.mestv.files;

import com.logic.mestv.net.FileDownloadUtil;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;

import rx.functions.Action1;
import rx.schedulers.Schedulers;


public class FileDownloadBytes extends FileDownloadUtil {

    public void getFile(String url, final FileBytesListener fileBytesListener) {
        getFileService(url).download("").subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe(new Action1<ResponseBody>() {
            @Override
            public void call(ResponseBody responseBody) {
                try {
                    fileBytesListener.fileCompleted(responseBody.bytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
