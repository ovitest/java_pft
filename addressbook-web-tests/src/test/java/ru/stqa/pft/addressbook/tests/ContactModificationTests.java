package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;


public class ContactModificationTests extends TestBase{

  @Test
  public void testContactModification () {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("testname1", "testmiddlename", "testlastname", "testNickname", "testtitle", "testcompany", "testaddress", "testtelephone", "testemail"));
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoHomePage();

  }
}
