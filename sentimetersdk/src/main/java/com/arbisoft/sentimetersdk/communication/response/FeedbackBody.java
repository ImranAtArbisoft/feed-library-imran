package com.arbisoft.sentimetersdk.communication.response;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Imran on 6/13/2016.
 * Feedback body
 */
public class FeedbackBody implements Parcelable {
    private String comment;
    private long gro;
    private UserBody user;//":
    private long branch;
    private List<Long> options;
    private String created_at;

    public FeedbackBody(long gro, long branch) {
        this.gro = gro;
        this.branch = branch;
        user = new UserBody();
        options = new ArrayList<>();
    }

    protected FeedbackBody(Parcel in) {
        comment = in.readString();
        gro = in.readLong();
        user = in.readParcelable(UserBody.class.getClassLoader());
        branch = in.readLong();
        created_at = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(comment);
        dest.writeLong(gro);
        dest.writeParcelable(user, flags);
        dest.writeLong(branch);
        dest.writeString(created_at);
    }

    public List<Long> getOptions() {
        return options;
    }

    public void setOptions(List<Long> options) {
        this.options = options;
    }

    public long getBranch() {
        return branch;
    }

    public void setBranch(long branch) {
        this.branch = branch;
    }

    public UserBody getUser() {
        return user;
    }

    public void setUser(UserBody user) {
        this.user = user;
    }

    public long getGro() {
        return gro;
    }

    public void setGro(long gro) {
        this.gro = gro;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<FeedbackBody> CREATOR = new Creator<FeedbackBody>() {
        @Override
        public FeedbackBody createFromParcel(Parcel in) {
            return new FeedbackBody(in);
        }

        @Override
        public FeedbackBody[] newArray(int size) {
            return new FeedbackBody[size];
        }
    };
}
