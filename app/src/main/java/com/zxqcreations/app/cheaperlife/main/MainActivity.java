package com.zxqcreations.app.cheaperlife.main;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.zxqcreations.app.cheaperlife.R;


public class MainActivity extends AppCompatActivity implements Nearby.OnFragmentInteractionListener,
        Discovery.OnFragmentInteractionListener, Profile.OnFragmentInteractionListener{

    private FragmentManager manager;
    private FragmentTransaction transaction;
    private Nearby nearby;
    private Discovery discovery;
    private Profile profile;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            manager = getFragmentManager();
            transaction = manager.beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    transaction.replace(R.id.main_fragment, nearby);
                    transaction.commit();
                    return true;
                case R.id.navigation_dashboard:
                    transaction.replace(R.id.main_fragment, discovery);
                    transaction.commit();
                    return true;
                case R.id.navigation_notifications:
                    transaction.replace(R.id.main_fragment, profile);
                    transaction.commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nearby = new Nearby();
        discovery = new Discovery();
        profile = new Profile();
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    public void onFragmentInteraction(Uri uri){

    }

}
