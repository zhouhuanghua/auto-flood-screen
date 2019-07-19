package cn.zhh.test02;

import cn.zhh.common.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * 刷屏
 *
 * @author
 */
public class Flood {

	public static void main(String[] args) throws Throwable {
        // 设置驱动位置
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");

        // 配置选项(端口跟打开浏览器时设置的要一样)。还有其它的，此处不做介绍
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9527");


        // 创建一个驱动对象
        WebDriver driver = new ChromeDriver(options);

        System.out.println(driver.getTitle());

        Utils.send(driver);
    }
}
