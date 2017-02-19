package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by bcxtim on 02.02.2017.
 */
public class ContactsDataTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homepage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withName("testname").withLastname("testlastname")
              .withAddress("test-address").withEmail("qw@ert.u").withEmail2("www@qq.ru").withEmail3("test@test.test")
              .withHome("111").withMobile("222-222").withWork("8(212)333"));

    }
  }

  @Test
  public void testEditPage() {
    app.goTo().homepage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditPage = app.contact().infoFromEditPage(contact);

    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditPage)));
    assertThat(contact.getAddress(), equalTo(contactInfoFromEditPage.getAddress()));
    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditPage)));
  }

  @Test(enabled = false) // пока не работает корректно, если контакт состоит в группе
  public void testDetailsPage() {
    app.goTo().homepage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditPage = app.contact().infoFromEditPage(contact);
    String contactInfoFromDetailsPage = app.contact().infoFromDetailsPage(contact).replaceAll("M:", "")
            .replaceAll("H:", "").replaceAll("W:", "").replaceAll("\n", "").replaceAll(" ", "");

    assertThat(contactInfoFromDetailsPage, equalTo(mergeData(contactInfoFromEditPage).replaceAll("\n", "")));
  }

  private String mergeData(ContactData contact) {
    return Arrays.asList(contact.getName(), contact.getLastname(), contact.getAddress(), contact.getHome(),
            contact.getMobile(), contact.getWork(), contact.getEmail(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> !s.equals(""))
            .collect(Collectors.joining("\n"));
  }

  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHome(), contact.getMobile(), contact.getWork()).stream()
            .filter((s) -> !s.equals("")).map(ContactsDataTests::cleaned).collect(Collectors.joining("\n"));
  }

  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }

  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3()).stream()
            .filter((s) -> !s.equals("")).collect(Collectors.joining("\n"));
  }

}
