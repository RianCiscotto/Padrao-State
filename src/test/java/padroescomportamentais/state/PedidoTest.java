package padroescomportamentais.state;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {

    Pedido pedido;

    @BeforeEach
    public void setUp() {
        pedido = new Pedido();
    }

    @Test
    public void devePagarPedidoAguardandoPagamento() {
        pedido.setEstado(PedidoEstadoAguardandoPagamento.getInstance());
        assertTrue(pedido.pagar());
        assertEquals(PedidoEstadoPago.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveEnviarPedidoAguardandoPagamento() {
        pedido.setEstado(PedidoEstadoAguardandoPagamento.getInstance());
        assertFalse(pedido.enviar());
        assertEquals(PedidoEstadoAguardandoPagamento.getInstance(), pedido.getEstado());
    }
}