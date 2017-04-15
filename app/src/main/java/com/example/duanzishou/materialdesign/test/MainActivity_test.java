package com.example.duanzishou.materialdesign.test;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.duanzishou.materialdesign.R;
import com.example.duanzishou.materialdesign.test.fragments.BlankFragment;
import com.example.duanzishou.materialdesign.test.fragments.BlankFragment2;
import com.example.duanzishou.materialdesign.test.fragments.BlankFragment3;
import com.example.duanzishou.materialdesign.test.fragments.Find_tab_Adapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity_test extends AppCompatActivity implements View.OnClickListener {

    private TabLayout mTablayoutTest;
    private ViewPager mViewpagerTest;
    private FragmentPagerAdapter fAdapter;                               //定义adapter

    private List<Fragment> list_fragment;                                //定义要装fragment的列表
    private List<String> list_title;                                     //tab名称列表

    private BlankFragment hotRecommendFragment;              //热门推荐fragment
    private BlankFragment2 hotCollectionFragment;            //热门收藏fragment
    private BlankFragment3 hotMonthFragment;                      //本月热榜fragment

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_test);
        initView();
    }

    private void initView() {
        mTablayoutTest = (TabLayout) findViewById(R.id.tablayout_test);
        mTablayoutTest.setOnClickListener(this);
        mViewpagerTest = (ViewPager) findViewById(R.id.viewpagerTest);
        mViewpagerTest.setOnClickListener(this);
        //初始化各fragment
        hotRecommendFragment = new BlankFragment();
        hotCollectionFragment = new BlankFragment2();
        hotMonthFragment = new BlankFragment3();
        list_fragment = new ArrayList<>();
        list_fragment.add(hotRecommendFragment);
        list_fragment.add(hotCollectionFragment);
        list_fragment.add(hotMonthFragment); //将名称加载tab名字列表，正常情况下，我们应该在values/arrays.xml中进行定义然后调用
        list_title = new ArrayList<>();
        list_title.add("热门推荐");
        list_title.add("热门收藏");
        list_title.add("本月热榜"); //设置TabLayout的模式
        mTablayoutTest.setTabMode(TabLayout.MODE_FIXED);
        //为TabLayout添加tab名称
        mTablayoutTest.addTab(mTablayoutTest.newTab().setText(list_title.get(0)));
        mTablayoutTest.addTab(mTablayoutTest.newTab().setText(list_title.get(1)));
        mTablayoutTest.addTab(mTablayoutTest.newTab().setText(list_title.get(2)));
        fAdapter = new Find_tab_Adapter(MainActivity_test.this.getSupportFragmentManager(), list_fragment, list_title);

        //viewpager加载adapter
        mViewpagerTest.setAdapter(fAdapter);
        //tab_FindFragment_title.setViewPager(vp_FindFragment_pager);
        //TabLayout加载viewpager
        mTablayoutTest.setupWithViewPager(mViewpagerTest);
        //tab_FindFragment_title.set

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tablayout_test:
                break;
            case R.id.viewpagerTest:
                break;
        }
    }
}
