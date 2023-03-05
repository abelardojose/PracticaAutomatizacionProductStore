package page;

import base.BasePage;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Map;

public class CarritoComprasPage extends BasePage {
    public CarritoComprasPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[contains(text(),'Place Order')]")
    private WebElement btnPlaceOrder;

    @FindBy(xpath = "//button[contains(text(),'Purchase')]")
    private WebElement btnComprar;

    public void realizarOrdenProducto(){
        if (driver.findElements(By.xpath("//table[1]/tbody")).size() != 0){
            btnPlaceOrder.click();
        }else {
            System.out.println("No tiene productos en su carrito");
        }
    }

    public void ingresarDatosDeCompra(DataTable dataTable) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("orderModalLabel"))));
        List<Map<String,String>> datosCompra = dataTable.asMaps(String.class,String.class);
        for (int i = 0; i < datosCompra.size(); i++) {
            driver.findElement(By.id("name")).sendKeys(datosCompra.get(i).get("Name"));
            driver.findElement(By.id("country")).sendKeys(datosCompra.get(i).get("Country"));
            driver.findElement(By.id("city")).sendKeys(datosCompra.get(i).get("City"));
            driver.findElement(By.id("card")).sendKeys(datosCompra.get(i).get("Credit card"));
            driver.findElement(By.id("month")).sendKeys(datosCompra.get(i).get("Month"));
            driver.findElement(By.id("year")).sendKeys(datosCompra.get(i).get("Year"));
        }
        btnComprar.click();
    }

    public String validarCompra() {
        return driver.findElement(By.xpath("//h2[contains(text(),'Thank you for your purchase!')]")).getText();
    }
}
