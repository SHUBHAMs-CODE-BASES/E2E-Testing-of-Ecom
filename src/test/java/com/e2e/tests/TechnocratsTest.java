package com.e2e.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TechnocratsTest extends BaseTest {

    @Test
    public void testWebsiteTitle() {
        driver.get("https://technocratsgroup.edu.in/");
        String title = driver.getTitle();
        System.out.println("Page Title is: " + title);
        Assert.assertTrue(title.contains("Technocrats"), "Title should contain 'Technocrats'");
    }
}
