package com.RiaMoneyTrasfer.Utilities;



import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class Cookies {

    WebDriver driver;

    public Cookies(WebDriver driver) {
        this.driver = driver;
    }

    // Get all cookies
    public Set<Cookie> getAllCookies() {
        return driver.manage().getCookies();
    }

    // Get cookie by name
    public Cookie getCookie(String name) {
        return driver.manage().getCookieNamed(name);
    }

    // Add cookie
    public void addCookie(Cookie cookie) {
        driver.manage().addCookie(cookie);
    }

    // Delete cookie
    public void deleteCookie(String name) {
        driver.manage().deleteCookieNamed(name);
    }

    // Delete all cookies
    public void deleteAllCookies() {
        driver.manage().deleteAllCookies();
    }
}
