package io.github.rafaelmoura29.rest.controller;

import io.github.rafaelmoura29.domain.entity.Pedido;
import io.github.rafaelmoura29.rest.dto.PedidoDTO;
import io.github.rafaelmoura29.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer save(@RequestBody PedidoDTO dto){
        Pedido pedido = service.salvar(dto);
        return  pedido.getId();
    }
}
