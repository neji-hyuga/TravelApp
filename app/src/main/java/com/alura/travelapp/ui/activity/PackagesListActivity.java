package com.alura.travelapp.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.alura.travelapp.R;
import com.alura.travelapp.dao.PackageDAO;
import com.alura.travelapp.model.TravelPackage;
import com.alura.travelapp.ui.adapter.PackagesListAdapter;

import java.util.List;

public class PackagesListActivity extends AppCompatActivity {

    public static final String APPBAR_TITLE = "travel packages";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_packages_list);

        setTitle(APPBAR_TITLE);
        configuresList();

        Intent intent = new Intent(this, ReviewOrderActivity.class);
        startActivity(intent);

    }

    private void configuresList() {
        ListView packagesList = findViewById(R.id.listview_packages_list_id);
        List<TravelPackage> listOfPackages = new PackageDAO().list();
        packagesList.setAdapter(new PackagesListAdapter(listOfPackages, this));
    }
}
