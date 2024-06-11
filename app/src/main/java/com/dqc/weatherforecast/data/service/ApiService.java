package com.dqc.weatherforecast.data.service;

import com.dqc.weatherforecast.BuildConfig;
import java.io.IOException;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {
    private static final HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    private static final OkHttpClient client = new OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request original = chain.request();
                    HttpUrl originalHttpUrl = original.url();

                    HttpUrl url = originalHttpUrl.newBuilder()
                            .addQueryParameter("key", BuildConfig.GRADLE_API_TOKEN)
                            .build();

                    Request.Builder requestBuilder = original.newBuilder()
                            .url(url);

                    Request request = requestBuilder.build();
                    return chain.proceed(request);
                }
            })
            .build();

    private static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BuildConfig.GRADLE_API_BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static final Api api = retrofit.create(Api.class);

    public static Api getApi() {
        return api;
    }
}
