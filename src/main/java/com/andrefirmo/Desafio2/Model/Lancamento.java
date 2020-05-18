package com.andrefirmo.Desafio2.Model;

public final class Lancamento {
    private int id;

    private double valor;

    private  String origem;

    private int categoria;

    private int mes_lancamento;

    public Lancamento(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getMes_lancamento() {
        return mes_lancamento;
    }

    public void setMes_lancamento(int mes_lancamento) {
        this.mes_lancamento = mes_lancamento;
    }
}
