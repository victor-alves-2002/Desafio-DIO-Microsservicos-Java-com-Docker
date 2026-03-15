package com.microsservicos.pagamento.controller;

import org.springframework.web.bind.annotation.;
import java.util.;

@RestController
@RequestMapping("/api/pagamentos")
public class PagamentoController {

    private List<Map<String, Object>> pagamentos = new ArrayList<>();

    @PostMapping
    public Map<String, Object> processar(@RequestBody Map<String, Object> pagamento) {
        String id = UUID.randomUUID().toString();

        Map<String, Object> resposta = new HashMap<>();
        resposta.put("id", id);
        resposta.put("pedidoId", pagamento.get("pedidoId"));
        resposta.put("valor", pagamento.get("valor"));
        resposta.put("status", "APROVADO");
        resposta.put("data", new Date());

        pagamentos.add(resposta);
        return resposta;
    }

    @GetMapping("/{id}")
    public Map<String, Object> buscar(@PathVariable String id) {
        return pagamentos.stream()
            .filter(p -> id.equals(p.get("id")))
            .findFirst()
            .orElse(Collections.singletonMap("erro", "Pagamento não encontrado"));
    }

    @GetMapping
    public List<Map<String, Object>> listarTodos() {
        return pagamentos;
    }
}
