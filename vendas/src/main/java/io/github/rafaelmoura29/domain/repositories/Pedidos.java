package io.github.rafaelmoura29.domain.repositories;

import io.github.rafaelmoura29.domain.entity.Cliente;
import io.github.rafaelmoura29.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Pedidos extends JpaRepository<Pedido, Integer> {

    List<Pedido> findByCliente( Cliente cliente );
}
