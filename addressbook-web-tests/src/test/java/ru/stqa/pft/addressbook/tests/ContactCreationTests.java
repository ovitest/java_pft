package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase{

    @Test
    public void ContactCreationTests() {

        app.getNavigationHelper().gotoNewContactPage();
        app.getContactHelper().fillContactForm(new ContactData("testname", "testmiddlename", "testlastname", "testNickname", "testtitle", "testcompany", "testaddress", "testtelephone", "testemail"));
        app.getContactHelper().submitContactForm();
        app.getNavigationHelper().gotoHomePage();
    }

}
