package it.miriade.corsi.android.databindinglibrary.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import it.miriade.corsi.android.databindinglibrary.AppConst;
import it.miriade.corsi.android.databindinglibrary.model.entity.User;

/**
 * Created by roberto on 16/11/16 for project DataBindingLibrary
 */

public class DbHelper extends OrmLiteSqliteOpenHelper {

    private static DbHelper _instance;

    public static DbHelper getInstance() {
        return _instance;
    }

    public DbHelper(Context context) {
        super(context, AppConst.DB_NAME, null, AppConst.DB_VERSION);
        _instance = this;
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, User.class);
        } catch (SQLException e) {
            throw new RuntimeException("Non è stato possibile creare una o più tabelle del database");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
    }

}
