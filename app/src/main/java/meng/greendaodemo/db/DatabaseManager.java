package meng.greendaodemo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import meng.greendaodemo.dao.gen.DaoMaster;
import meng.greendaodemo.dao.gen.DaoSession;
import meng.greendaodemo.dao.gen.UserEntityDao;
import meng.greendaodemo.entitys.UserEntity;

/**
 * Created by Administrator on 2016/11/22.
 */

public class DatabaseManager {
    private static DatabaseManager sInstance;
    private DaoSession mDaoSession;

    public static DatabaseManager getInstance() {
        if (sInstance == null) {
            synchronized (DatabaseManager.class) {
                if (sInstance == null) {
                    sInstance = new DatabaseManager();
                }
            }
        }
        return sInstance;
    }

    public void init(Context context) {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(context, Constant.DB_NAME, null);
        SQLiteDatabase writableDatabase = devOpenHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(writableDatabase);
        mDaoSession = daoMaster.newSession();
    }

    public void saveContact(String userName) {
        UserEntity contact = new UserEntity();
        contact.setName(userName);
        mDaoSession.getUserEntityDao().save(contact);
    }

    public List<String> queryAllContacts() {
        List<UserEntity> list = mDaoSession.getUserEntityDao().queryBuilder().list();
        ArrayList<String> contacts = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++) {
            String contact = list.get(i).getName();
            contacts.add(contact);
        }
        return contacts;
    }

    public void deleteAllContacts() {
        UserEntityDao userEntityDao = mDaoSession.getUserEntityDao();
        userEntityDao.deleteAll();
    }

}
