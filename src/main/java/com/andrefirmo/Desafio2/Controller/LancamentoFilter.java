package com.andrefirmo.Desafio2.Controller;

import com.andrefirmo.Desafio2.Model.Lancamento;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class LancamentoFilter {

    private List<Lancamento> lancamentos;

    public LancamentoFilter(Lancamento[] lancamentos)
    {
        this.lancamentos = Arrays.asList(lancamentos);
    }

    public LancamentoFilter ByMes(int mes)
    {
        if(mes == -1)
            return this;

        lancamentos = lancamentos.stream()
                .filter(l -> l.getMes_lancamento() == mes)
                .collect(Collectors.toList());

        return this;
    }

    public LancamentoFilter BetweenValor(double min, double max)
    {
        if(min == -1 && max == -1)
            return this;

        lancamentos = lancamentos.stream()
                .filter(l -> l.getValor() >= min && (max == -1 || l.getValor() <= max))
                .collect(Collectors.toList());

        return this;
    }

    public LancamentoFilter ByCategoria(int categoria)
    {
        if(categoria == -1)
            return this;

        lancamentos = lancamentos.stream()
                .filter(l -> l.getCategoria() == categoria)
                .collect(Collectors.toList());

        return this;
    }

    public Lancamento[] toArray(){
        return lancamentos.toArray(new Lancamento[0]);
    }
}
