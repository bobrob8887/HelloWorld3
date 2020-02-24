package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.Log_break_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity (new Intent(MainActivity.this, MainActivity2.class));
                //goToSecondActivity();
            }

        });



        /*ViewPager viewPager = findViewById(R.id.viewPager);

        AuthenticationPagerAdapter pagerAdapter = new AuthenticationPagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragmet(new Login());

        viewPager.setAdapter(pagerAdapter);*/
    }

    /** Called when the user touches the button
    public void Login(View view) {
        // Do something in response to button click
        Intent intent = new Intent(MainActivity.this, Login.class);
        startActivity(intent);

    }*/


    /*class AuthenticationPagerAdapter extends FragmentPagerAdapter {
        private ArrayList<Fragment> fragmentList = new ArrayList<>();

        public AuthenticationPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return fragmentList.get(i);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        void addFragmet(Fragment fragment) {
            fragmentList.add(fragment);
        }
    }*/


    /*private void goToSecondActivity() {
        Intent intent = new Intent(this, DroidCafe.class);
        startActivity(intent);

    }*/



}
