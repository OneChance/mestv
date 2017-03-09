package com.logic.mestv.entity.server;


import com.logic.mestv.MyApplication;
import com.logic.mestv.R;

import java.util.Map;

public class ServerResult {

    public String code;
    public String info;
    public BagData datas;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public BagData getDatas() {
        return datas;
    }

    public void setDatas(BagData datas) {
        this.datas = datas;
    }

    public String getVal(String value) {
        try {
            if (datas.getBagDatas() != null && datas.getBagDatas().size() > 0) {
                Map<String, String> dataMap = datas.getBagDatas().get(0);
                return dataMap.get(value) == null ? "" : dataMap.get(value);
            }
        } catch (Exception e) {
            MyApplication.toast(value + MyApplication.getResString(R.string.server_error), false);
        }
        return "";
    }


    @Override
    public String toString() {
        return "[code:" + this.code + "][info:" + this.info + "]";
    }
}
