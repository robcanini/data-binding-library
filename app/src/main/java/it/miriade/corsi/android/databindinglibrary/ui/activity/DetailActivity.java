package it.miriade.corsi.android.databindinglibrary.ui.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import it.miriade.corsi.android.databindinglibrary.AppConst;
import it.miriade.corsi.android.databindinglibrary.R;
import it.miriade.corsi.android.databindinglibrary.databinding.ActivityDetailBinding;
import it.miriade.corsi.android.databindinglibrary.dto.UserDto;
import it.miriade.corsi.android.databindinglibrary.ui.view.DetailView;

public class DetailActivity extends AppCompatActivity implements DetailView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityDetailBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        binding.setDetailView(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (getIntent().getSerializableExtra(AppConst.USER_SERIALIZED_ID) != null) {
            UserDto user = (UserDto) getIntent().getSerializableExtra(AppConst.USER_SERIALIZED_ID);
            binding.setUser(user);
            setTitle(user.getPrettyName());
        }
    }

    @Override
    public void editActivity(View view, UserDto user) {
        Log.w(getClass().getSimpleName(), user.toString());
        Intent editIntent = new Intent(this, EditUserActivity.class);
        editIntent.putExtra(AppConst.USER_SERIALIZED_ID, user);
        startActivity(editIntent);
    }

}
