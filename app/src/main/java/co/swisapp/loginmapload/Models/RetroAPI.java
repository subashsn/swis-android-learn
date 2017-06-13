package co.swisapp.loginmapload.Models;

import com.google.gson.JsonObject;

import co.swisapp.loginmapload.Utils.Constants;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import rx.Observable;

public class RetroAPI{
    public interface APIService {

        @FormUrlEncoded
        @POST("auth/signup")
        Observable<JsonObject> signUp(@Field("username") String username, @Field("email") String email, @Field("password") String password);

        @FormUrlEncoded
        @POST("auth/signin")
        Observable<JsonObject> signIn(@Field("unameoremail") String unameoremail, @Field("password") String password);

    }

    public interface FileService {
        @Multipart
        @POST("upload")
        Call<ResponseBody> uploadVideo(@Part("description") RequestBody description,
                                       @Part MultipartBody.Part file);
    }

    public APIService apiService = new Retrofit.Builder()
            .baseUrl(Constants.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build().create(APIService.class);

    public FileService fileService= new Retrofit.Builder()
            .baseUrl(Constants.fileUploadBaseUrl)
            .build().create(FileService.class);

}

