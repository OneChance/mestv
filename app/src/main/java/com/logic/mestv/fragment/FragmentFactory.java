package com.logic.mestv.fragment;


import com.logic.mestv.entity.base.Tab;

import java.util.ArrayList;
import java.util.List;

public class FragmentFactory {

    private AFragment aFragment;
    private BFragment bFragment;

    private static FragmentFactory fragmentFactory;

    public static FragmentFactory getInstance() {
        if (fragmentFactory == null) {
            fragmentFactory = new FragmentFactory();
        }
        return fragmentFactory;
    }

    public List<BaseTagFragment> getTabs(List<Tab> tabs) {
        List<BaseTagFragment> tags = new ArrayList<>();

        for (Tab tab : tabs) {
            tags.add(createFragment(tab.getCode()));
        }

        return tags;
    }

    private BaseTagFragment createFragment(String code) {

        switch (code) {
            case "a":
                return (aFragment == null ? aFragment = new AFragment() : aFragment);
            case "b":
                return (bFragment == null ? bFragment = new BFragment() : bFragment);
            default:
                return new BaseTagFragment();
        }

    }
}
