package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends BaseHelper{

  public ContactHelper (WebDriver wd){
    super(wd);
  }
  public void submitContactForm() {
      click(By.name("submit"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
      type(By.name("firstname"),contactData.getName() );
      type(By.name("middlename"),contactData.getMiddlename());
      type(By.name("lastname"),contactData.getLastname());
      type(By.name("nickname"),contactData.getNickname());
      type(By.name("title"),contactData.getTitle());
      type(By.name("company"),contactData.getCompany());
      type(By.name("address"),contactData.getAddress());
      type(By.name("home"),contactData.getTelephone());
      type(By.name("email"),contactData.getEmail());

      if (creation){
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
      } else {
        Assert.assertFalse(isElementPresent(By.name("new_group")));
      }
  }

  public void initContactModification(int index) {
    wd.findElements(By.cssSelector("img[title=Edit]")).get(index).click();

  }

  public void submitContactModification() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();

  }

  public void deleteSelectedContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void confirmDeletion() {
    wd.switchTo().alert().accept();

  }

  public void createContact(ContactData contact) {
    initContactCreation();
    fillContactForm(contact, true);
    submitContactForm();


  }

  private void initContactCreation() {
    click(By.xpath("//div[@id='nav']//a[.='add new']"));
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("entry")).size();
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element: elements) {
      List<WebElement> cells = element.findElements(By.tagName("td"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      ContactData contact = new ContactData(firstname, null, lastname, null, null, null, null, null, null, null);
      contacts.add(contact);
    }
    return contacts;
  }
}
