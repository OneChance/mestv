package com.logic.mestv.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.logic.mestv.R;
import com.logic.mestv.activity.PdfViewActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;

import static com.logic.mestv.R.layout.tab_b;

public class BFragment extends BaseTagFragment {

    View view;
    @InjectView(R.id.pdf)
    Button pdf;

    public BFragment() {
        this.tabName = R.string.b_tab_name;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);

        view = inflater.inflate(tab_b, container, false);

        ButterKnife.inject(this, view);

        pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BFragment.this.getActivity(), PdfViewActivity.class);
                BFragment.this.getActivity().startActivity(i);
            }
        });

        return view;
    }
}
