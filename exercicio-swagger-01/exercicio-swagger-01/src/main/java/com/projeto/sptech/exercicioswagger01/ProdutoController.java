package com.projeto.sptech.exercicioswagger01;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private List<Produto> produtos= new ArrayList<>();

    @PostMapping
    public ResponseEntity postUsuario(@RequestBody Produto novoProduto) {
        if (novoProduto.getNome().length() < 2 || novoProduto.getPrecoUnitario() < 0.01) {
            return ResponseEntity.status(400).body("Nome inválido");

        } else if (novoProduto.getQuantidadeEstoque() < 0.01) {
            return ResponseEntity.status(400).body("Produto inválido");

        }

        return ResponseEntity.status(201).body("Novo produto"+novoProduto);

    }

    @GetMapping
    public ResponseEntity<List<Produto>> getProdutos() {
        return produtos.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(produtos);
    }

    @DeleteMapping("/produtos/{posicao}")
    public ResponseEntity deleteProduto(@PathVariable int posicao) {

            if (posicao < 0 || posicao > produtos.size()) {
                Produto produtoExcluido = produtos.get(posicao);

                return ResponseEntity.status(400).body("Posição inválida");
            }
           produtos.remove(posicao);
           return  ResponseEntity.status(200).body(posicao);

    }

}
