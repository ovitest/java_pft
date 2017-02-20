package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by bcxtim on 16.02.2017.
 */
public class AddContactInGroupTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homepage();
    if (app.db().contacts().size() == 0) {
      app.goTo().homepage();
      app.contact().create(new ContactData().withName("test1").withLastname("test2"));
    } else if (app.contact().notInGroup().size() == 0) {
      app.goTo().homepage();
      app.contact().create(new ContactData().withName("test1").withLastname("test2"));
    }
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testAddContactInGroup() {
    app.goTo().homepage();
    ContactData contact = app.contact().notInGroup().iterator().next();
    GroupData group = app.db().groups().iterator().next();
    Groups before = contact.getGroups();
    app.contact().addInGroup(contact, group);
    app.goTo().homepage();
    Contacts contactsAfter = app.db().contacts();
    ContactData modifiedContact = new ContactData();
    for (ContactData c : contactsAfter) {
      if (c.getId() == contact.getId()) {
        modifiedContact = c;
        break;
      }
    }
    Groups after = modifiedContact.getGroups();
    assertThat(after, equalTo(before.withAdded(group)));

  }
}
