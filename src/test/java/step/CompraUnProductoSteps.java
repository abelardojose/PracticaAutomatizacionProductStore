package step;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import page.CarritoComprasPage;
import page.DescripcionProductoPage;
import page.HomePage;

public class CompraUnProductoSteps {

    HomePage homePage;
    DescripcionProductoPage descripcionProductoPage;
    CarritoComprasPage carritoComprasPage;

    public CompraUnProductoSteps(){
        homePage = new HomePage(Hooks.driver);
        descripcionProductoPage = new DescripcionProductoPage(Hooks.driver);
        carritoComprasPage = new CarritoComprasPage(Hooks.driver);
    }

    @Given("el usuario ingresa a la pagina de Product Store")
    public void elUsuarioIngresaALaPaginaDeProductStore() {
        Hooks.driver.get("https://www.demoblaze.com/index.html");
    }

    @And("realiza el login a la pagina")
    public void realizaElLoginALaPagina(DataTable dataTable) throws InterruptedException {
        homePage.creacionUsuario(dataTable);
        homePage.pasarAlerta();
        homePage.loginUsuario(dataTable);
    }

    @When("selecciono la categoria {string}")
    public void seleccionoLaCategoria(String categoria) throws InterruptedException {
        homePage.seleccionarCategoria(categoria);
    }

    @And("selecciona el celular {string}")
    public void seleccionaElCelular(String celular) throws InterruptedException {
        homePage.seleccionarCelular(celular);
        descripcionProductoPage.añadirAlCarrito(celular);
        homePage.pasarAlerta();
    }

    @And("lo añade al carrito de compras")
    public void loAñadeAlCarritoDeCompras() {
        descripcionProductoPage.irAlCarritoCompras();
    }

    @And("realiza la orden de compra")
    public void realizaLaOrdenDeCompra() {
        carritoComprasPage.realizarOrdenProducto();
    }

    @And("ingresa los datos de la orden de compra")
    public void ingresaLosDatosDeLaOrdenDeCompra(DataTable dataTable) {
        carritoComprasPage.ingresarDatosDeCompra(dataTable);
    }

    @Then("validamos que la compra fue exitosa {string}")
    public void validamosQueLaCompraFueExitosa(String  validacion) {
        Assert.assertEquals(carritoComprasPage.validarCompra(),validacion);
    }

}
