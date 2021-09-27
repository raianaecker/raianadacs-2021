package br.univille.raianadacs2021.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.univille.raianadacs2021.model.Produto;
import br.univille.raianadacs2021.service.ProdutoService;

@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoControllerAPI {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> getAll() {
        try {
            return new ResponseEntity<List<Produto>>(produtoService.getAllProdutos(), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getById(
        @PathVariable("id") Produto produto) { 
            try {
                return new ResponseEntity<Produto>(produto, HttpStatus.OK);
            } catch (Exception exception) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<Produto> saveProduct(@RequestBody Produto produto) {
        try {
            produto.setId(0);
            produtoService.save(produto);
            return new ResponseEntity<Produto>(produto, HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Produto> deleteProductById(
        @PathVariable("id") Produto produto) {
        try {
            produtoService.delete(produto);
            return new ResponseEntity<Produto>(produto, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}