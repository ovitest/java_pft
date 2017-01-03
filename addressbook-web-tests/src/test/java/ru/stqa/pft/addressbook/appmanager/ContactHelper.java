package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends BaseHelper{

  public ContactHelper (FirefoxDriver wd){
    super(wd);
  }
  public void submitContactForm() {
      click(By.name("submit"));
  }

  public void fillContactForm(ContactData contactData) {
      type(By.name("firstname"),contactData.getName() );
      type(By.name("middlename"),contactData.getMiddlename());
      type(By.name("lastname"),contactData.getLastname());
      type(By.name("nickname"),contactData.getNickname());
      type(By.name("title"),contactData.getTitle());
      type(By.name("company"),contactData.getCompany());
      type(By.name("address"),contactData.getAddress());
      type(By.name("home"),contactData.getTelephone());
      type(By.name("email"),contactData.getEmail());

  }

  public void initContactModification() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public void submitContactModification() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }
}
