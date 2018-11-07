package com.marsssvolta.furniturestore;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AddressesFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.recycler_view, container, false);
        AddressesAdapter adapter = new AddressesAdapter(recyclerView.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return recyclerView;
    }

    private class AddressesHolder extends RecyclerView.ViewHolder {

        TextView mAddress;

        AddressesHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_list, parent, false));

            mAddress = itemView.findViewById(R.id.address);
        }
    }

    private class AddressesAdapter extends RecyclerView.Adapter<AddressesHolder> {

        private static final int LENGTH = 3;

        private final String[] mAddresses;

        AddressesAdapter(Context context) {
            Resources resources = context.getResources();
            mAddresses = resources.getStringArray(R.array.addresses);
        }

        @NonNull
        @Override
        public AddressesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new AddressesHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(@NonNull AddressesHolder holder, int position) {
            holder.mAddress.setText(mAddresses[position % mAddresses.length]);
        }

        @Override
        public int getItemCount() {
            return LENGTH;
        }
    }
}
