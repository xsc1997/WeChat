package com.example.simpleton.wechat;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioGroup;
//1.加载fragment
//2.相应RadioButton的点击事件
//3.加载ToolBar的菜单
//4.菜单的响应
public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, Toolbar.OnMenuItemClickListener {
    //针对Java的Map做的封装，它的效率比HashMap高
    private SparseArray<Fragment> fragments;
    private RadioGroup mRadioGroup;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wei_xin);

        //1.1加载fragment
        fragments = new SparseArray<>();
        fragments.put(R.id.msg_btn, MsgFragment.newInstance(null, null));
        fragments.put(R.id.book_btn, new BookFragment());
        fragments.put(R.id.found_btn, FoundFragment.newInstance(null, null));
        fragments.put(R.id.me_btn, new MeFragment());

        //1.2  通过FragmentManager装载Fragment
        replaceFragment(fragments.get(R.id.msg_btn));

        //2.响应按钮切换
        mRadioGroup = findViewById(R.id.radio_group);
        mRadioGroup.setOnCheckedChangeListener(this);

        //3.加载ToolBar的菜单,并设置监听器，重写监听方法
        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setOnMenuItemClickListener(this);

    }
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_chat:
                break;
        }

        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.weixin_toolbar, menu);
        return true;
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }
    // checkedId为RadioButton的id
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        replaceFragment(fragments.get(checkedId));


    }


}
