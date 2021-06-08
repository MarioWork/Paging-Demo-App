package com.example.paging_demo_app.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.paging_demo_app.Models.UserModel;
import com.example.paging_demo_app.databinding.UsersRvItemBinding;

public class UsersAdapter extends PagedListAdapter<UserModel, UsersAdapter.UsersVH> {


    public UsersAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public UsersVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UsersVH(UsersRvItemBinding
                .inflate(LayoutInflater
                        .from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UsersAdapter.UsersVH holder, int position) {
        Glide.with(holder.binding.profilePictureImageView.getContext())
                .load(getItem(position).getProfilePicture())
                .into(holder.binding.profilePictureImageView);

        holder.binding.idTextView.setText("ID: "+getItem(position).getId());

        holder.binding.nameTextView.setText("Name: "+getItem(position).getName()+" "+getItem(position).getLastName());
    }


    private static DiffUtil.ItemCallback<UserModel> DIFF_CALLBACK = new DiffUtil.ItemCallback<UserModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull UserModel oldItem, @NonNull UserModel newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull UserModel oldItem, @NonNull UserModel newItem) {
            return oldItem.getId() == newItem.getId() && oldItem.getName().equals(newItem.getName()) && oldItem.getProfilePicture().equals(newItem.getProfilePicture());
        }
    };


    public class UsersVH extends RecyclerView.ViewHolder {

        UsersRvItemBinding binding;

        public UsersVH(@NonNull UsersRvItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
