package meng.greendaodemo.app;

import android.app.Application;

import meng.greendaodemo.db.DatabaseManager;

/**
 * Created by Administrator on 2016/11/22.
 */

public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        DatabaseManager.getInstance().init(this);
    }
}
