package com.andrefirmo.Desafio2.Controller;

import com.andrefirmo.Desafio2.Model.Categoria;
import com.andrefirmo.Desafio2.Model.Lancamento;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

//#Chupa Pattern
public final class ApiHelper {

    private static final String host = "https://desafio-it-server.herokuapp.com";

    //Lista geral
    //Mensal
    //Categoria
    public ApiHelper(){

    }

    public Categoria[] RequestCategoria()
    {
        WebClient client = WebClient.create(host);

        WebClient.ResponseSpec response = client
                .get().uri("/categorias")
                .retrieve();

        Mono<Categoria[]> responseMono = response.bodyToMono(Categoria[].class);

        return responseMono.block();
    }

    public Lancamento[] RequestLancamentos()
    {
        WebClient client = WebClient.create(host);

        WebClient.ResponseSpec response = client
                .get().uri("/lancamentos")
                .retrieve();

        Mono<Lancamento[]> responseMono = response.bodyToMono(Lancamento[].class);

        return responseMono.block();
    }

    public Lancamento[] RequestLancamentos(int categoria, int mes, double valorMin, double valorMax)
    {
        Lancamento[] lancamentos = RequestLancamentos();
        LancamentoFilter filter = new LancamentoFilter(lancamentos);

        return filter
                .ByCategoria(categoria)
                .ByMes(mes)
                .BetweenValor(valorMin, valorMax)
                .toArray();
    }

    public String Serialize(Object obj)
    {
        final ObjectMapper mapper = new ObjectMapper();
        String result = "";

        try {
            result = mapper.writeValueAsString(obj);
        }
        catch (JsonProcessingException e)
        {
            System.out.println(e.getMessage());
        }

        return result;
    }
}
