package co.kr.chanroid.myapplication.dagger;

import android.content.Context;

import lombok.Getter;

public class TestBean {
    @Getter
    private Context context;

    public TestBean(Context context) {

    }
}
