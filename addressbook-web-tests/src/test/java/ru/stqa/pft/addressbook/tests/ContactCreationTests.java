package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactCreationTests extends TestBase{

    @Test
    public void ContactCreationTests() {
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().createContact(new ContactData("testname",
                        "testmiddlename",
                        "testlastname",
                        "testNickname",
                        "testtitle",
                        "testcompany",
                        "testaddress",
                        "testtelephone",
                        "testemail",
                        "test1"));
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() +1);
    }

}
