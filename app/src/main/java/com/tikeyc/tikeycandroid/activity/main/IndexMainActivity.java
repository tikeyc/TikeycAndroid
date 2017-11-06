package com.tikeyc.tikeycandroid.activity.main;

import android.app.Fragment;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.tikeyc.tikeycandroid.R;
import com.tikeyc.tikeycandroid.base.TBaseActivity;
import com.tikeyc.tikeycandroid.fragment.main.tab.HomeFragment;
import com.tikeyc.tikeycandroid.fragment.main.tab.BannerFragment;
import com.tikeyc.tikeycandroid.fragment.main.tab.Test2Fragment;
import com.tikeyc.tikeycandroid.fragment.main.tab.UserFragment;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

public class IndexMainActivity extends TBaseActivity {


    private enum TabFragment {

        home(R.id.navigationview_home, HomeFragment.class),
        test1(R.id.navigationview_live, BannerFragment.class),
        test2(R.id.navigationview_test2, Test2Fragment.class),
        test3(R.id.navigationview_user, UserFragment.class);

        private Fragment fragment;
        private final int menuId;
        private final Class<? extends Fragment> clazz;


        TabFragment(int menuId, Class<? extends Fragment> clazz) {
            this.menuId = menuId;
            this.clazz = clazz;
        }

        @Nullable
        public Fragment fragment() {
            if (fragment == null) {
                try {
                    fragment = clazz.newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                    fragment = new Fragment();
                }
            }
            return fragment;
        }

        public static TabFragment from(int menuId) {
            for (TabFragment tabFragment : values()) {
                if (tabFragment.menuId == menuId) {
                    return tabFragment;
                }
            }
            return test1;
        }

        public static void onDestroy() {
            for (TabFragment fragment : values()) {
                fragment.fragment = null;
            }
        }

    }

    @ViewInject(R.id.bottomNavigationView)
    private BottomNavigationViewEx bottomNavigationView;

    @Event(value = R.id.bottomNavigationView,
    type = BottomNavigationView.OnNavigationItemSelectedListener.class)
    private boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        LogUtil.e(item.getItemId() + "");

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.content,TabFragment.from(item.getItemId()).fragment())
                .commit();

        if (item.getItemId() == R.id.navigationview_user || item.getItemId() == R.id.navigationview_live) {
            navigationBar.setVisibility(View.GONE);
        } else {
            navigationBar.setVisibility(View.VISIBLE);
        }
        navigationBar_title_tv.setText(item.getTitle());

        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index_main);

        initView();

    }

    private void initView() {

        x.view().inject(this);


        bottomNavigationView.enableAnimation(false);
        bottomNavigationView.enableShiftingMode(false);
        bottomNavigationView.enableItemShiftingMode(false);
        bottomNavigationView.setSelectedItemId(R.id.navigationview_home);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        TabFragment.onDestroy();
    }


    private boolean isExit = false;

    /**设置2秒内点击手机系统返回按钮退出APP
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (bottomNavigationView.getSelectedItemId() != R.id.navigationview_home) {
                //如果不是在第一页 则回到第一页
                bottomNavigationView.setSelectedItemId(R.id.navigationview_home);
                return true;
            } else if (!isExit) {
                isExit = true;
                Toast.makeText(this,"再按一次退出",Toast.LENGTH_SHORT).show();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        isExit = false;
                    }
                },2000);
                return true;
            }
        }

        return super.onKeyUp(keyCode, event);
    }
}
