package co.swisapp.loginmapload.Dagger.Modules;

import javax.inject.Singleton;

import co.swisapp.loginmapload.Models.RetroAPI;
import dagger.Module;
import dagger.Provides;

@Module
public class ApiModule {
    @Provides
    @Singleton
    RetroAPI provideRetroAPI(){ return new RetroAPI();}
}
