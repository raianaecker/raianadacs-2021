package br.univille.raianadacs2021.controller;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/import-produto")
public class ImportadorProdutoController {


    @GetMapping
    public ModelAndView index(){
        try {
            URL url = new URL("http://f423-186-237-248-5.ngrok.io/api/v1/produtos");
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();

            int responseCode = connection.getResponseCode();
            connection.setRequestMethod("GET");
            connection.connect();
            Scanner scanner = new Scanner(url.openStream());

            while(scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (MalformedURLException urlException){
            urlException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return new ModelAndView("/importador-produto/index");
    }

}