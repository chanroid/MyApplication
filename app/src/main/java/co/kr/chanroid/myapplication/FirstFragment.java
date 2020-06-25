package co.kr.chanroid.myapplication;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.fragment.NavHostFragment;

import javax.inject.Inject;

import co.kr.chanroid.myapplication.retrofit.RetrofitService;
import dagger.android.support.DaggerFragment;

public class FirstFragment extends DaggerFragment {
    @Inject
    RetrofitService retrofitService;

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

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage("불러오는중");
        view.findViewById(R.id.button_first).setOnClickListener(view1 -> {
//                NavHostFragment.findNavController(FirstFragment.this)
//                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            loadData();
        });
    }

    private void loadData() {
        progressDialog.show();
        retrofitService.requestContacts().subscribe(
                contacts -> {
                    Log.e("TEST", contacts.toString());
                    progressDialog.dismiss();
                }, throwable -> {
                    progressDialog.dismiss();
                });
    }
}
