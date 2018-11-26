package com.example.sathv.jbossoutreachrepositories;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;


public class ContributeAdapter extends RecyclerView.Adapter<ContributeAdapter.ProductViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<ContributeModel> productList;

    //getting the context and product list with constructor
    public ContributeAdapter(Context mCtx, List<ContributeModel> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.contribute_row, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ProductViewHolder holder, int position) {
        //getting the product of the specified position
        final ContributeModel product = productList.get(position);

        //binding the data with the viewholder views
        holder.username.setText("Username: " + product.getUsername());
        holder.contributions.setText("Contributions: " + String.valueOf(product.getContributions()));


        holder.userurl.setText("Url: " + product.getRealname());

        Glide.with(mCtx).load(product.getImageurl()).into(holder.userimage);
    }


    @Override
    public int getItemCount() {
        return productList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView username,userurl, contributions;
        ImageView userimage;

        public ProductViewHolder(View itemView) {
            super(itemView);
            userimage = itemView.findViewById(R.id.userimage);
            username = itemView.findViewById(R.id.username);
            userurl = itemView.findViewById(R.id.userurl);
            contributions = itemView.findViewById(R.id.contributions);
        }
    }
}