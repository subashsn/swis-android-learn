package co.swisapp.loginmapload.UI.Presenters;

import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.JsonObject;

import javax.inject.Inject;

import co.swisapp.loginmapload.Models.RetroAPI;
import co.swisapp.loginmapload.UI.ScreenInterfaces.SignupScreen;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;


public class SignupPresenter {
    String TAG ="TEST:";
    RetroAPI retroAPI;
    SharedPreferences.Editor prefsEditor;

    @Inject
    public SignupPresenter(RetroAPI retroAPI,SharedPreferences.Editor prefsEditor) {
        this.retroAPI = retroAPI;
        this.prefsEditor = prefsEditor;
    }



    public void signup(final SignupScreen signupScreen, String username, String email, String password){
        signupScreen.progressBar(true);
        retroAPI.apiService.signUp(username,email,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<JsonObject>() {
                    @Override
                    public void call(JsonObject jsonObject) {
                        Log.d(TAG,jsonObject.get("success").toString());
                        signupScreen.progressBar(false);
                        if(jsonObject.get("success").getAsBoolean()){
                            prefsEditor.putBoolean("loggedin",true);
                            prefsEditor.putString("accesstoken",jsonObject.get("accesstoken").toString());
                            prefsEditor.putString("authtoken",jsonObject.get("authtoken").toString());
                            prefsEditor.commit();
                            signupScreen.loadHome();
                        }
                    }
                });
    }
}
