package com.alura.travelapp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.alura.travelapp.R;
import com.alura.travelapp.dao.PackageDAO;
import com.alura.travelapp.model.TravelPackage;
import com.alura.travelapp.ui.adapter.PackagesListAdapter;

import java.util.List;
import java.util.Objects;

import static com.alura.travelapp.ui.activity.Constants.PACKAGE_KEY;

public class PackagesListActivity extends AppCompatActivity {

    public static final String APPBAR_TITLE = "travel packages";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_packages_list);
        configuresList();
    }

    private void configuresList() {
        ListView packagesList = findViewById(R.id.listview_packages_list_id);
        final List<TravelPackage> listOfPackages = new PackageDAO().list();
        packagesList.setAdapter(new PackagesListAdapter(listOfPackages, this));
        packagesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TravelPackage selectedPackage = listOfPackages.get(i);
                goesToReviewOrder(selectedPackage);
            }
        });
    }

    private void goesToReviewOrder(TravelPackage selectedPackage) {
        Intent intent = new Intent(PackagesListActivity.this,
                ReviewOrderActivity.class);
        intent.putExtra(PACKAGE_KEY, selectedPackage);
        startActivity(intent);
    }
}
