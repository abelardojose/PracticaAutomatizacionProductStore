package page;

import base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DescripcionProductoPage extends BasePage {
    public DescripcionProductoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h2[contains(text(),'Samsung galaxy s6')]")
    private WebElement txtNombreProducto;

    @FindBy(xpath = "//a[contains(text(),'Add to cart')]")
    private WebElement btnAddToCart;

    @FindBy(id = "cartur")
    private WebElement btnCarritoCompras;

    public void añadirAlCarrito(String producto){
        if (txtNombreProducto.getText().equals(producto)){
            btnAddToCart.click();
        }else {
            System.out.println("No se añadio al carrito");
        }
    }

    public void irAlCarritoCompras(){
        wait.until(ExpectedConditions.visibilityOf(btnCarritoCompras));
        btnCarritoCompras.click();
    }
}
