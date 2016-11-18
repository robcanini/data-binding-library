package it.miriade.corsi.android.databindinglibrary.ui.activity;

import android.app.DatePickerDialog;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.larswerkman.holocolorpicker.ColorPicker;

import junit.framework.Assert;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import it.miriade.corsi.android.databindinglibrary.AppConst;
import it.miriade.corsi.android.databindinglibrary.R;
import it.miriade.corsi.android.databindinglibrary.databinding.ActivityEditUserBinding;
import it.miriade.corsi.android.databindinglibrary.dto.UserDto;
import it.miriade.corsi.android.databindinglibrary.model.dao.UserDao;
import it.miriade.corsi.android.databindinglibrary.model.entity.User;
import it.miriade.corsi.android.databindinglibrary.ui.view.EditUserView;

public class EditUserActivity extends AppCompatActivity implements EditUserView {

    private UserDto user = new UserDto();
    private ColorPicker colorPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ActivityEditUserBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_edit_user);
        binding.setEditUserView(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        colorPicker = (ColorPicker) findViewById(R.id.reg_color);
        colorPicker.setOnColorSelectedListener(new ColorPicker.OnColorSelectedListener() {
            @Override
            public void onColorSelected(int color) {
                Log.w(getClass().getSimpleName(), String.format("#%06X", 0xFFFFFF & color));
                user.color.set(String.format("#%06X", 0xFFFFFF & color));
            }
        });

        if (getIntent().getSerializableExtra(AppConst.USER_SERIALIZED_ID) != null) {
            user = (UserDto) getIntent().getSerializableExtra(AppConst.USER_SERIALIZED_ID);
            binding.setUser(user);
            setTitle("Edit user: " + user.getPrettyName());
            if (!TextUtils.isEmpty(user.color.get())) {
                colorPicker.setColor(Color.parseColor(user.color.get()));
            }
        } else {
            colorPicker.setColor(ContextCompat.getColor(this, R.color.colorPrimary));
        }

    }

    @Override
    public void showDatePicker(final View view) {
        Calendar mcurrentDate = Calendar.getInstance();
        int mYear = mcurrentDate.get(Calendar.YEAR);
        int mMonth = mcurrentDate.get(Calendar.MONTH);
        int mDay = mcurrentDate.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog mDatePicker = new DatePickerDialog(EditUserActivity.this, new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                if (view instanceof TextView)
                    ((TextView) view).setText(String.format(AppConst.DATE_PATTERN, selectedday, selectedmonth + 1, selectedyear));
            }
        }, mYear, mMonth, mDay);
        mDatePicker.setTitle("Select birthdate");
        mDatePicker.show();
    }

    @Override
    public void save(UserDto user) {
        try {
            UserDao dao = new UserDao();
            User entity = dao.queryBuilder()
                    .where()
                    .eq("email", user.email.get())
                    .queryForFirst();
            Assert.assertNotNull(entity);
            entity.setEmail(((EditText) findViewById(R.id.reg_email)).getText().toString());
            entity.setFirstName(((EditText) findViewById(R.id.reg_firstname)).getText().toString());
            entity.setLastName(((EditText) findViewById(R.id.reg_lastname)).getText().toString());
            try {
                entity.setBirthday((new SimpleDateFormat(AppConst.DATE_FORMAT, Locale.ITALY).parse(((EditText) findViewById(R.id.reg_birthday)).getText().toString())));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            entity.setColor(this.user.color.get());
            dao.update(entity);
            EditUserActivity.this.finish();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }

}
