package com.tjedit.fragmentpractice01;

import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.tjedit.fragmentpractice01.adapters.PageAdapter;
import com.tjedit.fragmentpractice01.databinding.ActivityMainBinding;
import com.tjedit.fragmentpractice01.fragments.FragmentOne;
import com.tjedit.fragmentpractice01.fragments.FragmentTwo;

public class MainActivity extends BaseActivity {

    ActivityMainBinding act;
    PageAdapter pageAdapter;

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

        act.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if (i == 0) {
                    act.changeFragOneBtn.setText("현재 선택됨");
                    act.changeFragTwoBtn.setText("2번 플래그먼트");
                    act.changeFragThreeBtn.setText("3번 플래그먼트");
                }
                if (i == 1) {
                    act.changeFragOneBtn.setText("1번 플래그먼트");
                    act.changeFragTwoBtn.setText("현재 선택됨");
                    act.changeFragThreeBtn.setText("3번 플래그먼트");
                }
                if (i == 2) {
                    act.changeFragOneBtn.setText("1번 플래그먼트");
                    act.changeFragTwoBtn.setText("2번 플래그먼트");
                    act.changeFragThreeBtn.setText("현재 선택됨");


                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        act.okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                지금 보여지고 있는 Fragment에 접근 - > 현재 작성중인 MainActivity에서?
//                2. 접근한 Fragment에게 어떻게 작업을 시킬건지?
                Fragment currentFrag = pageAdapter.getItem(act.viewPager.getCurrentItem());
                if (act.viewPager.getCurrentItem() == 0) {
//                currentFrag가 FragmentOne이다!
                    ((FragmentOne)currentFrag).changeTextMsg(act.testEdt.getText().toString());
                } else if (act.viewPager.getCurrentItem() == 1) {
//                currentFrag 가 FragmentTwo!
                } else if (act.viewPager.getCurrentItem() == 2) {

                }
            }
        });


    }

    @Override
    public void setupValues() {
        act.viewPager.setOffscreenPageLimit(3);//프래그먼의 갯수와 맞춰주자
        pageAdapter = new PageAdapter(getSupportFragmentManager(), 3);
        act.viewPager.setAdapter(pageAdapter);


    }

    @Override
    public void bindViews() {

        act = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }
}
