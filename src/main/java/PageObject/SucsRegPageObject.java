package PageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SucsRegPageObject {

 private final WebDriver driver;

 public SucsRegPageObject(WebDriver driver) {
  this.driver = driver;
 }

 public SucsRegPageObject clickNameField() {
  String nameField = "form#register_form input[name='name']";
  driver.findElement(By.cssSelector(nameField)).sendKeys("Maria");
  return this;

 }

 public SucsRegPageObject clickHobbyField() {
  String hobbyField = "(//input[@name='hobby'])[3]";
  driver.findElement(By.xpath(hobbyField)).click();
  return this;
 }

 public SucsRegPageObject clickPhoneField() {
  String phoneField = "form#register_form  input[name='phone']";
  driver.findElement(By.cssSelector(phoneField)).sendKeys("+911198765432");
  return this;
 }

 public SucsRegPageObject clickUsernameField() {
  String usernameField = "form#register_form  input[name='username']";
  driver.findElement(By.cssSelector(usernameField)).sendKeys("Maria Romanova");
  return this;
 }

 public SucsRegPageObject clickEmailField() {
  String emailField = "form#register_form  input[name='email']";
  driver.findElement(By.cssSelector(emailField)).sendKeys("test.romashka88@gmail.com");
  return this;
 }

 public SucsRegPageObject clickPasswordField() {
  String passwordField = "form#register_form  input[name='password']";
  driver.findElement(By.cssSelector(passwordField)).sendKeys("12345maria");
  return this;
 }

 public SucsRegPageObject clickCpasswordField() {
  String cPasswordField = "input[name='c_password']";
  driver.findElement(By.cssSelector(cPasswordField)).sendKeys("12345maria");
  return this;
 }

 public SucsRegPageObject clickSubmitBtn() {
  String submitBtn = "input[value='submit']";
  driver.findElement(By.cssSelector(submitBtn)).click();
  return this;
 }

 public String getRegistration() {
  String registration = "/html//section[@id='wrapper']//h2[.='Registration Form']";
  return driver.findElement(By.xpath(registration)).getText();
 }
}

