package co.swisapp.loginmapload.Models.RealmModels;

import java.util.Date;

import io.realm.RealmObject;

public class UploadVideo extends RealmObject{
    String videoId;
    Date recordTime;
    String fullPath;
    String status;
    Integer views;
    Double c_x;
    Double c_y;
}