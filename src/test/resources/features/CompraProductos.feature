Feature: Compra de productos en Product Sore

  @CompraUnCelular
  Scenario: Compra de un celular Samsung galaxy s6
    Given el usuario ingresa a la pagina de Product Store
    And realiza el login a la pagina
    |Usuario  |Password  |
    |abelardo |jose159753|
    When selecciona el celular Samsung galaxy
    And lo añade al carrito de compras
    And realiza la orden de compra
    And ingresa los datos de la orden de compra
    |Name     |Country  |City    |Credit card      |Month |Year |
    |Abelardo |Chiclayo |Monsefu |9876045738120753 |Abril |2023 |
    Then validamos que la compra fue exitosa "Thank you for your order!"

