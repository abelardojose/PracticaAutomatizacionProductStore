package page;

import base.BasePage;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "signin2")
    private WebElement btnSign;

    @FindBy(xpath = "//button[contains(text(),'Sign up')]")
    private WebElement btnCreacionUsuario;

    @FindBy(id = "login2")
    private WebElement btnLogin;

    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    private WebElement btnIngresoUsuario;

    public void creacionUsuario(DataTable dataTable){
        if (btnSign.isDisplayed()){
            btnSign.click();
            List<Map<String, String>> lista = dataTable.asMaps(String.class, String.class);
            for (int i = 0; i < lista.size(); i++) {
                driver.findElement(By.id("sign-username")).sendKeys(lista.get(i).get("Usuario"));
                driver.findElement(By.id("sign-password")).sendKeys(lista.get(i).get("Password"));
            }
            btnCreacionUsuario.click();
        }else {
            System.out.println("No se encontro el boton de Sign");
        }
    }

    public void pasarAlerta() throws InterruptedException {
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void loginUsuario(DataTable dataTable){
        if (btnLogin.isDisplayed()){
            btnLogin.click();
            List<Map<String,String>> lista = dataTable.asMaps(String.class,String.class);
            for (int i = 0; i < lista.size(); i++) {
                driver.findElement(By.id("loginusername")).sendKeys(lista.get(i).get("Usuario"));
                driver.findElement(By.id("loginpassword")).sendKeys(lista.get(i).get("Password"));
            }
            btnIngresoUsuario.click();
        }else {
            System.out.println("No se encontro el boton de Login");
        }
    }

    public void seleccionarCategoria(String categoria) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(text(),'"+categoria+"')]")).click();
    }

    public void seleccionarCelular(String celular) {
        driver.findElement(By.xpath("//a[contains(text(),'"+celular+"')]")).click();
    }
}

