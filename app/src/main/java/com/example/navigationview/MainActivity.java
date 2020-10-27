package com.example.navigationview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DrawerLayout dl = findViewById(R.id.drawerLayout);
        NavigationView nv = findViewById(R.id.navigation);
        Toolbar tb = findViewById(R.id.toolbar);

        LinearLayout mealLayout = findViewById(R.id.mealLayout);
        RelativeLayout drinkLayout = findViewById(R.id.drinkLayout);
        ConstraintLayout desertLayout = findViewById(R.id.desertLayout);

        tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dl.openDrawer(nv);
            }
        });

        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.meal){
                    mealLayout.setVisibility(View.VISIBLE);
                    drinkLayout.setVisibility(View.GONE);
                    desertLayout.setVisibility(View.GONE);
                }
                else if(item.getItemId() == R.id.drink){
                    mealLayout.setVisibility(View.GONE);
                    drinkLayout.setVisibility(View.VISIBLE);
                    desertLayout.setVisibility(View.GONE);
                }
                else if(item.getItemId() == R.id.desert){
                    mealLayout.setVisibility(View.GONE);
                    drinkLayout.setVisibility(View.GONE);
                    desertLayout.setVisibility(View.VISIBLE);
                }

                dl.closeDrawers();
                return true;
            }
        });
    }
}