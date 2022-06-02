package pt.ipleiria.estg.dei.ei.p2.modelo;

public abstract class Divisao extends Descritor {
    protected boolean portaAberta;

    public Divisao(String nome, boolean portaAberta) {
        super(nome);
        this.portaAberta = portaAberta;
    }

    public boolean isPortaAberta() {
        return portaAberta;
    }

    public void abrir() { portaAberta = true; }

    public void fechar() { portaAberta = false; }
}
