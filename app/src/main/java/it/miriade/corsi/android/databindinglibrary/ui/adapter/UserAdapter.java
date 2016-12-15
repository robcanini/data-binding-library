package it.miriade.corsi.android.databindinglibrary.ui.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import it.miriade.corsi.android.databindinglibrary.BR;
import it.miriade.corsi.android.databindinglibrary.R;
import it.miriade.corsi.android.databindinglibrary.dto.UserDto;

/**
 * Created by roberto on 17/11/16 for project DataBindingLibrary
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {

    private List<UserDto> items;
    private UserItemListener clickListener;

    public interface UserItemListener {
        void onItemClick(UserDto user);
        void onItemLongClick(UserDto user);
    }

    public class UserHolder extends RecyclerView.ViewHolder {

        public ViewDataBinding binding;

        public UserHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

    }

    public UserAdapter(List<UserDto> items, UserItemListener clickListener) {
        this.items = items;
        this.clickListener = clickListener;
    }

    @Override
    public UserHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, parent, false);
        return new UserHolder(view);
    }

    @Override
    public void onBindViewHolder(UserHolder holder, int position) {
        final UserDto user = items.get(position);
        holder.binding.setVariable(BR.user, user);
        holder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onItemClick(user);
            }
        });
        holder.binding.getRoot().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                clickListener.onItemLongClick(user);
                return true;
            }
        });
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}
