package com.example.sathv.jbossoutreachrepositories;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.ProductViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<RepoModel> productList;

    //getting the context and product list with constructor
    public RepoAdapter(Context mCtx, List<RepoModel> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.repo_row, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        //getting the product of the specified position
        final RepoModel product = productList.get(position);

        //binding the data with the viewholder views
        holder.description.setText(product.getDescription());
        holder.reponame.setText(product.getReponame());
        holder.update.setText(String.valueOf("Last Update: " + product.getLastupdate()));
        holder.forkcount.setText(String.valueOf(product.getForkcount()));
        holder.starcount.setText(String.valueOf(product.getStarcount()));
        holder.language.setText(String.valueOf(product.getCodelang()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mCtx, ContributorsActivity.class);
                intent.putExtra("contributeurl", product.getContributorurl());
                mCtx.startActivity(intent);

            }
        });


        if(product.getCodelang().equals("JavaScript")){
            holder.language.setCompoundDrawablesWithIntrinsicBounds(R.drawable.js, 0, 0, 0);
        }else if(product.getCodelang().equals("Java")){
            holder.language.setCompoundDrawablesWithIntrinsicBounds(R.drawable.java, 0, 0, 0);
        }else if(product.getCodelang().equals("TypeScript")){
            holder.language.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ts, 0, 0, 0);
        }else if(product.getCodelang().equals("Python")){
            holder.language.setCompoundDrawablesWithIntrinsicBounds(R.drawable.py, 0, 0, 0);
        }else if(product.getCodelang().equals("HTML")){
            holder.language.setCompoundDrawablesWithIntrinsicBounds(R.drawable.html, 0, 0, 0);
        }else if(product.getCodelang().equals("CSS")){
            holder.language.setCompoundDrawablesWithIntrinsicBounds(R.drawable.css, 0, 0, 0);
        }else{
            holder.language.setCompoundDrawablesWithIntrinsicBounds(R.drawable.css, 0, 0, 0);
        }
    }


    @Override
    public int getItemCount() {
        return productList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView reponame, description, update, forkcount, starcount, language;

        public ProductViewHolder(View itemView) {
            super(itemView);

            reponame = itemView.findViewById(R.id.reponame);
            description = itemView.findViewById(R.id.description);
            update = itemView.findViewById(R.id.update);
            forkcount = itemView.findViewById(R.id.forkcount);
            starcount = itemView.findViewById(R.id.starcount);
            language = itemView.findViewById(R.id.language);
        }
    }
}