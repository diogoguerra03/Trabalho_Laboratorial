package pt.ipleiria.estg.dei.ei.p2.modelo;

public abstract class Descritor {
    protected String nome;

    public Descritor(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
