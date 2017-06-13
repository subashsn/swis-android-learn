package co.swisapp.loginmapload.UI.Activities;


import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import co.swisapp.loginmapload.Dagger.DaggerInjector;


public class Splash extends AppCompatActivity {

    @Inject
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((DaggerInjector) this.getApplicationContext()).get().inject(this);

        //Checking shared preference for login status

        if (prefs.getBoolean("loggedin",false)){
            Intent intent = new Intent(this,Home.class);
            startActivity(intent);
            finish();
        }
        else{
            Intent intent = new Intent(this,Signup.class);
            startActivity(intent);
            finish();
        }

    }
}
