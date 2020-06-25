package co.kr.chanroid.myapplication.dagger.modules;

import javax.inject.Singleton;

import co.kr.chanroid.myapplication.retrofit.RetrofitService;
import dagger.Module;
import dagger.Provides;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitModule {
    @Provides
    @Singleton
    public RetrofitService provideRetrofit() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.androidhive.info")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
        return retrofit.create(RetrofitService.class);
    }
}
