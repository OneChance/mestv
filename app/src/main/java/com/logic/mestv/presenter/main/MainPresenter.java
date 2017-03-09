package com.logic.mestv.presenter.main;

import android.content.Context;

import com.logic.mestv.entity.base.Tab;
import com.logic.mestv.fragment.BaseTagFragment;
import com.logic.mestv.fragment.FragmentFactory;

import java.util.List;

public class MainPresenter {
    private IMain iMain;

    public MainPresenter(IMain iMain, final Context context) {
        this.iMain = iMain;
    }

    public void getAuthTags(List<Tab> tabs) {
        List<BaseTagFragment> tags = FragmentFactory.getInstance().getTabs(tabs);
        iMain.setTags(tags);
    }

}
