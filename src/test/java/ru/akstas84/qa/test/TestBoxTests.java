package ru.akstas84.qa.test;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.akstas84.qa.data.TestData;
import ru.akstas84.qa.page.PracticePage;

public class TestBoxTests {

  PracticePage practicePage = new PracticePage();
  TestData testData = new TestData();
  Faker faker = new Faker();

  String firstName = faker.name().firstName();
  String lastName = faker.name().lastName();

  @BeforeAll
  static void setup() {
    Configuration.baseUrl = "https://demoqa.com";
    Configuration.startMaximized = true;
  }

  @Test
  void positiveFillTestPracticeFormTest() {
    practicePage.openPage();
    practicePage.typeRegistrationDataAndSubmit(firstName, lastName, testData);
    practicePage.checkResultsTitle();
    practicePage.checkResultsValue(firstName, lastName, testData);
  }

}
