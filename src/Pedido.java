public class Pedido {
    private String codigoPedido;
    private String descripcionProducto;
    private double precioUnitario;
    private int cantidad;
    private EstadoPedido estadoPedido;

    public Pedido() {
        this.codigoPedido = "";
        this.descripcionProducto = "";
        this.precioUnitario = 1.0;
        this.cantidad = 1;
        this.estadoPedido = EstadoPedido.PENDIENTE;
    }

    public Pedido(String codigoPedido, String descripcionProducto, double precioUnitario, int cantidad, EstadoPedido estadoPedido) {
        setCodigoPedido(codigoPedido);
        setDescripcionProducto(descripcionProducto);
        setPrecioUnitario(precioUnitario);
        setCantidad(cantidad);
        setEstadoPedido(estadoPedido);
    }

    public String getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(String codigoPedido) {
        if (codigoPedido == null || codigoPedido.trim().isEmpty()) {
            throw new IllegalArgumentException("El código del pedido no debe estar vacío.");
        }
        this.codigoPedido = codigoPedido.trim();
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        if (descripcionProducto == null || descripcionProducto.trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción no debe estar vacía.");
        }
        this.descripcionProducto = descripcionProducto.trim();
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        if (precioUnitario <= 0) {
            throw new IllegalArgumentException("El precio unitario debe ser mayor que cero.");
        }
        this.precioUnitario = precioUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero.");
        }
        this.cantidad = cantidad;
    }

    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoPedido estadoPedido) {
        if (estadoPedido == null) {
            throw new IllegalArgumentException("El estado del pedido no es válido.");
        }
        this.estadoPedido = estadoPedido;
    }

    public double calcularImporte() {
        return precioUnitario * cantidad;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "codigo='" + codigoPedido + '\'' +
                ", descripcion='" + descripcionProducto + '\'' +
                ", precioUnitario=" + precioUnitario +
                ", cantidad=" + cantidad +
                ", estado=" + estadoPedido +
                ", importe=" + calcularImporte() +
                '}';
    }
}
