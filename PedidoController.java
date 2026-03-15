package com.microsservicos.pedido.controller;

import org.springframework.web.bind.annotation.;
import java.util.;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private List<Map<String, Object>> pedidos = new ArrayList<>();

    @GetMapping
    public List<Map<String, Object>> listarTodos() {
        return pedidos;
    }

    @PostMapping
    public Map<String, Object> criar(@RequestBody Map<String, Object> pedido) {
        pedido.put("id", UUID.randomUUID().toString());
        pedido.put("dataCriacao", new Date());
        pedidos.add(pedido);
        return pedido;
    }

    @GetMapping("/{id}")
    public Map<String, Object> buscarPorId(@PathVariable String id) {
        return pedidos.stream()
            .filter(p -> id.equals(p.get("id")))
            .findFirst()
            .orElse(Collections.singletonMap("erro", "Pedido não encontrado"));
    }

    @DeleteMapping("/{id}")
    public Map<String, String> deletar(@PathVariable String id) {
        pedidos.removeIf(p -> id.equals(p.get("id")));
        return Collections.singletonMap("mensagem", "Pedido removido com sucesso");
    }
}
