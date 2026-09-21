# Evaluacion-T1
### Pruebas de la T1 -  POO
Alumno: Axel Castro Aguilar

Codigo: n00451670

Profesor: SEGUNDO JOSE CASTILLO ZUMARAN

## Identificacion de requerimientos
- **RF01**: el admin debe de poder registrar clientes con codigo, nombre completo, y correo.
- **RF02**: el admin debe de poder registrar uno o varios pedidos de los clientes.
- **RF03**: el admin debe de poder llevar un control del historial de los pedidos de los clientes.
- **RF04**: El admin debe de poder calcular el importe individual de los pedidos de los clientes.
- **RF05**: El admin debe de poder calcular el importe total de los pedidos de los clientes.
- **RF06**: El admin puede realizar la busqueda de los pedidos por medio de codigo (por motivos de gilizar la busqueda).
- **RF07**: El admin puede cambiar el estado de un pedido (PENDIENTE, ATENDIDO o CANCELADO).
- **RF08**: El admin puede validar datos de entrada para evitar registros invalidos o inconsistentes.

## Identificación de clases y responsabilidades 
### Clase Cliente
- **Atributos**: codigoCliente, nombreCompleto, correoElectronico, pedidos (ArrayList<Pedido>).
- **Responsabilidades**:
  - Gestionar los datos del cliente.
  - Agregar pedidos evitando códigos duplicados.
  - Buscar pedidos por código.
  - Cambiar estado de pedidos.
  - Calcular importe total.
  - Mostrar datos del cliente y sus pedidos.

### Clase Pedido
- **Atributos**: codigoPedido, descripcionProducto, precioUnitario, cantidad, estadoPedido.
- **Responsabilidades**:
  - Gestionar datos de un pedido.
  - Validar precio, cantidad y estado.
  - Calcular el importe (precioUnitario * cantidad).

### Enum EstadoPedido
- **Valores**: PENDIENTE, ATENDIDO, CANCELADO.
- **Responsabilidad**: restringir los estados válidos de un pedido.

### Clase Main
- **Responsabilidad**: demostrar las funcionalidades solicitadas mediante un flujo ejecutable.
## Diagrama uml

## Implementación de las clases 

## Funcionalidades que debe demostrar


