package com.example.vardhamanvinternshipassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity2 extends AppCompatActivity {
    NavigationView navigationView;
    ActionBarDrawerToggle t;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        navigationView = findViewById(R.id.navigationView);
        drawerLayout = findViewById(R.id.drawerLayout);
        t = new ActionBarDrawerToggle(this, drawerLayout, R.string.Open, R.string.Close);
        drawerLayout.addDrawerListener(t);
        t.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id)
                {
                    case(R.id.account):
                        Intent intent=new Intent(MainActivity2.this, MainActivity3.class);
                        startActivity(intent);
                        Toast.makeText(MainActivity2.this, "My Dashoard", Toast.LENGTH_SHORT).show();
                        break;
                    case(R.id.tools):
                        Toast.makeText(MainActivity2.this, "Tools", Toast.LENGTH_SHORT).show();
                        break;
                    case(R.id.settings):
                        Toast.makeText(MainActivity2.this, "Settings", Toast.LENGTH_SHORT).show();
                        break;
                    case(R.id.info):
                        Toast.makeText(MainActivity2.this, "Help", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        return true;
                }
                return true;
            }
        });
    }
}