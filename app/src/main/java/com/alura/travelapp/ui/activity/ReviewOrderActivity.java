package com.alura.travelapp.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.alura.travelapp.R;
import com.alura.travelapp.model.TravelPackage;
import com.alura.travelapp.util.DateUtil;
import com.alura.travelapp.util.DurationUtil;
import com.alura.travelapp.util.PriceUtil;
import com.alura.travelapp.util.ResourcesUtil;

import static com.alura.travelapp.ui.activity.Constants.PACKAGE_KEY;

public class ReviewOrderActivity extends AppCompatActivity {

    public static final String TITLE_APPBAR = "review your order";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_order);

        setTitle(TITLE_APPBAR);
        loadsReceivedTravelPackage();
    }

    private void loadsReceivedTravelPackage() {
        Intent intent = getIntent();
        if (intent.hasExtra(PACKAGE_KEY)) {
            final TravelPackage travelPackage = (TravelPackage) intent.getSerializableExtra(PACKAGE_KEY);
            startsFields(travelPackage);
            setUpButton(travelPackage);
        }
    }

    private void setUpButton(final TravelPackage travelPackage) {
        Button buttonProceed = findViewById(R.id.activity_review_button_confirm_id);
        buttonProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goesToPayment(travelPackage);
            }
        });
    }

    private void goesToPayment(TravelPackage travelPackage) {
        Intent intent = new Intent(ReviewOrderActivity.this,
                CheckoutActivity.class);
        intent.putExtra(PACKAGE_KEY, travelPackage);
        startActivity(intent);
    }

    private void startsFields(TravelPackage travelPackage) {
        showsPlace(travelPackage);
        showsImage(travelPackage);
        showsTripLength(travelPackage);
        showsPrice(travelPackage);
        showsFormattedDates(travelPackage);
    }

    private void showsFormattedDates(TravelPackage travelPackageOslo) {
        TextView tripDatesTextView = findViewById(R.id.activity_review_text_view_dates_id);
        String formattedFullDuration = DateUtil.tripLengthToString(travelPackageOslo.getTripLength());
        tripDatesTextView.setText(formattedFullDuration);
    }

    private void showsPrice(TravelPackage travelPackage) {
        TextView priceTextView = findViewById(R.id.activity_review_text_view_price_id);
        String cad = PriceUtil.formatPriceToCad(travelPackage.getPrice());
        priceTextView.setText(cad);
    }

    private void showsTripLength(TravelPackage travelPackage) {
        TextView tripLengthTextView = findViewById(R.id.activity_review_text_view_length_id);
        String daysToString = DurationUtil.formatDaysToString(travelPackage.getTripLength());
        tripLengthTextView.setText(daysToString);
    }

    private void showsImage(TravelPackage travelPackage) {
        ImageView placeImage = findViewById(R.id.activity_review_image_view_id);
        Drawable drawable = ResourcesUtil
                .getDrawable(this, travelPackage.getImage());
        placeImage.setImageDrawable(drawable);
    }

    private void showsPlace(TravelPackage travelPackage) {
        TextView placeTextView = findViewById(R.id.activity_review_text_view_place_id);
        placeTextView.setText(travelPackage.getPlace());
    }
}
