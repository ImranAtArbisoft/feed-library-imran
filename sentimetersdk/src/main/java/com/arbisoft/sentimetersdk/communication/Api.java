package com.arbisoft.sentimetersdk.communication;

import com.arbisoft.sentimetersdk.communication.response.AreaResponse;
import com.arbisoft.sentimetersdk.communication.response.BranchGroResponse;
import com.arbisoft.sentimetersdk.communication.response.BranchResponse;
import com.arbisoft.sentimetersdk.communication.response.CityResponse;
import com.arbisoft.sentimetersdk.communication.response.ClientQuestionResponse;
import com.arbisoft.sentimetersdk.communication.response.FeedbackBody;
import com.arbisoft.sentimetersdk.communication.response.LoginResponse;
import com.arbisoft.sentimetersdk.communication.response.RegionResponse;
import com.arbisoft.sentimetersdk.communication.response.SaveFeedbackResponse;
import com.arbisoft.sentimetersdk.communication.response.UserLogin;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by Imran on 6/10/2016.
 * API calls will go here
 */
public interface Api {
    Retrofit.Builder builder =
            new Retrofit.Builder()
//                    .baseUrl(BuildConfig.END_POINT)
//                    .addConverterFactory(GsonConverterFactory.create(GsonUtils.getGson()))
                    .client(MyOkHttpClient.getHttpClient());

    Api api = builder.build().create(Api.class);

    class MyOkHttpClient {
        public static OkHttpClient getHttpClient() {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
            clientBuilder.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request original = chain.request();
                    Request.Builder requestBuilder = original.newBuilder()
                            .header("Accept", "application/json")
                            .header("Content-Type", "application/json")
                            .method(original.method(), original.body());

                    Request request = requestBuilder.build();
                    return chain.proceed(request);
                }
            });
            clientBuilder.addInterceptor(loggingInterceptor);
            clientBuilder.connectTimeout(2, TimeUnit.MINUTES);
            clientBuilder.writeTimeout(2, TimeUnit.MINUTES);
            clientBuilder.readTimeout(2, TimeUnit.MINUTES);
//            clientBuilder.addInterceptor(new AddCookiesInterceptor());
            return clientBuilder.build();
        }
    }

    @POST("login")
    Call<LoginResponse> login(@Body UserLogin.LoginBody body);

    @GET("area")
    Call<AreaResponse> getArea();

    @GET("region")
    Call<RegionResponse> getRegion();

    @GET("city")
    Call<CityResponse> getCity(@QueryMap HashMap<String, Object> query);

    @GET("branch")
    Call<BranchResponse> getBranches(@QueryMap HashMap<String, Object> query);

    @GET("branch_gro")
    Call<BranchGroResponse> getBranchGROs(@Query("branch_id") long branchId);

    @GET("client_question")
    Call<ClientQuestionResponse> getClientQuestion(@Query("branch_id") long branchId);

    @POST("feedback")
    Call<SaveFeedbackResponse> saveFeedback(@Body List<FeedbackBody> feedBacks);

    @POST("batch_feedback")
    Call<SaveFeedbackResponse> saveBatchFeedback(@Body List<FeedbackBody> feedBacks);

}
