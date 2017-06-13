package co.swisapp.loginmapload.UI.Presenters;

import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.JsonObject;

import javax.inject.Inject;

import co.swisapp.loginmapload.Models.RetroAPI;
import co.swisapp.loginmapload.UI.ScreenInterfaces.SigninScreen;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;


public class SigninPresenter {
    String TAG ="TEST:";
    RetroAPI retroAPI;
    SharedPreferences.Editor prefsEditor;

    @Inject
    public SigninPresenter(RetroAPI retroAPI,SharedPreferences.Editor prefsEditor) {
        this.retroAPI = retroAPI;
        this.prefsEditor = prefsEditor;
    }

    public void signin(final SigninScreen signinScreen, String unameoremail, String password){
        signinScreen.progressBar(true);
        retroAPI.apiService.signIn(unameoremail,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<JsonObject>() {
                    @Override
                    public void call(JsonObject jsonObject) {
                        Log.d(TAG,jsonObject.get("success").toString());
                        signinScreen.progressBar(false);
                        if(jsonObject.get("success").getAsBoolean()){
                            prefsEditor.putBoolean("loggedin",true);
                            prefsEditor.putString("accesstoken",jsonObject.get("accesstoken").toString());
                            prefsEditor.putString("authtoken",jsonObject.get("authtoken").toString());
                            prefsEditor.commit();
                            signinScreen.loadHome();
                        }
                    }
                });
    }
}
