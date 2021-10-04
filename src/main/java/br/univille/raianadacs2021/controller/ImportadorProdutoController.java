package br.univille.raianadacs2021.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.raianadacs2021.model.Produto;
import br.univille.raianadacs2021.service.FornecedorService;

@Controller
@RequestMapping("/import-produto")
public class ImportadorProdutoController {

    @Autowired
    private FornecedorService fornecedorService;

    @Autowired
    private ProdutoService produtoService;
    
    @GetMapping
    public ModelAndView index(@ModelAttribute Fornecedor fornecedor){

        List<Fornecedor> listaFornecedor = fornecedorService.getAllFornecedores();

        return new ModelAndView("/importproduto/index", "listafornecedor", listaFornecedor);
    }

    @PostMapping
    public ModelAndView busca(Fornecedor fornecedor){
        
        fornecedor = fornecedorService.getFornecedor(fornecedor.getId());
        List<Produto> listaProduto = produtoService.importProduto(fornecedor);
        List<Fornecedor> listaFornecedor = fornecedorService.getAllFornecedores();

        HashMap<String,Object> dados = new HashMap<>();
        dados.put("listafornecedor", listaFornecedor);
        dados.put("listaproduto", listaProduto);

        return new ModelAndView("/importproduto/index", dados);
    }
}
