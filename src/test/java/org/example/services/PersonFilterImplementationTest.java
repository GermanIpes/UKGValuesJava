package org.example.services;

import org.example.model.Person;
import org.example.model.UKGvalues;
import org.example.services.impl.PersonFilterImplementation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class PersonFilterImplementationTest {
  private PersonFilterImplementation service;

  @BeforeEach
  public void before() {
    service = new PersonFilterImplementation();
  }

  @Test
  public void validatePersonWithoutAttitudes() {
    Person person = new Person("Leona", "Maguire", new ArrayList<>());

    Boolean result = service.filterPersonByAttitudes(person);

    Assertions.assertEquals(result, false);
  }

  @Test
  public void validatePersonWith1Attitude() {
    Person person = new Person("Leona", "Maguire", new ArrayList<>(List.of(UKGvalues.KIND)));

    Boolean result = service.filterPersonByAttitudes(person);

    Assertions.assertEquals(result, false);
  }

  @Test
  public void validatePersonWith2Attitudes() {
    Person person = new Person("Leona", "Maguire", new ArrayList<>(List.of(UKGvalues.KIND, UKGvalues.RESPECTFUL)));

    Boolean result = service.filterPersonByAttitudes(person);

    Assertions.assertEquals(result, false);
  }

  @Test
  public void validatePersonWith3AttitudesWithoutRespectful() {
    Person person = new Person("Leona", "Maguire", new ArrayList<>(
            List.of(UKGvalues.KIND, UKGvalues.COOPERATIVE, UKGvalues.PASSIONATE))
    );

    Boolean result = service.filterPersonByAttitudes(person);

    Assertions.assertEquals(result, false);
  }

  @Test
  public void validatePersonWith3AttitudesWithoutKind() {
    Person person = new Person("Leona", "Maguire", new ArrayList<>(
            List.of(UKGvalues.RESPECTFUL, UKGvalues.COOPERATIVE, UKGvalues.PASSIONATE))
    );

    Boolean result = service.filterPersonByAttitudes(person);

    Assertions.assertEquals(result, false);
  }

  @Test
  public void validatePersonWith3Attitudes() {
    Person person = new Person("Leona", "Maguire", new ArrayList<>(
            List.of(UKGvalues.KIND, UKGvalues.RESPECTFUL, UKGvalues.PASSIONATE))
    );

    Boolean result = service.filterPersonByAttitudes(person);

    Assertions.assertEquals(result, true);
  }

  @Test
  public void validatePersonWithMoreThan3Attitudes() {
    Person person = new Person("Leona", "Maguire", new ArrayList<>(
            List.of(UKGvalues.KIND, UKGvalues.RESPECTFUL, UKGvalues.PASSIONATE, UKGvalues.SKILLED))
    );

    Boolean result = service.filterPersonByAttitudes(person);

    Assertions.assertEquals(result, true);
  }
}