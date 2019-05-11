package com.tjedit.fragmentpractice01;

import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.tjedit.fragmentpractice01.adapters.PageAdapter;
import com.tjedit.fragmentpractice01.databinding.ActivityMainBinding;
import com.tjedit.fragmentpractice01.fragments.FragmentTwo;

public class MainActivity extends BaseActivity {

    ActivityMainBinding act;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindViews();
        setupEvents();
        setupValues();
    }

    @Override
    public void setupEvents() {
        act.changeFragOneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                act.viewPager.setCurrentItem(0);
                act.changeFragOneBtn.setText("현재 선택됨");
                act.changeFragTwoBtn.setText("2번 플래그먼트");
                act.changeFragThreeBtn.setText("3번 플래그먼트");
            }
        });
        act.changeFragTwoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Fragment fr = new FragmentTwo();
//
//                FragmentManager fragmentManager = getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.fragOne,fr);
//                fragmentTransaction.commit();
//                2번 화면 버튼을 누름 = > 2번째 페이지를 보여주자.
                act.viewPager.setCurrentItem(1);
                act.changeFragOneBtn.setText("1번 플래그먼트");
                act.changeFragTwoBtn.setText("현재 선택됨");
                act.changeFragThreeBtn.setText("3번 플래그먼트");

            }
        });
        act.changeFragThreeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                act.viewPager.setCurrentItem(2);
                act.changeFragOneBtn.setText("1번 플래그먼트");
                act.changeFragTwoBtn.setText("2번 플래그먼트");
                act.changeFragThreeBtn.setText("현재 선택됨");

            }
        });


    }

    @Override
    public void setupValues() {
        PageAdapter pageAdapter = new PageAdapter(getSupportFragmentManager(),3);
        act.viewPager.setAdapter(pageAdapter);



    }

    @Override
    public void bindViews() {

            act = DataBindingUtil.setContentView(this,R.layout.activity_main);
    }
}
