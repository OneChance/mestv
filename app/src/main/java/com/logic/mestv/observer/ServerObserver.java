package com.logic.mestv.observer;

import android.content.Context;
import android.widget.TextView;

import com.logic.mestv.MyApplication;
import com.logic.mestv.dialog.MaterialDialog;
import com.logic.mestv.entity.server.ServerResult;

import rx.Observer;


public class ServerObserver implements Observer<ServerResult> {

    public ServerDataReceiver receiver;
    public String code;
    public Context context;
    private MaterialDialog noticeDialog;
    private TextView textView;
    public String content;


    public ServerObserver(final ServerDataReceiver receiver, String code, Context context) {
        this.receiver = receiver;
        this.code = code;
        this.context = context;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        try {
            receiver.serverError(e);
            e.printStackTrace();
        } catch (Exception innerE) {
            innerE.printStackTrace();
        }
    }

    @Override
    public void onNext(ServerResult res) {

        try {

            if (res.getInfo() != null && !res.getInfo().equals("")) {
                MyApplication.toast(res.getInfo(), false);
            }

            if (!res.getCode().equals("0")) {

            } else {
                receiver.setData(res);
                receiver.serverData();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public interface ServerDataReceiver {
        /***
         * 把数据传递给监者
         *
         * @param res 从服务器获得的数据
         */
        void setData(ServerResult res);

        /***
         * 通知监听者使用服务器返回的数据
         */
        void serverData();

        /***
         * 通知监听者响应异常
         */
        void serverError(Throwable e);
    }
}
