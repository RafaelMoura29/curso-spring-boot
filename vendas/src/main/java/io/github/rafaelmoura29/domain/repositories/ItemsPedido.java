package io.github.rafaelmoura29.domain.repositories;

import io.github.rafaelmoura29.domain.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsPedido extends JpaRepository<ItemPedido, Integer> {
}
