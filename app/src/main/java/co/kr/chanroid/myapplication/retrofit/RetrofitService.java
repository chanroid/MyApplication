package co.kr.chanroid.myapplication.retrofit;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;


public interface RetrofitService {

    @GET("/contacts")
    Observable<Contacts> requestContacts();
}
