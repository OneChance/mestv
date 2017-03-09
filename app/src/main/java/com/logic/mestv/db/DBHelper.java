package com.logic.mestv.db;

import android.content.Context;

import com.litesuits.orm.LiteOrm;
import com.litesuits.orm.db.DataBaseConfig;

public class DBHelper {

    private static LiteOrm liteOrm;

    public static LiteOrm getInstance(Context context) {
        if (liteOrm == null) {
            DataBaseConfig config = new DataBaseConfig(context, "data.tab_a");
            config.debugged = true;
            config.dbVersion = 1;
            config.onUpdateListener = null;
            liteOrm = LiteOrm.newCascadeInstance(config);
        }

        return liteOrm;
    }
}
