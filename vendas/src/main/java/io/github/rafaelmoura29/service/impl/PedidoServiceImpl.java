package io.github.rafaelmoura29.service.impl;

import io.github.rafaelmoura29.domain.entity.Cliente;
import io.github.rafaelmoura29.domain.entity.ItemPedido;
import io.github.rafaelmoura29.domain.entity.Pedido;
import io.github.rafaelmoura29.domain.entity.Produto;
import io.github.rafaelmoura29.domain.repositories.Clientes;
import io.github.rafaelmoura29.domain.repositories.ItemsPedido;
import io.github.rafaelmoura29.domain.repositories.Pedidos;
import io.github.rafaelmoura29.domain.repositories.Produtos;
import io.github.rafaelmoura29.exception.RegraNegocioException;
import io.github.rafaelmoura29.rest.dto.ItemPedidoDTO;
import io.github.rafaelmoura29.rest.dto.PedidoDTO;
import io.github.rafaelmoura29.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final Pedidos repository;
    private final Clientes clientesRepository;
    private final Produtos produtosRepository;
    private final ItemsPedido itemsPedidoRepository;

    @Override
    @Transactional
    public Pedido salvar(PedidoDTO dto) {
        Integer idCliente = dto.getCliente();
        Cliente cliente = clientesRepository
                                .findById(idCliente)
                                .orElseThrow(() -> new RegraNegocioException("Código do cliente inválido!"));

        Pedido pedido = new Pedido();
        pedido.setTotal(dto.getTotal());
        pedido.setDataPedido(LocalDate.now());
        pedido.setCliente(cliente);

        List<ItemPedido> itemsPedido = converterItens(pedido, dto.getItems());
        repository.save(pedido);
        itemsPedidoRepository.saveAll(itemsPedido);
        pedido.setItens(itemsPedido);
        return pedido;
    }

    private List<ItemPedido> converterItens(Pedido pedido, List<ItemPedidoDTO> items){
        if(items.isEmpty()){
            throw new RegraNegocioException("Não é possível realizar o pedido sem itens");
        }

        return items
                .stream()
                .map( dto -> {
                    Integer idProduto = dto.getProduto();
                    Produto produto = produtosRepository
                            .findById(idProduto)
                            .orElseThrow(() -> new RegraNegocioException("Código do produto inválido!"));

                   ItemPedido itemPedido = new ItemPedido();
                   itemPedido.setQuantidade(dto.getQuantidade());
                   itemPedido.setPedido(pedido);
                   itemPedido.setProduto(produto);

                   return itemPedido;
                }).collect(Collectors.toList());
    }

}
