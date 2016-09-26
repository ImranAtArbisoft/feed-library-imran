package com.arbisoft.sentimetersdk;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Imran on 9/7/2016.
 * An entery point to use Sentemeter Feedback System
 */
public class Sentimeter {
    private Builder mBuilder;

    private Sentimeter(Builder builder) {
        mBuilder = builder;
    }

    public void showFeedback() {
        Intent intent = new Intent(mBuilder.mContext, SentiMeterActivity.class);
        intent.putExtra("builder", mBuilder);
        mBuilder.mContext.startActivity(intent);
    }

    public static class Builder implements Parcelable {
        private int mSmallIcon;
        private int mLargeIcon;
        private Context mContext;

        public Builder(Context context) {
            mContext = context;
        }

        protected Builder(Parcel in) {
            mSmallIcon = in.readInt();
            mLargeIcon = in.readInt();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(mSmallIcon);
            dest.writeInt(mLargeIcon);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<Builder> CREATOR = new Creator<Builder>() {
            @Override
            public Builder createFromParcel(Parcel in) {
                return new Builder(in);
            }

            @Override
            public Builder[] newArray(int size) {
                return new Builder[size];
            }
        };

        public int getSmallIcon() {
            return mSmallIcon;
        }

        public int getLargeIcon() {
            return mLargeIcon;
        }

        public Builder setSmallIcon(int smallIcon) {
            mSmallIcon = smallIcon;
            return this;
        }

        public Builder setLargeIcon(int largeIcon) {
            mLargeIcon = largeIcon;
            return this;
        }
        public Sentimeter build(){
            return new Sentimeter(this);
        }
    }
}
