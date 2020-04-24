package io.github.rafaelmoura29.service;

import io.github.rafaelmoura29.domain.entity.Pedido;
import io.github.rafaelmoura29.rest.dto.PedidoDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface PedidoService {
    Pedido salvar(PedidoDTO dto);
    Optional<Pedido> obterPedidoCompleto(Integer id);
}
