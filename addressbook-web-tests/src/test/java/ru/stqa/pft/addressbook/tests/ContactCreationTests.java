package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase{


    @Test
    public void ContactCreationTests() {
        app.goTo().homepage();
        List<ContactData> before = app.contact().list();
        ContactData contact = new ContactData("testname",
                "testmiddlename",
                "testlastname",
                "testNickname",
                "testtitle",
                "testcompany",
                "testaddress",
                "testtelephone",
                "testemail",
                "test1");
        app.contact().create(contact);
        app.goTo().homepage();
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() +1);

        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }

}
