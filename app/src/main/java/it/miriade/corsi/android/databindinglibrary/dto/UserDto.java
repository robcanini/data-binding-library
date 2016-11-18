package it.miriade.corsi.android.databindinglibrary.dto;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingConversion;
import android.databinding.ObservableField;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import it.miriade.corsi.android.databindinglibrary.AppConst;
import it.miriade.corsi.android.databindinglibrary.BR;
import it.miriade.corsi.android.databindinglibrary.model.entity.User;

/**
 * Created by roberto on 17/11/16 for project DataBindingLibrary
 */

public class UserDto extends BaseObservable implements Serializable {

    public ObservableField<String> email = new ObservableField<>();
    public ObservableField<String> firstName = new ObservableField<>();
    public ObservableField<String> lastName = new ObservableField<>();
    public ObservableField<Date> birthday = new ObservableField<>();
    public ObservableField<String> color = new ObservableField<>();

    public UserDto() {
    }

    public UserDto(User user) {
        this.email.set(user.getEmail());
        this.firstName.set(user.getFirstName());
        this.lastName.set(user.getLastName());
        this.birthday.set(user.getBirthday());
        this.color.set(user.getColor());
    }

    @Bindable
    public ObservableField<String> getEmail() {
        return email;
    }

    public void setEmail(ObservableField<String> email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }

    @Bindable
    public ObservableField<String> getFirstName() {
        return firstName;
    }

    public void setFirstName(ObservableField<String> firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
    }

    @Bindable
    public ObservableField<String> getLastName() {
        return lastName;
    }

    public void setLastName(ObservableField<String> lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);
    }

    @Bindable
    public ObservableField<Date> getBirthday() {
        return birthday;
    }

    public void setBirthday(ObservableField<Date> birthday) {
        this.birthday = birthday;
        notifyPropertyChanged(BR.birthday);
    }

    @Bindable
    public ObservableField<String> getColor() {
        return color;
    }

    public void setColor(ObservableField<String> color) {
        this.color = color;
        notifyPropertyChanged(BR.color);
    }

    @BindingConversion
    public static ColorDrawable convertColorToDrawable(String color) {
        if (TextUtils.isEmpty(color))
            return new ColorDrawable(Color.parseColor("#3F51B5"));
        return new ColorDrawable(Color.parseColor(color));
    }

    public String getPrettyName() {
        return firstName.get() + " " + lastName.get();
    }

    public String describe() {
        return "Nome:\n" + firstName.get() + "\n\n" +
                "Cognome:\n" + lastName.get() + "\n\n" +
                "Email:\n" + email.get() + "\n\n" +
                "Data di nascita:\n" + new SimpleDateFormat(AppConst.DATE_FORMAT, Locale.ITALY).format(birthday.get());
    }

    public String getDateFormatted() {
        return new SimpleDateFormat(AppConst.DATE_FORMAT, Locale.ITALY).format(birthday.get());
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "email='" + email.get() + '\'' +
                ", firstName='" + firstName.get() + '\'' +
                ", lastName='" + lastName.get() + '\'' +
                ", birthday=" + birthday.get() +
                ", color='" + color.get() + '\'' +
                '}';
    }

}
