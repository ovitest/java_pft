package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

  @Test
  public void deleteContactTest (){
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedGroup();
    app.getContactHelper().confirmDeletion();
    app.getNavigationHelper().gotoHomePage();

  }
}
