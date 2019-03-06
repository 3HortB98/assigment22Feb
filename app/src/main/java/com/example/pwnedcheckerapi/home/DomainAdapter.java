package com.example.pwnedcheckerapi.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pwnedcheckerapi.DomainRepo;
import com.example.pwnedcheckerapi.R;

import java.util.ArrayList;
import java.util.List;

public class DomainAdapter extends RecyclerView.Adapter<DomainAdapter.itemViewHolder>{


    private final List<DomainRepo> data = new ArrayList<>();


    public void setData(List<DomainRepo> newData) {
        data.clear();
        data.addAll(newData);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public itemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View rootView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_domain_pass, viewGroup, false);
        return new itemViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull itemViewHolder itemViewHolder, int position) {
        DomainRepo domainRepo = data.get(position);
        itemViewHolder.tvName.setText("Name: "+domainRepo.getName());
        itemViewHolder.tvTitle.setText("Title: "+domainRepo.getTitle());
        itemViewHolder.tvDomain.setText("Domain: "+ domainRepo.getDomain());
        itemViewHolder.tvBreach.setText("Breach Date: "+domainRepo.getBreachDate());
        itemViewHolder.tvPwnCount.setText("Pwned Count: "+domainRepo.getPwnCount().toString());
        itemViewHolder.tvDescription.setText("Description: "+domainRepo.getDescription());
        itemViewHolder.tvVerified.setText("Verified: "+ domainRepo.getIsVerified().toString());
        itemViewHolder.tvFabricated.setText("Fabricated: "+domainRepo.getIsFabricated().toString());
        itemViewHolder.tvSensitive.setText("Sensitive: "+domainRepo.getIsSensitive().toString());
        itemViewHolder.tvRetired.setText("Retired: "+domainRepo.getIsRetired().toString());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class itemViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        TextView tvTitle;
        TextView tvDomain;
        TextView tvBreach;
        TextView tvPwnCount;
        TextView tvDescription;
        TextView tvVerified;
        TextView tvSensitive;
        TextView tvFabricated;
        TextView tvRetired;

        public itemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDomain = itemView.findViewById(R.id.tvDomain);
            tvBreach = itemView.findViewById(R.id.tvBreachDate);
            tvPwnCount = itemView.findViewById(R.id.tvPwnCount);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvVerified = itemView.findViewById(R.id.tvVerified);
            tvFabricated = itemView.findViewById(R.id.tvFabricated);
            tvSensitive = itemView.findViewById(R.id.tvSensitive);
            tvRetired = itemView.findViewById(R.id.tvRetired);
        }


    }
}
