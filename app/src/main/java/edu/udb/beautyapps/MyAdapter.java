package edu.udb.beautyapps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context context;
    private List<Service> serviceList;


    public MyAdapter(Context context, List<Service> serviceList ){
        this.context = context;
        this.serviceList = serviceList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.grid_item ,  parent , false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Service service = serviceList.get(position);

        holder.mTextView.setText(service.getName());
        holder.mImageView.setImageResource(service.getImage());

    }

    @Override
    public int getItemCount() {
        return serviceList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView mImageView;
        TextView mTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.imageview);
            mTextView = itemView.findViewById(R.id.textview);

        }
    }

}
