package entidades;

public class Tarefa {
    private String nome;
    private String descricao;
    private boolean prioridade;
    private boolean status;
    public char[] getNome;
    
    public Tarefa(String nome, String descricao, boolean prioridade, boolean status) {
        this.nome = nome;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.status = status;
    }
    public Tarefa() {
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public boolean isPrioridade() {
        return prioridade;
    }
    public void setPrioridade(boolean prioridade) {
        this.prioridade = prioridade;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public Object nomeProperty() {
        return null;
    }
    public Object descricaoProperty() {
        return null;
    }
}
