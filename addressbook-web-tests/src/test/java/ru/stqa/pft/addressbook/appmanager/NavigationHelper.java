package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by bcxtim on 03.01.2017.
 */
public class NavigationHelper extends BaseHelper {

  public NavigationHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void gotoGroupPage() {
      click(By.linkText("groups"));
  }

  public void gotoHomePage() {
      click(By.linkText("home page"));
  }

  public void gotoNewContactPage() {
      click(By.linkText("add new"));
  }
}
