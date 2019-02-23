package com.example.pwnedcheckerapi;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DomainAdapter extends RecyclerView.Adapter<DomainAdapter.itemViewHolder>{


    private final List<DomainRepo> data;

    public DomainAdapter(){
        this.data = new ArrayList<>();
    }
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
        itemViewHolder.tvName.setText(domainRepo.getName());
        itemViewHolder.tvTitle.setText(domainRepo.getTitle());
        itemViewHolder.tvDomain.setText(domainRepo.getDomain());
        itemViewHolder.tvBreach.setText(domainRepo.getBreachDate());
        itemViewHolder.tvPwnCount.setText(domainRepo.getPwnCount().toString());
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

        public itemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDomain = itemView.findViewById(R.id.tvDomain);
            tvBreach = itemView.findViewById(R.id.tvBreachDate);
            tvPwnCount = itemView.findViewById(R.id.tvPwnCount);
        }
    }
}
