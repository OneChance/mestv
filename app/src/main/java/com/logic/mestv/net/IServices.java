package com.logic.mestv.net;


import com.logic.mestv.entity.server.ServerResult;

import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;
import rx.Observable;

public interface IServices {
    @FormUrlEncoded
    @POST("intface/tabs/")
    public Observable<ServerResult> getTabs();
}
