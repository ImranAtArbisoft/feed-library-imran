package com.arbisoft.sentimetersdk.communication.response;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Imran on 6/16/2016.
 */
public class UserLogin implements Parcelable {
    public String token;
    public User user;

    protected UserLogin(Parcel in) {
        token = in.readString();
        user = in.readParcelable(User.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(token);
        dest.writeParcelable(user, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<UserLogin> CREATOR = new Creator<UserLogin>() {
        @Override
        public UserLogin createFromParcel(Parcel in) {
            return new UserLogin(in);
        }

        @Override
        public UserLogin[] newArray(int size) {
            return new UserLogin[size];
        }
    };

    public static class LoginBody {
        public String username;
        public String password;

        public LoginBody(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }
}
