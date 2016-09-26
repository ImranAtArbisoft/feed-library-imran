package com.arbisoft.sentimetersdk.communication.response;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Imran on 6/14/2016.
 */
public class RegionResponse extends BaseResponse implements Parcelable {
    public List<Region> response;


    protected RegionResponse(Parcel in) {
        super(in);
        response = in.createTypedArrayList(Region.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeTypedList(response);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<RegionResponse> CREATOR = new Creator<RegionResponse>() {
        @Override
        public RegionResponse createFromParcel(Parcel in) {
            return new RegionResponse(in);
        }

        @Override
        public RegionResponse[] newArray(int size) {
            return new RegionResponse[size];
        }
    };
}
