package ru.stqa.pft.mantis.tests;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.appmanager.HttpSession;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.UserData;
import ru.stqa.pft.mantis.model.Users;

import java.io.IOException;


import static org.testng.Assert.assertTrue;

/**
 * Created by bcxtim on 23.02.2017.
 */
public class ResetPasswordTests extends TestBase {

  @BeforeMethod
  public void startMailServer() {
    app.mail().start();
  }

  @Test
  public void testResetPassword() throws IOException {
    HttpSession session = app.newSession();
    Users users = app.db().users();
    UserData user =  new UserData();
    for (UserData u: users){
      if (u.getEmail() == "user1@localhost.localdomain"){
        user = u;
        break;
      }
    }
    String newPassword = "newpass";
    app.admin().start();
    app.admin().resetPassword(user);
    MailMessage message = app.mail().waitForMail(1, 10000).iterator().next();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    String confirmationLink = regex.getText(message.text);
    app.registration().finish(confirmationLink, newPassword);
    assertTrue(session.login(user.getUsername(), newPassword));
    assertTrue(session.isLoggedInAs(user.getUsername()));
  }

  @AfterMethod(alwaysRun = true)
  public void stopMailServer(){
    app.mail().stop();
  }
}
