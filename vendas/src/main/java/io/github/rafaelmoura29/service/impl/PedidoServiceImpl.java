package io.github.rafaelmoura29.service.impl;

import io.github.rafaelmoura29.domain.repositories.Pedidos;
import io.github.rafaelmoura29.service.PedidoService;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {

    private Pedidos repository;

    public PedidoServiceImpl(Pedidos repository) {
        this.repository = repository;
    }
}
