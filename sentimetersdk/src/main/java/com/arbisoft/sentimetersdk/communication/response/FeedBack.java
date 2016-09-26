package com.arbisoft.sentimetersdk.communication.response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Created by Imran on 7/28/2016.
 */
public class FeedBack {
    private String comment;
    private long gro;
    private UserBody user;//":
    private long branch;
    private HashMap<Long, List<Long>> options;
    private String created_at;

    public FeedBack(long gro, long branch) {
        this.gro = gro;
        this.branch = branch;
        user = new UserBody();
        options = new HashMap<>();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public long getGro() {
        return gro;
    }

    public void setGro(long gro) {
        this.gro = gro;
    }

    public UserBody getUser() {
        return user;
    }

    public void setUser(UserBody user) {
        this.user = user;
    }

    public long getBranch() {
        return branch;
    }

    public void setBranch(long branch) {
        this.branch = branch;
    }

    public HashMap<Long, List<Long>> getOptions() {
        return options;
    }

    public void setOptions(long key, List<Long> options) {
        if (options == null) {
            options = new ArrayList<>();
        }
        this.options.put(key, options);
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public FeedbackBody getFeedback() {
        FeedbackBody feedbackBody = new FeedbackBody(gro, getBranch());
        feedbackBody.setCreated_at(getCreated_at());
        feedbackBody.setUser(getUser());
        feedbackBody.setComment(getComment());
        Set<Long> keys = options.keySet();
        for (long key : keys) {
            feedbackBody.getOptions().addAll(options.get(key));
        }
        return feedbackBody;
    }

    public void remove(long aLong) {
        options.remove(aLong);
    }

    @Override
    public String toString() {
        return "FeedBack{" +
                "comment='" + comment + '\'' +
                ", gro=" + gro +
                ", user=" + user +
                ", branch=" + branch +
                ", options=" + options +
                ", created_at='" + created_at + '\'' +
                '}';
    }
}
