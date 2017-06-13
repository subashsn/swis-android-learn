package co.swisapp.loginmapload.UI.Activities;

import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

import java.io.IOException;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.swisapp.loginmapload.Dagger.DaggerInjector;
import co.swisapp.loginmapload.R;
import co.swisapp.loginmapload.Utils.Constants;

/**
 * Created by sns on 7/3/16.
 */
public class VidPreview extends AppCompatActivity implements TextureView.SurfaceTextureListener, MediaPlayer.OnCompletionListener{

    @BindView(R.id.button_vidpreview_save) ImageButton saveButton;
    @BindView(R.id.button_vidpreview_upload) ImageButton uploadButton;
    @BindView(R.id.button_vidpreview_cancel) ImageButton cancelButton;
    @BindView(R.id.preview_textureView) TextureView textureView;

    @Inject
    MediaPlayer mediaPlayer;
    private String vidPath;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vidpreview);
        ButterKnife.bind(this);
        ((DaggerInjector) this.getApplicationContext()).get().inject(this);
        init();
    }

    protected void init(){
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
        handleIntent();
        textureView.setSurfaceTextureListener(this);

    }

    protected void handleIntent(){
        Intent intent = getIntent();
        if(intent.hasExtra("vidpath")){
            vidPath = intent.getExtras().get("vidpath").toString();
        }
        else{
            Log.d(Constants.TAG,"No vidpath in intentextra");
        }
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {

    }

    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i1) {
        try {
            if(vidPath != null){
                mediaPlayer.setDataSource(vidPath);
                mediaPlayer.setSurface(new Surface(surfaceTexture));
                mediaPlayer.setOnCompletionListener(this);
                mediaPlayer.prepare();
                mediaPlayer.start();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Upload and maintain copy
    @OnClick(R.id.button_vidpreview_upload)
    public void uploadButtonClick(View v){

    }

    //Discard
    @OnClick(R.id.button_vidpreview_cancel)
    public void cancelButtonClick(View v){

    }

    //Only Local
    @OnClick(R.id.button_vidpreview_save)
    public void saveButtonClick(View v){

    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i1) {

    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {

    }

}
