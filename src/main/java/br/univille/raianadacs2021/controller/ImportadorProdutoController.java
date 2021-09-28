package br.univille.raianadacs2021.controller;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.raianadacs2021.model.Produto;

@Controller
@RequestMapping("/import-produto")
public class ImportadorProdutoController {

    @GetMapping
    public ModelAndView index(){

        return new ModelAndView("/importproduto/index");
    }
}