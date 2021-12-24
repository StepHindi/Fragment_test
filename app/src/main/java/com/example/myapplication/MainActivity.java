package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements first.OnDataFragment1Listener{

    private ActivityMainBinding binding;
    public static final String KEY = "key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new first());
            }
        });
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new second());
            }
        });

    }

    public void loadFragment(Fragment f) {
        FragmentManager fm = getSupportFragmentManager();
        Bundle arg = new Bundle();
        arg.putString(KEY, "Hello from activity");
        f.setArguments(arg);

        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameLayout, f);
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void onDataFragment1Listener(String str) {
        Snackbar.make(findViewById(R.id.root), str, Snackbar.LENGTH_LONG).show();
    }
}