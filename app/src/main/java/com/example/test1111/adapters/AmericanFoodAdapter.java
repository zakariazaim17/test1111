package com.example.test1111.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.test1111.R;
import com.example.test1111.model.NorthAmericaFood;

import java.util.List;

public class AmericanFoodAdapter extends RecyclerView.Adapter<AmericanFoodAdapter.ViewHolder> {

    private List<NorthAmericaFood> response;
    private AdapterClick adapterClick;

    public AmericanFoodAdapter(List<NorthAmericaFood> response, AdapterClick adapterClick) {
        this.response = response;
        this.adapterClick = adapterClick;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.north_america_adapter, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.tv_name.setText(response.get(position).getName());
        holder.tv_price.setText(response.get(position).getPrice());
        holder.tv_description.setText(response.get(position).getDescription());
        holder.imgPic.setImageResource(response.get(position).getImage());
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapterClick.onEditClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return response.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv_name, tv_description, tv_price;
        private final ImageView imgPic;
        private RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            tv_name = (TextView) itemView.findViewById(R.id.name);
            tv_price = (TextView) itemView.findViewById(R.id.price);
            tv_description = (TextView) itemView.findViewById(R.id.description);
            imgPic = (ImageView) itemView.findViewById(R.id.image);
            parentLayout = (RelativeLayout) itemView.findViewById(R.id.parentLayout);
        }
    }

    /**
     * we have to implement this method on activity class
     * where recyclerview is used, this is basically used because Recyclerview doesn'nt have the
     * item click property
     */
    public interface AdapterClick {
        public void onEditClick(int position);
    }

}
