package com.arbisoft.sentimetersdk.communication.response;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Imran on 6/16/2016.
 */
public class Promotion implements Parcelable {
    public List<Question> questions;
    public String background_image;
    public String color_selected;
    public String title;
    public String created_at;
    public String color_unselected;
    public String banner_image;
    public boolean isActive;
    public boolean toggle_colors;

    protected Promotion(Parcel in) {
        questions = in.createTypedArrayList(Question.CREATOR);
        background_image = in.readString();
        color_selected = in.readString();
        title = in.readString();
        created_at = in.readString();
        color_unselected = in.readString();
        banner_image = in.readString();
        isActive = in.readByte() != 0;
        toggle_colors = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(questions);
        dest.writeString(background_image);
        dest.writeString(color_selected);
        dest.writeString(title);
        dest.writeString(created_at);
        dest.writeString(color_unselected);
        dest.writeString(banner_image);
        dest.writeByte((byte) (isActive ? 1 : 0));
        dest.writeByte((byte) (toggle_colors ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Promotion> CREATOR = new Creator<Promotion>() {
        @Override
        public Promotion createFromParcel(Parcel in) {
            return new Promotion(in);
        }

        @Override
        public Promotion[] newArray(int size) {
            return new Promotion[size];
        }
    };
}
