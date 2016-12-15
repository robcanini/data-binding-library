package it.miriade.corsi.android.databindinglibrary.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import it.miriade.corsi.android.databindinglibrary.AppConst;
import it.miriade.corsi.android.databindinglibrary.R;
import it.miriade.corsi.android.databindinglibrary.dto.UserDto;
import it.miriade.corsi.android.databindinglibrary.model.dao.UserDao;
import it.miriade.corsi.android.databindinglibrary.model.entity.User;
import it.miriade.corsi.android.databindinglibrary.ui.adapter.UserAdapter;
import it.miriade.corsi.android.databindinglibrary.util.collection.CollectionConverter;
import it.miriade.corsi.android.databindinglibrary.util.collection.CollectionUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, UserAdapter.UserItemListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        List<UserDto> data = Collections.emptyList();
        try {
            data = CollectionUtils.convertList(new CollectionConverter<User, UserDto>() {
                @Override
                public UserDto convert(User v) {
                    return new UserDto(v);
                }
            }, new UserDao().queryForAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        recyclerView.setAdapter(new UserAdapter(data, this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab: {

                break;
            }
            default: break;
        }
    }

    @Override
    public void onItemClick(UserDto user) {
        user.firstName.set("Mario");
        user.lastName.set("Rossi");
    }

    @Override
    public void onItemLongClick(UserDto user) {
        Intent detailIntent = new Intent(this, DetailActivity.class);
        detailIntent.putExtra(AppConst.USER_SERIALIZED_ID, user);
        startActivity(detailIntent);
    }

}
