package com.example.katty.gamecenterautotest;
import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(AndroidJUnit4.class)
public class gameCenter extends  autoTestBase{
    public Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
    public UiDevice device = UiDevice.getInstance(instrumentation);
    @BeforeClass
    public static void beforeClass() throws IOException, InterruptedException {
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        UiDevice device = UiDevice.getInstance(instrumentation);
        device.executeShellCommand("pm clear com.m4399.gamecenter");

        Thread.sleep(10000);
        device.executeShellCommand("am start com.m4399.gamecenter/.controllers.splash.SplashActivity");
        Thread.sleep(10000);
        device.executeShellCommand("am force-stop com.m4399.gamecenter ");

    }
    @Before
    public void setUp() throws IOException, InterruptedException {
        restartApp();
    }
    //广场--手游活动专区入口检查
    @Test
    public void mobileSqaureEntrance() throws UiObjectNotFoundException{
        UiObject tabIcon = new UiObject(new UiSelector().resourceId("com.m4399.gamecenter:id/ll_tap").instance(3));
        tabIcon.click();
        device.wait(Until.findObject(By.res("com.m4399.gamecenter:id/tv_view_all")),10000);
        UiObject mobileSqure = new UiObject(new UiSelector().resourceId("com.m4399.gamecenter:id/linkImageView").instance(0));
        mobileSqure.click();
        scrollIntoObject("android.support.v7.widget.RecyclerView","com.m4399.gamecenter:id/endLogo");
        UiObject2 activityDetail = device.findObject(By.res("com.m4399.gamecenter:id/tv_activites_title"));
        activityDetail.click();
        device.wait(Until.findObject(By.res("com.m4399.gamecenter:id/m4399_menu_activities_favorite")),10000);
        device.findObject(By.res("com.m4399.gamecenter:id/m4399_menu_activities_favorite")).click();
    }
    //广场--电脑活动专区入口检查
    @Test
    public void computerSqaureEntrance() throws UiObjectNotFoundException {
        UiObject tabIcon = new UiObject(new UiSelector().resourceId("com.m4399.gamecenter:id/ll_tap").instance(3));
        tabIcon.click();
        device.wait(Until.findObject(By.res("com.m4399.gamecenter:id/tv_view_all")),10000);
        UiObject mobileSqure = new UiObject(new UiSelector().resourceId("com.m4399.gamecenter:id/linkImageView").instance(1));
        mobileSqure.click();
        device.wait(Until.findObject(By.text("游戏专区-电脑小游戏")),10000);
    }
    //广场--全部活动入口检查
    @Test
    public void activityAllEntrance() throws UiObjectNotFoundException {
        UiObject tabIcon = new UiObject(new UiSelector().resourceId("com.m4399.gamecenter:id/ll_tap").instance(3));
        tabIcon.click();
        device.wait(Until.findObject(By.res("com.m4399.gamecenter:id/tv_view_all")),10000);
        UiObject2 activityAll = device.findObject(By.res("com.m4399.gamecenter:id/tv_view_all"));
        activityAll.click();
        device.wait(Until.findObject(By.res("com.m4399.gamecenter:id/tv_tab_title").text("活动专区")),10000);
    }
    //添加两百张自定义表情
    @Test
    public void mobileSqureCheck() throws UiObjectNotFoundException, InterruptedException {
        for (int i = 0; i < 200; i++) {
//            device.click(943,996);
            UiObject downbutton = new UiObject(new UiSelector().resourceId("com.m4399.gamecenter:id/emoji_big_cell").instance(0));
            downbutton.click();
            UiObject2 picture = device.findObject(By.res("com.m4399.gamecenter:id/pic_check"));
            device.wait(Until.findObject(By.res("com.m4399.gamecenter:id/picture")), 10000);
            picture.click();
            UiObject2 confirm = device.findObject(By.res("com.m4399.gamecenter:id/confirm_btn"));
            confirm.click();
            device.wait(Until.findObject(By.res("com.m4399.gamecenter:id/emoji_big_cell")), 10000);
//            Thread.sleep(200);
        }
//        UiObject downbutton = new UiObject(new UiSelector().resourceId("com.m4399.gamecenter:id/downloadButton").instance(2));
//        downbutton.click();
    }
        @After
    public void tearDown() throws IOException {

    }
}
