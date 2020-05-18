package com.andrefirmo.Desafio2.Controller;

import com.andrefirmo.Desafio2.Model.Categoria;
import com.andrefirmo.Desafio2.Model.Lancamento;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
@RestController
public class HomeContoller
{
    @GetMapping(value = "/categorias")
    public String categorias(){
        final ApiHelper helper = new ApiHelper();

        Categoria[] categoria = helper.RequestCategoria();

        return helper.Serialize(categoria);

    }

    @GetMapping(value = "/lancamentos")
    public String lancamentos(
            @RequestParam(value = "categoria",  defaultValue = "-1", required =  false) int categoria,
            @RequestParam(value = "mes",        defaultValue = "-1", required = false) int mes,
            @RequestParam(value = "valormin",   defaultValue = "-1", required = false) double valorMin,
            @RequestParam(value = "valormax",   defaultValue = "-1", required = false) double valorMax)
    {
        final ApiHelper helper = new ApiHelper();

        Lancamento[] lancamentos = helper.RequestLancamentos(categoria, mes, valorMin, valorMax);

        return helper.Serialize(lancamentos);
    }
}
