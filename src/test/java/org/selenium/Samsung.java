package org.selenium;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Samsung {

    private WebDriver webdriver;
    private JavascriptExecutor js;
    private List<String> codes = new ArrayList<>();

    By creative = By.xpath("//div[contains(@class, 'bx-creative')]");
    By checkbox = By.xpath("//span[contains(@class, 'bx-checkshape')]");
    By submitForm = By.xpath("//button[contains(@class, 'bx-button')]");
    By email = By.xpath("//input[contains(@class, 'bx-input') and @name='email']");
    By coupon = By.xpath("//span[@class='coupon']");

    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        WebDriverManager.chromedriver().setup();

        webdriver = new ChromeDriver(options);
        webdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webdriver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        webdriver.manage().window().maximize();
        js = (JavascriptExecutor) webdriver;

    }

    @Test
    public void getCodes() throws AWTException {
        while (codes.size() < 13) {
            setup();
            webdriver.get("https://www.samsung.com/us/smartphones/galaxy-s21-ultra-5g/");
            js.executeScript("return document.readyState").equals("complete");

            for (int i = 0; i < 5; i++) {
                mouseGlide(3000, 400, 3000, 250, 1000, 100);
                mouseGlide(3000, 250, 3000, 400, 1000, 100);
                try {
                    if (webdriver.findElement(creative).isDisplayed()) {
                        if (webdriver.findElement(email).isDisplayed())
                            fillForm();
                        if (webdriver.findElement(coupon).isDisplayed()) {
                            getCode();
                            break;
                        }
                    }
                } catch (NoSuchElementException e) {
                    System.out.println("Something was not visible: " + e.getMessage());
                    try {
                        if (webdriver.findElement(coupon).isDisplayed()) {
                            getCode();
                            break;
                        }
                    } catch (NoSuchElementException f) {
                        System.out.println("Code was not visible.");
                    }
                }
            }

            webdriver.quit();
        }

    }

    @After
    public void teardown() {
        codes.forEach(System.out::println);
    }

    public void mouseGlide(int x1, int y1, int x2, int y2, int t, int n) {
        try {
            Robot r = new Robot();
            double dx = (x2 - x1) / ((double) n);
            double dy = (y2 - y1) / ((double) n);
            double dt = t / ((double) n);
            for (int step = 1; step <= n; step++) {
                Thread.sleep((int) dt);
                r.mouseMove((int) (x1 + dx * step), (int) (y1 + dy * step));
            }
        } catch (AWTException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void fillForm() {
        String randomname = RandomStringUtils.random(8, true, false);
        String randomnumbers = RandomStringUtils.random(4, false, true);
        String domain = "@gmail.com";
        webdriver.findElement(email).sendKeys(randomname + randomnumbers + domain);
        webdriver.findElement(checkbox).click();
        webdriver.findElement(submitForm).click();
    }

    public void getCode() {
        String code = webdriver.findElement(coupon).getText();
        System.out.println("Adding code: " + code);
        codes.add(code);
    }

}
