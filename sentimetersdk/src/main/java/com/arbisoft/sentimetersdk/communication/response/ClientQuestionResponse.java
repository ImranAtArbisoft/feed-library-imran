package com.arbisoft.sentimetersdk.communication.response;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Imran on 6/16/2016.
 */
public class ClientQuestionResponse extends BaseResponse implements Parcelable {
    public Response response;

    public static class Response implements Parcelable {
        public Questionnaire questionnaire;
        public List<Question> questions;
        public Promotion promotion;

        protected Response(Parcel in) {
            questionnaire = in.readParcelable(Questionnaire.class.getClassLoader());
            questions = in.createTypedArrayList(Question.CREATOR);
            promotion = in.readParcelable(Promotion.class.getClassLoader());
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeParcelable(questionnaire, flags);
            dest.writeTypedList(questions);
            dest.writeParcelable(promotion, flags);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<Response> CREATOR = new Creator<Response>() {
            @Override
            public Response createFromParcel(Parcel in) {
                return new Response(in);
            }

            @Override
            public Response[] newArray(int size) {
                return new Response[size];
            }
        };
    }

    protected ClientQuestionResponse(Parcel in) {
        super(in);
        response = in.readParcelable(Response.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeParcelable(response, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ClientQuestionResponse> CREATOR = new Creator<ClientQuestionResponse>() {
        @Override
        public ClientQuestionResponse createFromParcel(Parcel in) {
            return new ClientQuestionResponse(in);
        }

        @Override
        public ClientQuestionResponse[] newArray(int size) {
            return new ClientQuestionResponse[size];
        }
    };
}
