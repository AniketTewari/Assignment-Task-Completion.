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
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class MainActivity extends AppCompatActivity {
    NavigationView navigationView;
    ActionBarDrawerToggle t;
    DrawerLayout drawerLayout;
    GraphView graphView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                        Intent intent=new Intent(MainActivity.this, MainActivity3.class);
                        startActivity(intent);
                        Toast.makeText(MainActivity.this, "My Dashoard", Toast.LENGTH_SHORT).show();
                        break;
                    case(R.id.tools):
                        Toast.makeText(MainActivity.this, "Tools", Toast.LENGTH_SHORT).show();
                        break;
                    case(R.id.settings):
                        Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_SHORT).show();
                        break;
                    case(R.id.info):
                        Toast.makeText(MainActivity.this, "Help", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        return true;
                }
                return true;
            }
        });

        graphView = findViewById(R.id.graphView);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[]
                {
                        new DataPoint(0, 1),
                        new DataPoint(1, 3),
                        new DataPoint(2, 4),
                        new DataPoint(3, 5),
                        new DataPoint(4, 6),
                        new DataPoint(5, 8),
                        new DataPoint(6, 9),
                        new DataPoint(7, 7),
                        new DataPoint(8, 9)

                });

        graphView.setTitle("The Activity Graph");
        graphView.setTitleColor(R.color.colorAccent);
        graphView.setTitleTextSize(24);
        graphView.addSeries(series);
    }
}