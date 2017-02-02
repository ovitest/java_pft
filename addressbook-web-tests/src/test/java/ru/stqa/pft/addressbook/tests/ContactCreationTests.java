package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase{


    @Test
    public void ContactCreationTests() {
        app.goTo().homepage();
        Contacts before = app.contact().all();
        ContactData contact = new ContactData().withName("testname").withMiddlename("testmiddlename")
                .withLastname("testlastname").withNickname("testNickname").withTitle("testtitle")
                .withCompany("testcompany").withAddress("testaddress").withHome("testtelephone").withMobile("222")
                .withEmail("testemail").withGroup("test1");
        app.contact().create(contact);
        app.goTo().homepage();
        assertThat(app.contact().count(), equalTo(before.size() +1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }

}
