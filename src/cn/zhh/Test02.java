package cn.zhh;

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

public class Test02 {
	public static void main(String[] args) throws Throwable {
        // 设置驱动位置
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");


        // 创建一个驱动对象
        WebDriver driver = new ChromeDriver(options);

        System.out.println(driver.getTitle());
    }
}
