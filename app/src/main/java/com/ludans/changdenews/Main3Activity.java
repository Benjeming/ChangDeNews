package com.ludans.changdenews;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import adapter.MyFragmentAdapter;
import pager.HomePager;
import pager.NewsPager;
import pager.NongYePager;
import utils.LogUtil;

public class Main3Activity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    private RadioButton homeButton;
    private RadioButton newsButton;
    private RadioButton nongyeButton;
    private RadioGroup radioGroup;
    private ViewPager viewPager;
    private static final String TAG = "PAG_CHANGER";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
        initViewForFragment();
    }

    /* *
     * @date 创建时间：2019/8/11  14:40
     * @author ludans
     * @MethodName: initViewForFragment
     * @Param: []
     * @return: void
     * @Description :初始化，将视图转换为 Fragment.
     */
    private void initViewForFragment() {
        //find view
        viewPager = (ViewPager) findViewById(R.id.fragment_view);

        FragmentManager fm = getSupportFragmentManager();

        //初始化数据 ，将 三个Pager页面装入集合中

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomePager());//Page 1
        fragments.add(new NewsPager());//Page 2
        fragments.add(new NongYePager()); // Page 3

        //定义适配器，并使用适配器
        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(fm, fragments);
        viewPager.setAdapter(myFragmentAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            /*
             * 解释：onPageScrolled :
             * */
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }

            @Override
            public void onPageSelected(int i) {
                switch (i){
                    case 0:
                        homeButton.setChecked(true);
                        break;
                        case 1:
                        newsButton.setChecked(true);
                        break;
                        case 2:
                        nongyeButton.setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }

    /* *
     * @date 创建时间：2019/8/11  14:42
     * @author ludans
     * @MethodName: initView
     * @Param: []
     * @return: void
     * @Description :初始化视图，
     */
    private void initView() {
        homeButton = (RadioButton) findViewById(R.id.tab_home);
        newsButton = (RadioButton) findViewById(R.id.tab_news);
        nongyeButton = (RadioButton) findViewById(R.id.tab_nongye);
        radioGroup = (RadioGroup) findViewById(R.id.rg_button);

        //设置RadioGroup 的选中状态改变的 监听 ，状态改变，回调一个ID 过来
        radioGroup.setOnCheckedChangeListener(this);


    }
    /* *
     * @date 创建时间：2019/8/11  16:31
     * @author ludans
     * @MethodName: onCheckedChanged
     * @Param: [group, checkedId ]
     * @return: void
     * @Description : checkedId 是被选中的RadioButton的Id
     */
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.tab_home:
                viewPager.setCurrentItem(0,false);
                break;
            case R.id.tab_news:
                viewPager.setCurrentItem(1,false);
                break;
            case R.id.tab_nongye:
                viewPager.setCurrentItem(2,false);
                break;
        }
    }
}


