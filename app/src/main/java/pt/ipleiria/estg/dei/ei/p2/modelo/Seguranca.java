package pt.ipleiria.estg.dei.ei.p2.modelo;

import java.util.LinkedList;

public class Seguranca extends Pessoa
        implements Funcionario<GabineteSeguranca, Divisao> {
    //private GabineteSeguranca gabinete;
    private GestorFuncionario<GabineteSeguranca, Divisao> gestorFuncionario;

    public Seguranca(String nome, long numero, GabineteSeguranca gabinete) {
        super(nome, numero);
        //this.gabinete = gabinete;

        gestorFuncionario = new GestorFuncionario(this);
        setGabinete(gabinete);
    }

    @Override
    public GabineteSeguranca getGabinete() {
        //return gabinete;
        return gestorFuncionario.getGabinete();
    }

    @Override
    public void setGabinete(GabineteSeguranca gabinete) {
        gestorFuncionario.setGabinete(gabinete);
    }

    @Override
    public void desassociarGabinete(){
        gestorFuncionario.desassociarGabinete();
    }

    @Override
    public LinkedList<Horario> getHorariosAtendimento(){
        return gestorFuncionario.getHorariosAtendimento();
    }

    @Override
    public void adicionar(Horario horario){
        gestorFuncionario.adicionar(horario);
    }
    @Override
    public void remover(Horario horario){
        gestorFuncionario.remover(horario);
    }

    @Override
    public void abrir(Divisao divisao){
        gestorFuncionario.abrir(divisao);
    }

    @Override
    public void fechar(Divisao divisao){
        gestorFuncionario.fechar(divisao);
    }

    @Override
    public void abrirGabinete(){
        gestorFuncionario.abrirGabinete();
    }
    @Override
    public void fecharGabinete() {
        gestorFuncionario.fecharGabinete();
    }

}
