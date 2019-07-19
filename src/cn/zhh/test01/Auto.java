package cn.zhh.test01;

import cn.zhh.common.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * 自动登录刷弹幕
 *
 * @author z_hh
 */
public class Auto {

	public static void main(String[] args) throws Throwable {
		// 设置驱动位置
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");

		// 创建一个驱动对象
		WebDriver driver = new ChromeDriver();

		// 打开指定网页
		String url = "https://www.huya.com/17859972";
		driver.navigate().to(url);

		// 智能等待一下子
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

		// 窗口最大化
		driver.manage().window().maximize();

		// 等待，直到登录元素可以点击
		WebElement loginElement = driver.findElement(By.xpath(".//*[@id=\"nav-login\"]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(loginElement));

		//点击登录
		loginElement.click();

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
		// 切换到登录框里面
		driver.switchTo().frame("UDBSdkLgn_iframe");
		
		// 账号登录
		accountLogin(driver);
		
		// 手机验证码登录
//		mobileLogin(driver);

		// 发弹幕
		Utils.send(driver);
	}
	
	private static void accountLogin(WebDriver driver) {
		// 输入账号
		driver.findElement(By.xpath(".//*[@id=\"account-login-form\"]/div[1]/input")).sendKeys("13800138000");
		// 输入密码
		driver.findElement(By.xpath(".//*[@id=\"account-login-form\"]/div[2]/input")).sendKeys("xx00");
		// 登录
		driver.findElement(By.xpath(".//*[@id=\"login-btn\"]")).click();					
	}
	
	private static void mobileLogin(WebDriver driver) {
		// 切换到手机验证码登录
        driver.findElement(By.xpath(".//*[@id=\"login-head-nav\"]/ul/li[2]")).click();

        // 输入手机号
        driver.findElement(By.xpath(".//*[@id=\"phone-login-form\"]/div[1]/input")).sendKeys("13800138000");
        
        // 发送验证码
        driver.findElement(By.xpath(".//*[@id=\"phone-login-form\"]/div[2]/span")).click();
        
        // 获取验证码输入框的值，直到够了6位数
        for (;;) {
        	String text = driver.findElement(By.xpath(".//*[@id=\"phone-login-form\"]/div[2]/input")).getAttribute("value") ; 
        	if (Objects.nonNull(text) && Objects.equals(text.length(), 6)) {
				break;
			}
		}

        // 点击登录
        driver.findElement(By.xpath(".//*[@id=\"phone-login-btn\"]")).click();
	}
}
