package com.example.allpurposeflour;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.allpurposeflour.Fragments.Fragment_2D.Shape;
import com.example.allpurposeflour.Fragments.Fragment_2D_Main;

import java.util.ArrayList;

public class RV_Adapter extends RecyclerView.Adapter<RV_Adapter.ViewHolder> {

    private LayoutInflater inflater;
    Context context;
    ArrayList<Shape_2D> data;
    static ItemClickListener clickListener;


    public RV_Adapter(Context context, ArrayList<Shape_2D> data){
        this.inflater = LayoutInflater.from(context);
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public RV_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recycler_row_2d, parent, false);
        return new RV_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RV_Adapter.ViewHolder holder, int position) {
        holder.adapter_shapeName.setText(data.get(position).getShape_name());
        holder.adapter_shapeDescription.setText(data.get(position).getShape_description());
        holder.adapter_shapeImage.setImageResource(data.get(position).getShape_image());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView adapter_shapeName;
        TextView adapter_shapeDescription;
        ImageView adapter_shapeImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            adapter_shapeName = itemView.findViewById(R.id.title_row_2D);
            adapter_shapeDescription =itemView.findViewById(R.id.description_row_2D);
            adapter_shapeImage = itemView.findViewById(R.id.image_row_2D);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (clickListener != null) clickListener.onItemClick(view, getAdapterPosition());
        }
    }

    public String getItem(int id) {
        return data.get(id).getShape_name();
    }
    public androidx.fragment.app.Fragment getFragment(int id){
        if (data.get(id).getShape_fragment() == null){
            return (new Shape("nothing", R.mipmap.ic_launcher, new Fragment_2D_Main()));
        }
        else{
            return data.get(id).getShape_fragment();
        }
    }
    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
