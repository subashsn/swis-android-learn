package co.swisapp.loginmapload.Dagger.Modules;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MediaModule {
    Context context;
    public MediaModule (Context context){
        this.context =context;
    }

    @Singleton
    @Provides
    MediaPlayer providesMediaPlayer(){
        MediaPlayer mediaPlayer = new MediaPlayer();
        //mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        //mediaPlayer.setLooping(true);
        return mediaPlayer;
    }

}
