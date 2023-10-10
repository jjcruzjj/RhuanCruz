package entidades;

import java.util.ArrayList;

public class ListadeTarefas {
    private String nome ;
    private boolean prioridade;
    private int quantidade;
    
    public ListadeTarefas(){

    }

    public ListadeTarefas(String nome, boolean prioridade, int quantidade) {
        this.nome = nome;
        this.prioridade = prioridade;
        this.quantidade = quantidade;
    }

    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public boolean isPrioridade() {
        return prioridade;
    }
    public void setPrioridade(boolean prioridade) {
        this.prioridade = prioridade;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
