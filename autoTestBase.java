package com.example.katty.gamecenterautotest;

import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.UiWatcher;
import android.support.test.uiautomator.Until;
import org.junit.runner.RunWith;
import java.io.IOException;

@RunWith(AndroidJUnit4.class)
public class autoTestBase extends gameCenterStr{
    public Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
    public UiDevice device = UiDevice.getInstance(instrumentation);
    //结束游戏盒进程并重启
    public void restartApp() throws IOException, InterruptedException {
        device.executeShellCommand("am force-stop com.m4399.gamecenter");
        Thread.sleep(2000);
        device.executeShellCommand("am start -n com.m4399.gamecenter/.controllers.splash.SplashActivity");
        device.wait(Until.findObject(By.res("com.m4399.gamecenter:id/rl_game_search")),10000);
    }
    //滚动到指定object
    public void scrollIntoObject(String listCls,String resID) throws UiObjectNotFoundException {
        UiScrollable uiScrollable = new UiScrollable(new UiSelector().className(listCls));
        uiScrollable.setMaxSearchSwipes(500);
        uiScrollable.scrollIntoView(new UiSelector().resourceId(resID));
    }
    //注册监听器
    public void errorHandleAdd(){
        device.registerWatcher("Permission", new UiWatcher() {
            @Override
            public boolean checkForCondition() {
                return false;
            }
        });
    }
}
