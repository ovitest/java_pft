package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase{

    @Test
    public void testGroupCreation() {

        gotoGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("test", "test1", "test2"));
        submitGroupCreation();
        returntoGroupPage();
    }

}
