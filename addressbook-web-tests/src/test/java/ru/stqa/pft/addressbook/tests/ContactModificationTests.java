package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;


public class ContactModificationTests extends TestBase{

  @Test
  public void testContactModification () {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("test1",
              "test2",
              null,
              null,
              null,
              null,
              null,
              null,
              null,
              "test1"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().initContactModification(before.size() -1);
    app.getContactHelper().fillContactForm(new ContactData("testname1",
            "testmiddlename",
            "testlastname1",
            "testNickname",
            "testtitle",
            "testcompany",
            "testaddress",
            "testtelephone",
            "testemail",
            null),
            false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

  }
}
