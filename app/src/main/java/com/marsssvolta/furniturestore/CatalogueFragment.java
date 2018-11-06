package com.marsssvolta.furniturestore;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CatalogueFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        RecyclerView catalogueRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_catalogue, container, false);

        return catalogueRecycler;
    }
}
