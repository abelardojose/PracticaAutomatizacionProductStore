package step;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CompraUnProductoSteps {
    @Given("el usuario ingresa a la pagina de Product Store")
    public void elUsuarioIngresaALaPaginaDeProductStore() {
    }

    @And("realiza el login a la pagina")
    public void realizaElLoginALaPagina(DataTable dataTable) {
    }

    @When("selecciona el celular Samsung galaxy")
    public void seleccionaElCelularSamsungGalaxy() {
    }

    @And("lo añade al carrito de compras")
    public void loAñadeAlCarritoDeCompras() {
    }

    @And("realiza la orden de compra")
    public void realizaLaOrdenDeCompra() {
    }

    @And("ingresa los datos de la orden de compra")
    public void ingresaLosDatosDeLaOrdenDeCompra(DataTable dataTable) {
    }

    @Then("validamos que la compra fue exitosa {string}")
    public void validamosQueLaCompraFueExitosa(String arg0) {
    }
}
