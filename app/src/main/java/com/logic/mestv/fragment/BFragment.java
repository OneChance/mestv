package com.logic.mestv.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.logic.mestv.R;

import butterknife.ButterKnife;

import static com.logic.mestv.R.layout.tab_b;

public class BFragment extends BaseTagFragment {

    View view;

    public BFragment() {
        this.tabName = R.string.b_tab_name;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);

        view = inflater.inflate(tab_b, container, false);

        ButterKnife.inject(this, view);

        return view;
    }
}
