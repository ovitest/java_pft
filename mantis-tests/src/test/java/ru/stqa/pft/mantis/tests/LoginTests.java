package ru.stqa.pft.mantis.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.mantis.appmanager.HttpSession;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

/**
 * Created by bcxtim on 21.02.2017.
 */
public class LoginTests extends TestBase {

  @Test
  public void testLogin() throws IOException {
    HttpSession session = app.newSession();
    assertTrue(session.login("administrator", "root2"));
    assertTrue(session.isLoggedInAs("administrator"));
  }
}
