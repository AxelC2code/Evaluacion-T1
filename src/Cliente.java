import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cliente {
    private String codigoCliente;
    private String nombreCompleto;
    private String correoElectronico;
    private final List<Pedido> pedidos;

    public Cliente() {
        this.codigoCliente = "";
        this.nombreCompleto = "";
        this.correoElectronico = "";
        this.pedidos = new ArrayList<>();
    }

    public Cliente(String codigoCliente, String nombreCompleto, String correoElectronico) {
        this();
        setCodigoCliente(codigoCliente);
        setNombreCompleto(nombreCompleto);
        setCorreoElectronico(correoElectronico);
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        if (codigoCliente == null || codigoCliente.trim().isEmpty()) {
            throw new IllegalArgumentException("El código del cliente no debe estar vacío.");
        }
        this.codigoCliente = codigoCliente.trim();
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        if (nombreCompleto == null || nombreCompleto.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre completo no debe estar vacío.");
        }
        this.nombreCompleto = nombreCompleto.trim();
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        if (correoElectronico == null || !correoElectronico.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")) {
            throw new IllegalArgumentException("El correo electrónico no es válido.");
        }
        this.correoElectronico = correoElectronico.trim();
    }

    public List<Pedido> getPedidos() {
        return Collections.unmodifiableList(pedidos);
    }

    public void agregarPedido(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("El pedido no puede ser nulo.");
        }
        if (buscarPedidoPorCodigo(pedido.getCodigoPedido()) != null) {
            throw new IllegalArgumentException("No se permiten pedidos duplicados por código.");
        }
        pedidos.add(pedido);
    }

    public Pedido buscarPedidoPorCodigo(String codigoPedido) {
        if (codigoPedido == null || codigoPedido.trim().isEmpty()) {
            return null;
        }
        for (Pedido pedido : pedidos) {
            if (pedido.getCodigoPedido().equalsIgnoreCase(codigoPedido.trim())) {
                return pedido;
            }
        }
        return null;
    }

    public boolean cambiarEstadoPedido(String codigoPedido, EstadoPedido nuevoEstado) {
        Pedido pedido = buscarPedidoPorCodigo(codigoPedido);
        if (pedido == null) {
            return false;
        }
        pedido.setEstadoPedido(nuevoEstado);
        return true;
    }

    public double calcularImporteTotal() {
        double total = 0;
        for (Pedido pedido : pedidos) {
            total += pedido.calcularImporte();
        }
        return total;
    }

    public String mostrarDatosConPedidos() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente{codigo='").append(codigoCliente)
                .append("', nombre='").append(nombreCompleto)
                .append("', correo='").append(correoElectronico)
                .append("'}\n");

        if (pedidos.isEmpty()) {
            sb.append("Sin pedidos registrados.");
        } else {
            sb.append("Pedidos:\n");
            for (Pedido pedido : pedidos) {
                sb.append(" - ").append(pedido).append("\n");
            }
            sb.append("Importe total: ").append(calcularImporteTotal());
        }
        return sb.toString();
    }
}
