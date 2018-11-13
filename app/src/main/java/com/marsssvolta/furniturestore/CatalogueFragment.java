package com.marsssvolta.furniturestore;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class CatalogueFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.recycler_view, container, false);
        CatalogueAdapter adapter = new CatalogueAdapter(recyclerView.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        return recyclerView;
    }

    private class CatalogueHolder extends RecyclerView.ViewHolder {

        TextView mName;
        ImageView mPicture;

        CatalogueHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_card, parent, false));

            mName = itemView.findViewById(R.id.card_text);
            mPicture = itemView.findViewById(R.id.card_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra(DetailActivity.EXTRA_POSITION, getAdapterPosition());
                    context.startActivity(intent);
                }
            });
        }
    }

    private class CatalogueAdapter extends RecyclerView.Adapter<CatalogueHolder> {

        private static final int LENGTH = 7;

        private final String[] mNames;
        private final Drawable[] mCatalogPictures;

        CatalogueAdapter(Context context) {
            Resources resources = context.getResources();
            mNames = resources.getStringArray(R.array.names);

            TypedArray typedArray = resources.obtainTypedArray(R.array.catalog_pictures);
            mCatalogPictures = new Drawable[typedArray.length()];
            for (int i = 0; i < mCatalogPictures.length; i++) {
                mCatalogPictures[i] = typedArray.getDrawable(i);
            }
            typedArray.recycle();
        }

        @NonNull
        @Override
        public CatalogueHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new CatalogueHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(@NonNull CatalogueHolder holder, int position) {
            holder.mName.setText(mNames[position % mNames.length]);
            holder.mPicture.setImageDrawable(mCatalogPictures[position % mCatalogPictures.length]);
        }

        @Override
        public int getItemCount() {
            return LENGTH;
        }
    }
}
