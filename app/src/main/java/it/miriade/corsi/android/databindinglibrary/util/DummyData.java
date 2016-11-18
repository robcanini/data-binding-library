package it.miriade.corsi.android.databindinglibrary.util;

import junit.framework.Assert;

import java.sql.SQLException;
import java.util.Date;

import it.miriade.corsi.android.databindinglibrary.model.dao.UserDao;
import it.miriade.corsi.android.databindinglibrary.model.entity.User;

/**
 * Created by roberto on 17/11/16 for project DataBindingLibrary
 */

public class DummyData {

    public static void createUsers(int recordNumber) {

        Assert.assertTrue(recordNumber > 0);

        try {
            UserDao dao = new UserDao();
            for(int i = 0; i < recordNumber; i++) {
                User dummy = new User("user" + i + "@sample.com", "user" + i, "dummy" + i, new Date(), "");
                dao.create(dummy);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
