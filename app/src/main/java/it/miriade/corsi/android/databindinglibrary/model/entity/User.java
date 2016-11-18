package it.miriade.corsi.android.databindinglibrary.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import it.miriade.corsi.android.databindinglibrary.AppConst;
import it.miriade.corsi.android.databindinglibrary.dto.UserDto;

/**
 * Created by roberto on 16/11/16 for project DataBindingLibrary
 */

@Entity(name = AppConst.TABLE_USERS)
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long _id;

    @Column(unique = true)
    private String email;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Column
    private String color;

    public User() { }

    public User(String email, String firstName, String lastName, Date birthday, String color) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.color = color;
    }

    public User(UserDto dto) {
        this.email = dto.email.get();
        this.firstName = dto.firstName.get();
        this.lastName = dto.lastName.get();
        this.birthday = dto.birthday.get();
        this.color = dto.color.get();
    }

    public Long getId() {
        return _id;
    }

    public void setId(Long id) {
        this._id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "User{" +
                "_id=" + _id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", color='" + color + '\'' +
                '}';
    }

}
