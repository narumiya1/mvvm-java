package com.eijun.mvvm.java;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.eijun.mvvm.R;
import com.eijun.mvvm.databinding.ItemHolidaysBinding;

import java.util.ArrayList;
import java.util.List;

public class HolidayAdapter extends RecyclerView.Adapter<HolidayAdapter.MyVewHolder> {

    private List<HolidayModel> holidayModelList ;

    public HolidayAdapter() {
        holidayModelList = new ArrayList<>();
    }

    @NonNull
    @Override
    public MyVewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ItemHolidaysBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_holidays, parent, false);

        return new MyVewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVewHolder holder, int position) {

        holder.binding.setModel(holidayModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return holidayModelList !=null ? holidayModelList.size() : 0 ;
    }

    public class MyVewHolder extends RecyclerView.ViewHolder {
        private ItemHolidaysBinding binding ;
        public MyVewHolder(@NonNull ItemHolidaysBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
