package co.swisapp.loginmapload.Models.RealmModels;

import android.content.Intent;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by sns on 7/3/16.
 */
public class Follower extends RealmObject{
    @PrimaryKey
    String userId;
    String name;
    String username;
    Integer followerCount;
    Integer followingCount;
}
