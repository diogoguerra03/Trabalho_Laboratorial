package pt.ipleiria.estg.dei.ei.p2.modelo;

import java.util.LinkedList;

public class GestorFuncionario<TGabinete extends Gabinete, TDivisao extends Divisao> {
    private final Funcionario<TGabinete, TDivisao> funcionario;
    private LinkedList<Horario> horariosAtendimento;
    private TGabinete gabinete;

    public GestorFuncionario(Funcionario<TGabinete, TDivisao> funcionario) {
        this.funcionario = funcionario;
        this.horariosAtendimento = new LinkedList<>();
        gabinete = null;
    }

    public LinkedList<Horario> getHorariosAtendimento() {
        return new LinkedList<>(horariosAtendimento);
    }

    public void adicionar(Horario horario) {
        if (horario == null || horariosAtendimento.contains(horario)) {
            return;
        }
        horariosAtendimento.add(horario);
    }

    public void remover(Horario horario) {
        horariosAtendimento.remove(horario);
    }

    public TGabinete getGabinete() {
        return gabinete;
    }

    public void setGabinete(TGabinete gabinete) {
        if (gabinete == null || this.gabinete == gabinete) {
            return;
        }
        //ver se o funcionario já tinha gabinete
        if (this.gabinete != null) {
            this.gabinete.remover(funcionario);
        }

        this.gabinete = gabinete;
        gabinete.adicionar(funcionario);
    }

    public void desassociarGabinete() {
        if (gabinete == null) {
            return;
        }
        //gabinete.remover(this);
        //gabinete = null;
        TGabinete gabineteAremover = gabinete;
        gabinete = null;
        gabineteAremover.remover(funcionario);
    }

    public void abrirGabinete() {
        if (gabinete == null || !gabinete.isPortaAberta()) {
            return;
        }
        gabinete.abrir();
    }

    public void fecharGabinete() {
        if (gabinete == null || !gabinete.isPortaAberta()) {
            return;
        }
        gabinete.fechar();
    }

    public void abrir(TDivisao divisao) {
        if (divisao == null || divisao.isPortaAberta()) {
            return;
        }

        divisao.abrir();
    }

    public void fechar(TDivisao divisao) {
        if (divisao == null || !divisao.isPortaAberta()) {
            return;
        }
        divisao.fechar();
    }
}