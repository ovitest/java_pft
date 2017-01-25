package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase{

    @Test
    public void ContactCreationTests() {
        app.getNavigationHelper().gotoHomePage();
        int before = app.getContactHelper().getContactCount();
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
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before +1);
    }

}
