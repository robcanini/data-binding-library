package it.miriade.corsi.android.databindinglibrary.ui.view;

import android.view.View;
import android.widget.EditText;

import it.miriade.corsi.android.databindinglibrary.dto.UserDto;
import it.miriade.corsi.android.databindinglibrary.model.entity.User;

/**
 * Created by roberto on 17/11/16 for project DataBindingLibrary
 */

public interface EditUserView {

    void showDatePicker(View view);

    void save(UserDto user);

}
