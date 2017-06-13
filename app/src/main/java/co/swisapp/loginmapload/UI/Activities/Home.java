package co.swisapp.loginmapload.UI.Activities;


import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import android.view.WindowManager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;

import co.swisapp.loginmapload.Dagger.DaggerInjector;
import co.swisapp.loginmapload.Events.ViewPagerSwitchEvent;
import co.swisapp.loginmapload.R;
import co.swisapp.loginmapload.UI.Adapters.HomePagerAdapter;

public class Home extends FragmentActivity implements ViewPager.OnPageChangeListener {

    @BindView(R.id.viewPager)


    ViewPager viewPager;
    HomePagerAdapter homePagerAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        ((DaggerInjector) this.getApplicationContext()).get().inject(this);

        homePagerAdapter = new HomePagerAdapter(getSupportFragmentManager()) ;
        viewPager.setAdapter(homePagerAdapter);
        viewPager.setOnPageChangeListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        viewPager.setCurrentItem(1, true);
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewPager.setCurrentItem(1, true);

    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Override
    public void onPageSelected(int position) {
        if (position == 1) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
        } else {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }


    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Subscribe
    public void switchViewPager(ViewPagerSwitchEvent event) {
        viewPager.setCurrentItem(event.value, true);
    }

}
