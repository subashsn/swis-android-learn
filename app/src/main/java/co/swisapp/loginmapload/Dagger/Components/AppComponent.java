package co.swisapp.loginmapload.Dagger.Components;


import javax.inject.Singleton;

import co.swisapp.loginmapload.Dagger.Modules.ApiModule;

import co.swisapp.loginmapload.Dagger.Modules.MediaModule;
import co.swisapp.loginmapload.Dagger.Modules.SharedPrefModule;
import co.swisapp.loginmapload.UI.Activities.Home;
import co.swisapp.loginmapload.UI.Activities.Signin;
import co.swisapp.loginmapload.UI.Activities.Signup;
import co.swisapp.loginmapload.UI.Activities.Splash;
import co.swisapp.loginmapload.UI.Activities.VidPreview;
import dagger.Component;

@Component(modules = {ApiModule.class, SharedPrefModule.class, MediaModule.class})
@Singleton
public interface AppComponent {
    void inject(Signup activity);
    void inject(Splash activity);
    void inject(Signin activity);
    void inject(Home activity);
    void inject(VidPreview activity);
}
