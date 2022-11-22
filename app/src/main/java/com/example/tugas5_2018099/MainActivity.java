package com.example.tugas5_2018099;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout dl;
    private ActionBarDrawerToggle abdt;
    RecyclerView recyclerView;
    String s1[], s2[],s3[];
    int images[] =
            {R.drawable.fartase,R.drawable.fresty,R.drawable.joly};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dl = (DrawerLayout) findViewById(R.id.dl);
        abdt = new
                ActionBarDrawerToggle(this, dl, R.string.Open, R.string.Close);
        abdt.setDrawerIndicatorEnabled(true);
        dl.addDrawerListener(abdt);

        abdt.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView nav_view =
                (NavigationView) findViewById(R.id.nav_view);
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.nav_message) {
                    Intent a = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(a);
                } else if (id == R.id.nav_feedback) {
                    Intent a = new Intent(MainActivity.this, MainActivity3.class);
                    startActivity(a);
                } else if (id == R.id.nav_store) {
                    Intent a = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(a);
                }
                return true;
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        s1 = getResources().getStringArray(R.array.lotion);
        s2 = getResources().getStringArray(R.array.star);
        s3 = getResources().getStringArray(R.array.harga);
        LotionAdapter appAdapter = new LotionAdapter(this, s1, s2, s3, images);
        recyclerView.setAdapter(appAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return abdt.onOptionsItemSelected(item) ||
                super.onOptionsItemSelected(item);
    }
}