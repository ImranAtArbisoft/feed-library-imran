package com.arbisoft.sentimetersdk.communication.response;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Imran on 9/5/2016.
 * Questionnaire
 */
public class Questionnaire implements Parcelable {
    public List<Question> questions;
    public boolean isActive;
    public String title;
    public String crated_at;

    protected Questionnaire(Parcel in) {
        questions = in.createTypedArrayList(Question.CREATOR);
        isActive = in.readByte() != 0;
        title = in.readString();
        crated_at = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(questions);
        dest.writeByte((byte) (isActive ? 1 : 0));
        dest.writeString(title);
        dest.writeString(crated_at);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Questionnaire> CREATOR = new Creator<Questionnaire>() {
        @Override
        public Questionnaire createFromParcel(Parcel in) {
            return new Questionnaire(in);
        }

        @Override
        public Questionnaire[] newArray(int size) {
            return new Questionnaire[size];
        }
    };
}
