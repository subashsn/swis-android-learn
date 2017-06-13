package co.swisapp.loginmapload.UI.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.swisapp.loginmapload.Dagger.DaggerInjector;
import co.swisapp.loginmapload.R;
import co.swisapp.loginmapload.UI.Presenters.SigninPresenter;
import co.swisapp.loginmapload.UI.Presenters.SignupPresenter;
import co.swisapp.loginmapload.UI.ScreenInterfaces.SigninScreen;

public class Signin extends AppCompatActivity implements SigninScreen {

    @Inject
    SigninPresenter signinPresenter;

    @BindView(R.id.input_password)
    EditText input_password;

    @BindView(R.id.input_unameoremail)
    EditText input_unameoremail;

    @BindView(R.id.button_signin)
    Button button_signin;

    @BindView(R.id.button_signup)
    Button button_signup;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        ButterKnife.bind(this);
        ((DaggerInjector) this.getApplicationContext()).get().inject(this);

        //Initialization
        progressBar.setVisibility(View.INVISIBLE);
    }

    @OnClick(R.id.button_signin)
    public void onSigninClick(View v){
        signinPresenter.signin(this,input_unameoremail.getText().toString(),input_password.getText().toString());
    }

    @OnClick(R.id.button_signup)
    public void onSignupClick(View v){
        Intent intent = new Intent(this,Signup.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void progressBar(Boolean val){
        if(val){
            progressBar.setVisibility(View.VISIBLE);
        }
        else{
            progressBar.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void loadHome() {
        Intent intent = new Intent(this,Home.class);
        startActivity(intent);
        finish();
    }
}
