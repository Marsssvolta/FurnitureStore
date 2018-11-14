package com.marsssvolta.furniturestore;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static android.support.v7.widget.OrientationHelper.VERTICAL;

public class AddressesFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.recycler_view, container, false);
        AddressesAdapter adapter = new AddressesAdapter(recyclerView.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Подчёркивание пунктов списка
        DividerItemDecoration itemDecor = new DividerItemDecoration(getContext(), VERTICAL);
        recyclerView.addItemDecoration(itemDecor);

        return recyclerView;
    }

    private class AddressesHolder extends RecyclerView.ViewHolder {

        TextView mAddress;
        TextView mSchedule;
        TextView mPhone;

        AddressesHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_list, parent, false));

            mAddress = itemView.findViewById(R.id.address);
            mSchedule = itemView.findViewById(R.id.work_schedule);
            mPhone = itemView.findViewById(R.id.phone);
        }
    }

    // Адаптер для отображения RecyclerView
    private class AddressesAdapter extends RecyclerView.Adapter<AddressesHolder> {

        private static final int LENGTH = 3;

        private final String[] mAddresses;
        private final String mSchedules;
        private final String[] mPhones;

        // Установка ресурсов в конструкторе
        AddressesAdapter(Context context) {
            Resources resources = context.getResources();
            mAddresses = resources.getStringArray(R.array.addresses);
            mSchedules = resources.getString(R.string.schedule);
            mPhones = resources.getStringArray(R.array.phones);
        }

        @NonNull
        @Override
        public AddressesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new AddressesHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(@NonNull AddressesHolder holder, int position) {
            holder.mAddress.setText(mAddresses[position % mAddresses.length]);
            holder.mSchedule.setText(mSchedules);
            holder.mPhone.setText(mPhones[position % mPhones.length]);
        }

        @Override
        public int getItemCount() {
            return LENGTH;
        }
    }
}
