package com.arbisoft.sentimetersdk.communication.response;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Imran on 6/24/2016.
 */
public class SaveFeedbackResponse extends BaseResponse implements Parcelable {

    protected SaveFeedbackResponse(Parcel in) {
        super(in);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SaveFeedbackResponse> CREATOR = new Creator<SaveFeedbackResponse>() {
        @Override
        public SaveFeedbackResponse createFromParcel(Parcel in) {
            return new SaveFeedbackResponse(in);
        }

        @Override
        public SaveFeedbackResponse[] newArray(int size) {
            return new SaveFeedbackResponse[size];
        }
    };
}
