package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bcxtim on 07.02.2017.
 */
public class ContactDataGenerator {
  @Parameter(names = "-c", description = "Contact Count")
  public int count;

  @Parameter (names = "-f", description = "Target File")
  public String file;

  @Parameter (names = "-d", description = "Data format")
  public String format;

  public static void main(String[] args) throws IOException {
    ContactDataGenerator contactDataGenerator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(contactDataGenerator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex){
      jCommander.usage();
      return;
    }
    contactDataGenerator.run();

  }

  private void run() throws IOException {
    List<ContactData> contacts = generateContacts(count);
    if (format.equals("xml")){
      saveAsXml(contacts, new File(file));
    } else if (format.equals("json")) {
      saveAsJson(contacts, new File(file));
    } else {
      System.out.println("Unrecognized format " + format);
    }
  }



  private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(contacts);
    Writer writer = new FileWriter(file);
    writer.write(json);
    writer.close();
  }

  private void saveAsXml(List<ContactData> contacts, File file) throws IOException {
    XStream xstream = new XStream();
    xstream.processAnnotations(ContactData.class);
    xstream.alias("contact", ContactData.class);
    String xml = xstream.toXML(contacts);
    Writer writer = new FileWriter(file);
    writer.write(xml);
    writer.close();

  }

  private List<ContactData> generateContacts(int count) {
    List<ContactData> contacts = new ArrayList<ContactData>();
    for(int i = 0; i < count; i++) {
      contacts.add(new ContactData().withName(String.format("name %s", i)).withLastname(String.format("lastname %s", i))
              .withAddress(String.format("address %s", i)).withHome(String.format("%s-%s-%s", i, i, i))
              .withMobile(String.format("222-222-%s", i)).withWork(String.format("(111) 123-45-%s", i))
              .withEmail(String.format("%s@test.test", i)).withEmail2(String.format("%s@test.test2", i))
              .withEmail3(String.format("%s@test.test3", i)));
    }
    return contacts;
  }
}

