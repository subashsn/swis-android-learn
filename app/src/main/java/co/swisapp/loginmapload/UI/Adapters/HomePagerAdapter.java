package co.swisapp.loginmapload.UI.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import co.swisapp.loginmapload.UI.Fragments.Camera1Fragment;
import co.swisapp.loginmapload.UI.Fragments.DiscoverFragment;
import co.swisapp.loginmapload.UI.Fragments.UserFragment;

public class HomePagerAdapter extends FragmentPagerAdapter {

    public HomePagerAdapter(FragmentManager fragMan){
        super(fragMan);
    }

    DiscoverFragment df = new DiscoverFragment();
    Camera1Fragment cf = new Camera1Fragment();
    UserFragment uf = new UserFragment();

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return df;
            case 1:
                return cf;
            case 2:
                return uf;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
