package co.swisapp.loginmapload.Models.RealmModels;

import android.provider.ContactsContract;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by sns on 7/3/16.
 */
public class User extends RealmObject{
    @PrimaryKey
    String userId;
    String username;
    String name;

    RealmList<Follower> followers;
    RealmList<Following> followings;

    RealmList<UploadVideo> uploadVideos;
}
