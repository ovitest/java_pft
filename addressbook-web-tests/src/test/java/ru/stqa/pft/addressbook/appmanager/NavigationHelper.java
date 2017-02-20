package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by bcxtim on 03.01.2017.
 */
public class NavigationHelper extends BaseHelper {

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void groupPage() {
    if (isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPresent(By.name("new"))){
      return;
    }
      click(By.linkText("groups"));
  }

  public void homepage() {
    if (isElementPresent(By.id("maintable"))){
      return;
    }

     click(By.id("logo"));
  }

  public void gotoNewContactPage() {
    if (isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Edit / add address book entry")
            && isElementPresent(By.name("submit"))){
      return;
    }
      click(By.linkText("add new"));
  }
}
