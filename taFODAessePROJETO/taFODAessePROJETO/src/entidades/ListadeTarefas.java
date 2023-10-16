package entidades;

import java.util.ArrayList;
import java.util.List;

public class ListadeTarefas {
    private String nome ;
    private boolean prioridade;
    private ArrayList<Tarefa> l;
    
    
    public ListadeTarefas(String nome, boolean prioridade){
        l = new ArrayList<>();
    }




    public void adicionarTarefa(Tarefa t,  ArrayList<Tarefa> l) {
        l.add(t);
    }

    
    public List<Tarefa> getTarefas() {
        return l;
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

}
