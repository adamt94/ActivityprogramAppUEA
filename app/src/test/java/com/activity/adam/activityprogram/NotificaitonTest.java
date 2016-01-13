package com.activity.adam.activityprogram;

import android.test.mock.MockContext;

import org.junit.Test;

import framework.implementation.AndroidNotification;

import static org.junit.Assert.*;

/**
 * Created by Ben on 13/01/2016.
 */
public class NotificaitonTest {
    MockContext mockContext = new MockContext();

    public void NotifyTest(){
        AndroidNotification androidNotification = new AndroidNotification(mockContext);
        androidNotification.remind(1000,"A","A");
        androidNotification.createNotification(0, "A", "A");
        androidNotification.updateNotification(0, "A", "A");
        androidNotification.cancelNotificaiton(0);
        androidNotification.createNotification(1, "A", "A");
        androidNotification.createNotification(2,"A","A");
        androidNotification.cancelAll();
    }

}
