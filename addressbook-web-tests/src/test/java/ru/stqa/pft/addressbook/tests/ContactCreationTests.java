package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactCreationTests extends TestBase{


    @Test
    public void ContactCreationTests() {
        app.goTo().homepage();
        Set<ContactData> before = app.contact().all();
        ContactData contact = new ContactData().withName("testname").withMiddlename("testmiddlename")
                .withLastname("testlastname").withNickname("testNickname").withTitle("testtitle")
                .withCompany("testcompany").withAddress("testaddress").withTelephone("testtelephone")
                .withEmail("testemail").withGroup("test1");
        app.contact().create(contact);
        app.goTo().homepage();
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() +1);

        contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(before, after);
    }

}
