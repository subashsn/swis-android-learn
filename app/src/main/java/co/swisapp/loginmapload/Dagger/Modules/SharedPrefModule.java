package co.swisapp.loginmapload.Dagger.Modules;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import co.swisapp.loginmapload.Utils.Constants;
import dagger.Module;
import dagger.Provides;

@Module
public class SharedPrefModule {
    Context context;

    public SharedPrefModule(Context context){
        this.context=context;
    }

    @Provides
    @Singleton
    SharedPreferences providesSharedPrefs() {
        return context.getSharedPreferences(Constants.sharedPreferenceName,Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    SharedPreferences.Editor providesSharedPrefsEditor() {
        return context.getSharedPreferences(Constants.sharedPreferenceName,Context.MODE_PRIVATE).edit();
    }
}
