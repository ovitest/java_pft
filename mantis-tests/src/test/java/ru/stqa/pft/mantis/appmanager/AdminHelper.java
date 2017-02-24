package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import ru.stqa.pft.mantis.model.UserData;

/**
 * Created by bcxtim on 23.02.2017.
 */
public class AdminHelper extends BaseHelper {


  public AdminHelper(ApplicationManager app) {
    super(app);
  }

  public void start(){
    wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
    type(By.name("username"), app.getProperty("web.adminLogin"));
    type(By.name("password"), app.getProperty("web.adminPassword"));
    click(By.cssSelector("input[type='submit']"));
  }

  public void users(){
    wd.get(app.getProperty("web.baseUrl") + "/manage_user_page.php");
  }

  public void selectUserById(UserData user){
    click(By.cssSelector("a[href='manage_user_edit_page.php?user_id=" + user.getId() + "'"));

  }

  public void resetPassword(UserData user) {
    wd.get(app.getProperty("web.baseUrl") + "/manage_user_edit_page.php?user_id=" + user.getId());
    click(By.cssSelector("input[value='Сбросить пароль']"));
  }
}
