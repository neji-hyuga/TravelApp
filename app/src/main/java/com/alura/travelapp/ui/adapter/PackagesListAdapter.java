package com.alura.travelapp.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.alura.travelapp.util.DurationUtil;
import com.alura.travelapp.util.PriceUtil;
import com.alura.travelapp.R;
import com.alura.travelapp.util.ResourcesUtil;
import com.alura.travelapp.model.TravelPackage;

import java.util.List;

public class PackagesListAdapter extends BaseAdapter {

    private final List<TravelPackage> travelPackageList;
    private final Context context;

    public PackagesListAdapter(List<TravelPackage> travelPackages, Context context) {
        this.travelPackageList = travelPackages;
        this.context = context;
    }

    @Override
    public int getCount() {
        return travelPackageList.size();
    }

    @Override
    public TravelPackage getItem(int i) {
        return travelPackageList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        View createdView = LayoutInflater.from(context)
                .inflate(R.layout.item_offer, parent, false);

        TravelPackage travelPackage = travelPackageList.get(i);

        showsPlace(createdView, travelPackage);
        showsImage(createdView, travelPackage);
        showsDuration(createdView, travelPackage);
        showsPrice(createdView, travelPackage);

        return createdView;
    }

    private void showsPrice(View createdView, TravelPackage travelPackage) {
        TextView price = createdView.findViewById(R.id.item_offer_price);
        String cad = PriceUtil
                .formatPriceToCad(travelPackage.getPrice());
        price.setText(cad);
    }

    private void showsDuration(View createdView, TravelPackage travelPackage) {
        TextView duration = createdView.findViewById(R.id.item_offer_trip_duration);
        String daysToString = DurationUtil
                .formatDaysToString(travelPackage.getTripLength());
        duration.setText(daysToString);
    }

    private void showsImage(View createdView, TravelPackage travelPackage) {
        ImageView image = createdView.findViewById(R.id.item_offer_image);
        Drawable drawableImagePackage = ResourcesUtil.getDrawable(context, travelPackage.getImage());
        image.setImageDrawable(drawableImagePackage);
    }

    private void showsPlace(View createdView, TravelPackage travelPackage) {
        TextView place = createdView.findViewById(R.id.item_offer_place);
        place.setText(travelPackage.getPlace());
    }
}
