package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase{


    @Test
    public void ContactCreationTests() {
        app.goTo().homepage();
        Contacts before = app.contact().all();
        File photo = new File("src/test/resources/images.jpg");
        ContactData contact = new ContactData().withName("testname")
                .withLastname("testlastname").withAddress("testaddress").withHome("testtelephone").withMobile("222")
                .withEmail("testemail").withPhoto(photo);
        app.contact().create(contact);
        app.goTo().homepage();
        assertThat(app.contact().count(), equalTo(before.size() +1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }

    @Test (enabled = false)
    public void testCurDir () {
        File curDir = new File(".");
        System.out.println(curDir.getAbsolutePath());
        File photo = new File("src/test/resources/images.jpg");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());
    }


}
