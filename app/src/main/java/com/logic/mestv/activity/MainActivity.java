package com.logic.mestv.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.logic.mestv.MyApplication;
import com.logic.mestv.R;
import com.logic.mestv.entity.base.Tab;
import com.logic.mestv.fragment.BaseTagFragment;
import com.logic.mestv.presenter.main.IMain;
import com.logic.mestv.presenter.main.MainPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends AppCompatActivity implements IMain {

    Activity activity;
    @InjectView(R.id.main_viewpager)
    ViewPager viewPager;
    @InjectView(R.id.main_tabs)
    TabLayout tabLayout;
    MainPresenter mainPresenter;
    private Context context;
    ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.mainpage);
        ButterKnife.inject(this);
        context = this;
        activity = this;

        FragmentManager fragmentManager = getSupportFragmentManager();
        adapter = new ViewPagerAdapter(fragmentManager);
        mainPresenter = new MainPresenter(this, context);

        List<Tab> tabs = new ArrayList<>();


        Tab tabA = new Tab();
        tabA.setCode("a");
        Tab tabB = new Tab();
        tabB.setCode("b");
        tabs.add(tabA);
        tabs.add(tabB);

        mainPresenter.getAuthTags(tabs);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        MyApplication.addActivity(this);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
    }

    @Override
    public void setTags(List<BaseTagFragment> tags) {
        for (BaseTagFragment tag : tags) {
            if (tag.tabName > 0) {
                adapter.addFrag(tag, getResources().getText(tag.tabName).toString());
            }
        }
        viewPager.setAdapter(adapter);
    }

    static class ViewPagerAdapter extends FragmentPagerAdapter {

        private final List<BaseTagFragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        ViewPagerAdapter(android.support.v4.app.FragmentManager manager) {
            super(manager);
        }

        @Override
        public BaseTagFragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(BaseTagFragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
