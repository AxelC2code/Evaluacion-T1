public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("C001", "María Pérez", "maria.perez@correo.com");

        cliente.agregarPedido(new Pedido("P001", "Café americano", 2.50, 2, EstadoPedido.PENDIENTE));
        cliente.agregarPedido(new Pedido("P002", "Sandwich integral", 5.00, 1, EstadoPedido.ATENDIDO));

        System.out.println("=== Datos del cliente y pedidos ===");
        System.out.println(cliente.mostrarDatosConPedidos());

        Pedido pedidoBuscado = cliente.buscarPedidoPorCodigo("P001");
        if (pedidoBuscado != null) {
            System.out.println("\nPedido encontrado: " + pedidoBuscado);
            System.out.println("Importe del pedido P001: " + pedidoBuscado.calcularImporte());
        }

        boolean actualizado = cliente.cambiarEstadoPedido("P001", EstadoPedido.ATENDIDO);
        System.out.println("\nEstado actualizado: " + actualizado);

        System.out.println("\n=== Estado final de pedidos ===");
        System.out.println(cliente.mostrarDatosConPedidos());

        try {
            cliente.agregarPedido(new Pedido("P001", "Pedido duplicado", 3.0, 1, EstadoPedido.PENDIENTE));
        } catch (IllegalArgumentException e) {
            System.out.println("\nValidación duplicado OK: " + e.getMessage());
        }
    }
}
