package com.logic.mestv.net;


import com.squareup.okhttp.ResponseBody;

import retrofit.http.GET;
import retrofit.http.Url;
import rx.Observable;

public interface IFileServices {
    @GET
    Observable<ResponseBody> download(@Url String url);
}
