package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase{

    @Test
    public void ContactCreationTests() {

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
    }

}
