package it.miriade.corsi.android.databindinglibrary.model.entity;

import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import it.miriade.corsi.android.databindinglibrary.AppConst;
import it.miriade.corsi.android.databindinglibrary.model.dao.UserDao;

/**
 * Created by roberto on 16/11/16 for project DataBindingLibrary
 */

@DatabaseTable(tableName = AppConst.TABLE_USERS, daoClass = UserDao.class)
public class User {

    private Long _id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Date birthday;

    public User() { }

    public User(String email, String password, String firstName, String lastName, Date birthday) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return _id;
    }

    public void setId(Long id) {
        this._id = id;
    }

    @Column(unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Temporal(TemporalType.DATE)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                '}';
    }

}
