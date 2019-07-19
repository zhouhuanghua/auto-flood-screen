package cn.zhh.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

/**
 * 通用工具类
 *
 * @author z_hh
 */
public class Utils {

    /**
     * 无限循环发送弹幕
     *
     * @param driver 驱动
     */
    public static void send(WebDriver driver) {
        // 弹幕内容
        String msg = "蓝公主";
        // 输入框元素
        WebElement inputElement = driver.findElement(By.xpath(".//*[@id=\"pub_msg_input\"]"));
        // 发送按钮元素
        WebElement sendElement = driver.findElement(By.xpath(".//*[@id=\"msg_send_bt\"]"));
        for (int i = 1; ; i++) {
            try {
                // 找到输入框并写入内容（为了不重复，后面拼上次数）
                inputElement.sendKeys(msg + i);

                // 点击发送
                sendElement.click();

                // 等待10秒钟，并清空输入框
                TimeUnit.SECONDS.sleep(10);
                inputElement.clear();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
