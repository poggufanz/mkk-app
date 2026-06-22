package com.mkk_app.JUKIR.interfaces;

import java.util.ArrayList;

public interface INotifiable {
    public ArrayList<String> getNotifLog();
    
    public void sendNotification(String msg);
}
