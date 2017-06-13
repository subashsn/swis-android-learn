package co.swisapp.loginmapload.Dagger;

import android.app.Application;
import android.content.Context;

import co.swisapp.loginmapload.Dagger.Components.AppComponent;
import co.swisapp.loginmapload.Dagger.Components.DaggerAppComponent;
import co.swisapp.loginmapload.Dagger.Modules.ApiModule;
import co.swisapp.loginmapload.Dagger.Modules.MediaModule;
import co.swisapp.loginmapload.Dagger.Modules.SharedPrefModule;


public class DaggerInjector extends Application{
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.appComponent = DaggerAppComponent.builder().apiModule(new ApiModule()).sharedPrefModule(new SharedPrefModule(this)).mediaModule(new MediaModule(this)).build();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        //MultiDex.install(this);
    }

    public AppComponent get() {
        return appComponent;
    }
}
