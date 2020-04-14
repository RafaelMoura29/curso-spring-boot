package io.github.rafaelmoura29.domain.repositories;

import io.github.rafaelmoura29.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Pedidos extends JpaRepository<Pedido, Integer> {
}
