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
 * Created by bcxtim on 20.02.2017.
 */
public class RemoveContactFromGroupTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1"));
    }
    Contacts preContacts = app.db().contacts();
    Groups groups = new Groups();
    for (ContactData c : preContacts) {
      if (c.getGroups().size() != 0) {
        groups.add(c.getGroups().iterator().next());
      }
    }
    if (groups.size() == 0) {
      app.contact().create(new ContactData().withName("test").inGroup(app.db().groups().iterator().next()));
    }
  }


  @Test
  public void testRemoveContactFromGroup() {
    app.goTo().homepage();
    Contacts contacts = new Contacts(app.db().contacts());
    ContactData modifyingContact = new ContactData();
    for (ContactData c : contacts) {
      if (c.getGroups().size() > 0) {
        modifyingContact = c;
        break;
      }
    }
    Groups before = modifyingContact.getGroups();
    GroupData group = modifyingContact.getGroups().iterator().next();
    app.contact().removeFromGroup(modifyingContact, group);
    app.goTo().homepage();
    Contacts contactsAfter = new Contacts(app.db().contacts());
    ContactData modifiedContact = new ContactData();
    for (ContactData c : contactsAfter) {
      if (c.getId() == modifyingContact.getId()) {
        modifiedContact = c;
        break;
      }
    }
    Groups after = modifiedContact.getGroups();
    assertThat(after, equalTo(before.without(group)));


  }


}
