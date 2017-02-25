package ru.stqa.pft.mantis.model;

/**
 * Created by Vladimir on 25.02.2017.
 */
public class Project {
  private int id;
  private String name;

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Project withId(int id) {
    this.id = id;
    return this;
  }

  public Project withName(String name) {
    this.name = name;
    return this;
  }
}
