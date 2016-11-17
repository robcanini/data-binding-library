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
import it.miriade.corsi.android.databindinglibrary.model.entity.User;

/**
 * Created by roberto on 17/11/16 for project DataBindingLibrary
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {

    private List<User> items;

    public UserAdapter(List<User> items) {
        this.items = items;
    }

    public class UserHolder extends RecyclerView.ViewHolder {

        public ViewDataBinding binding;

        public UserHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

    }

    @Override
    public UserHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, parent, false);
        return new UserHolder(view);
    }

    @Override
    public void onBindViewHolder(UserHolder holder, int position) {
        User user = items.get(position);
        holder.binding.setVariable(BR.user, user);
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}
