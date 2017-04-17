package com.example.duanzishou.materialdesign.test;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Transition;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.duanzishou.materialdesign.R;
import com.example.duanzishou.materialdesign.test.fragments.BlankFragment_tab;
import com.example.duanzishou.materialdesign.test.fragments.BlankFragment_tab2;
import com.example.duanzishou.materialdesign.test.fragments.BlankFragment_tab3;
import com.example.duanzishou.materialdesign.test.fragments.BlankFragment_tab4;

import org.w3c.dom.Text;

public class MainActivity_Home extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout mLinear, mLinear2, mLinear3, mLinear4;
    private ImageView mImg, mImg2, mImg3, mImg4;
    private TextView mTlt, mTlt2, mTlt3, mTlt4,mTlt_txt;
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private FragmentTransaction fragmentTransaction;
    private BlankFragment_tab blankFragment_tab;
    private BlankFragment_tab2 blankFragment_tab2;
    private BlankFragment_tab3 blankFragment_tab3;
    private BlankFragment_tab4 blankFragment_tab4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__home);
        initView();
    }

    private void initView() {
        mTlt_txt= (TextView) findViewById(R.id.include_title);
        mLinear = (LinearLayout) findViewById(R.id.line1);
        mLinear2 = (LinearLayout) findViewById(R.id.line2);
        mLinear3 = (LinearLayout) findViewById(R.id.line3);
        mLinear4 = (LinearLayout) findViewById(R.id.line4);
        mImg = (ImageView) findViewById(R.id.img1);
        mImg2 = (ImageView) findViewById(R.id.img2);
        mImg3 = (ImageView) findViewById(R.id.img3);
        mImg4 = (ImageView) findViewById(R.id.img4);
        mTlt = (TextView) findViewById(R.id.tlt1);
        mTlt2 = (TextView) findViewById(R.id.tlt2);
        mTlt3 = (TextView) findViewById(R.id.tlt3);
        mTlt4 = (TextView) findViewById(R.id.tlt4);
        mLinear.setOnClickListener(this);
        mLinear2.setOnClickListener(this);
        mLinear3.setOnClickListener(this);
        mLinear4.setOnClickListener(this);
        setBottombar(0);
        startLoding();
    }

    @Override
    public void onClick(View v) {
        fragmentTransaction = fragmentManager.beginTransaction();
        HideFrament();
        switch (v.getId()) {
            case R.id.line1:
                setBottombar(0);
                if (blankFragment_tab == null) {
                    blankFragment_tab = new BlankFragment_tab();
                    fragmentTransaction.add(R.id.content_group_zhong, blankFragment_tab);
                } else {
                    fragmentTransaction.show(blankFragment_tab);
                }

                break;
            case R.id.line2:
                setBottombar(1);
                if (blankFragment_tab2 == null) {
                    blankFragment_tab2 = new BlankFragment_tab2();
                    fragmentTransaction.add(R.id.content_group_zhong, blankFragment_tab2);
                } else {
                    fragmentTransaction.show(blankFragment_tab2);
                }
                break;
            case R.id.line3:
                setBottombar(2);
                if (blankFragment_tab3 == null) {
                    blankFragment_tab3 = new BlankFragment_tab3();
                    fragmentTransaction.add(R.id.content_group_zhong, blankFragment_tab3);
                } else {
                    fragmentTransaction.show(blankFragment_tab3);
                }
                break;
            case R.id.line4:
                setBottombar(3);
                if (blankFragment_tab4 == null) {
                    blankFragment_tab4 = new BlankFragment_tab4();
                    fragmentTransaction.add(R.id.content_group_zhong, blankFragment_tab4);
                } else {
                    fragmentTransaction.show(blankFragment_tab4);
                }
                break;
        }
        fragmentTransaction.commit();
    }

    private void startLoding() {
        fragmentTransaction = fragmentManager.beginTransaction();
        HideFrament();
        blankFragment_tab = new BlankFragment_tab();
        fragmentTransaction.add(R.id.content_group_zhong, blankFragment_tab);
        fragmentTransaction.commit();
    }



    private void HideFrament() {
        if (blankFragment_tab != null) {
            fragmentTransaction.hide(blankFragment_tab);
        }
        if (blankFragment_tab2 != null) {
            fragmentTransaction.hide(blankFragment_tab2);
        }
        if (blankFragment_tab3 != null) {
            fragmentTransaction.hide(blankFragment_tab3);
        }
        if (blankFragment_tab4 != null) {
            fragmentTransaction.hide(blankFragment_tab4);
        }
    }

    public void setBottombar(int num) {
        mImg.setImageResource(R.mipmap.message_select);
        mImg2.setImageResource(R.mipmap.message_select);
        mImg3.setImageResource(R.mipmap.message_select);
        mImg4.setImageResource(R.mipmap.message_select);
        mTlt.setTextColor(getResources().getColor(R.color.colorPrimary));
        mTlt2.setTextColor(getResources().getColor(R.color.colorPrimary));
        mTlt3.setTextColor(getResources().getColor(R.color.colorPrimary));
        mTlt4.setTextColor(getResources().getColor(R.color.colorPrimary));
        switch (num) {
            case 0:
                mTlt_txt.setText("首页1");
                mImg.setImageResource(R.mipmap.my_normal);
                mTlt.setTextColor(getResources().getColor(R.color.colorAccent));
                break;
            case 1:
                mTlt_txt.setText("首页2");
                mImg2.setImageResource(R.mipmap.my_normal);
                mTlt2.setTextColor(getResources().getColor(R.color.colorAccent));
                break;
            case 2:
                mTlt_txt.setText("首页3");
                mImg3.setImageResource(R.mipmap.my_normal);
                mTlt3.setTextColor(getResources().getColor(R.color.colorAccent));
                break;
            case 3:
                mTlt_txt.setText("首页4");
                mImg4.setImageResource(R.mipmap.my_normal);
                mTlt4.setTextColor(getResources().getColor(R.color.colorAccent));
                break;
        }

    }
}
