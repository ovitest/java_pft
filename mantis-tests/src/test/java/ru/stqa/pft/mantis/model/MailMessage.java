package ru.stqa.pft.mantis.model;

/**
 * Created by bcxtim on 23.02.2017.
 */
public class MailMessage {

  public String to;
  public String text;

  public MailMessage( String to, String text){
    this.to = to;
    this.text = text;
  }
}
