package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactModificationTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0){
      app.goTo().homepage();
      app.contact().create(new ContactData().withName("test1").withLastname("test2"));
    }
  }

  @Test
  public void testContactModification () {
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withName("testname2")
            .withLastname("testlastname1")
            .withAddress("testaddress").withHome("testtelephone")
            .withEmail("testemail");
    app.goTo().homepage();
    app.contact().modify(contact);
    app.goTo().homepage();
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.replaced(contact, modifiedContact)));
    verifyContactListInUI();
  }


}
