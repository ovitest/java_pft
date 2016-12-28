package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{

    @Test
    public void ContactCreationTests() {

        gotoNewContactPage();
        fillContactForm(new ContactData("testname", "testmiddlename", "testlastname", "testNickname", "testtitle", "testcompany", "testaddress", "testtelephone", "testemail"));
        submitContactForm();
        gotoHomePage();
    }

}
