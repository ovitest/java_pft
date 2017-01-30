package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;


public class ContactModificationTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homepage();
    if (app.contact().all().size() == 0){
      app.contact().create(new ContactData().withName("test1").withLastname("test2").withGroup("test1"));

    }
  }

  @Test
  public void testContactModification () {
    Set<ContactData> before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withName("testname2")
            .withMiddlename("testmiddlename").withLastname("testlastname1").withNickname("testNickname")
            .withTitle("testtitle").withCompany("testcompany").withAddress("testaddress").withTelephone("testtelephone")
            .withEmail("testemail");
    app.contact().modify(contact);
    app.goTo().homepage();
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before, after);

  }


}
