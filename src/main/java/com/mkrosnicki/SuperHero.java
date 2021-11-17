package com.mkrosnicki;

import java.util.Random;
import java.util.UUID;

public class SuperHero {

  private final Random random = new Random();
  private final UUID id = UUID.randomUUID();
  private String name;
  private String description;
  private String power;
  private final int age = random.nextInt(2000) + 1;

  public SuperHero(final String name, final String description, final String power) {
    this.name = name;
    this.description = description;
    this.power = power;
  }

  public UUID getId() {
    return id;
  }

  public int getAge() {
    return age;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(final String description) {
    this.description = description;
  }

  public String getPower() {
    return power;
  }

  public void setPower(final String power) {
    this.power = power;
  }
}
