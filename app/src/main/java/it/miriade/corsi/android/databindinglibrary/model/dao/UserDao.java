package it.miriade.corsi.android.databindinglibrary.model.dao;

import com.j256.ormlite.dao.BaseDaoImpl;

import java.sql.SQLException;

import it.miriade.corsi.android.databindinglibrary.model.DbHelper;
import it.miriade.corsi.android.databindinglibrary.model.entity.User;

/**
 * Created by roberto on 16/11/16 for project DataBindingLibrary
 */

public class UserDao extends BaseDaoImpl<User,Long> {

    public UserDao() throws SQLException {
        super(DbHelper.getInstance().getConnectionSource(), User.class);
    }

}
