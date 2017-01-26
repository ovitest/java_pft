package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;


public class ContactModificationTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
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
  }

  @Test
  public void testContactModification () {
    List<ContactData> before = app.getContactHelper().getContactList();
    int index = before.size() - 1;
    app.getContactHelper().initContactModification(index);
    ContactData contact = new ContactData(before.get(index).getId(),"testname1",
            "testmiddlename",
            "testlastname1",
            "testNickname",
            "testtitle",
            "testcompany",
            "testaddress",
            "testtelephone",
            "testemail",
            null);
    app.getContactHelper().fillContactForm(contact,            false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }
}
