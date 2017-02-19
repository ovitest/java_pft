package ru.stqa.pft.addressbook.tests;

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
public class ContactsInGroupsTests extends TestBase {

  @Test
  public void testAddContactInGroup () {
    ContactData contact = app.db().contacts().iterator().next();
    GroupData group = app.db().groups().iterator().next();
    Groups before = contact.getGroups();
    app.goTo().homepage();
    app.contact().addInGroup(contact, group);
    app.goTo().homepage();
    Contacts contactsAfter = app.db().contacts();
    ContactData modifiedContact = new ContactData();
    for (ContactData c: contactsAfter) {
      if (c.getId() == contact.getId()) {
        modifiedContact = c;
        }
    }
    Groups after = modifiedContact.getGroups();
    assertThat(after, equalTo(before.withAdded(group)));

  }
}
