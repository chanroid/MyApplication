package co.kr.chanroid.myapplication;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.fragment.NavHostFragment;

import com.squareup.sqldelight.android.AndroidSqliteDriver;
import com.squareup.sqldelight.db.SqlDriver;

import java.util.List;

import javax.inject.Inject;

import co.kr.chanroid.myapplication.retrofit.Contacts;
import co.kr.chanroid.myapplication.retrofit.RetrofitService;
import co.kr.chanroid.myapplication.sqldelight.ContactsQueries;
import dagger.android.support.DaggerFragment;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class FirstFragment extends DaggerFragment {
    @Inject
    RetrofitService retrofitService;
    @Inject
    Database database;

    private ProgressDialog progressDialog;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_first).setOnClickListener(view1 -> {
//                NavHostFragment.findNavController(FirstFragment.this)
//                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            loadData();
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage("불러오는중");
        progressDialog.setTitle(R.string.app_name);
    }

    private void loadData() {
        progressDialog.show();
        retrofitService.requestContacts()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io()).subscribe(
                contacts -> {
                    saveData(contacts);
                },
                throwable -> {
                    progressDialog.dismiss();
                },
                () -> {
                    progressDialog.dismiss();
        });
    }

    private void saveData(Contacts contacts) {

    }
}
