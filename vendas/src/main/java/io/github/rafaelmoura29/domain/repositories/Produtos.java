package io.github.rafaelmoura29.domain.repositories;

import io.github.rafaelmoura29.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Produtos extends JpaRepository<Produto, Integer> {

}
