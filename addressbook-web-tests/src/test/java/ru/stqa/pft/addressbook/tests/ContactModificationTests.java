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
    app.goTo().homepage();
    if (app.contact().all().size() == 0){
      app.contact().create(new ContactData().withName("test1").withLastname("test2").withGroup("test1"));

    }
  }

  @Test
  public void testContactModification () {
    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withName("testname2")
            .withMiddlename("testmiddlename").withLastname("testlastname1").withNickname("testNickname")
            .withTitle("testtitle").withCompany("testcompany").withAddress("testaddress").withHome("testtelephone")
            .withEmail("testemail");
    app.contact().modify(contact);
    app.goTo().homepage();
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.replaced(contact, modifiedContact)));

  }


}
