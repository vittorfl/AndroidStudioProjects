package br.com.android.helloworldandroid;

import android.app.Activity;
import android.os.Bundle;

public class AppHello extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}
