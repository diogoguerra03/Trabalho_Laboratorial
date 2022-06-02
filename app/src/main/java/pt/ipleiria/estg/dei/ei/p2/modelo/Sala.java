package pt.ipleiria.estg.dei.ei.p2.modelo;

import java.util.LinkedList;

public class Sala extends Divisao implements RepositorioAulas, AssociavelAulas{
    //private LinkedList<Aula> aulas;
    private GestorAulas gestorAulas;

    public Sala(String nome, boolean portaAberta) {
        super(nome, portaAberta);
        //aulas = new LinkedList<Aula>();
        gestorAulas = new GestorAulas(this);
    }

    @Override
    public LinkedList<Aula> getAulas() {
        //return new LinkedList<>(aulas);
        return gestorAulas.getAulas();
    }

    @Override
    public LinkedList<Aula> getAulas(Horario horario){
        return gestorAulas.getAulas(horario);
    }

    @Override
    public void adicionar(Aula aula){
        gestorAulas.adicionar(aula);
    }

    @Override
    public void remover(Aula aula){
        gestorAulas.remover(aula);
    }

    @Override
    public boolean contem(Aula aula){
        return false;
    }

    @Override
    public void associar(Aula aula) {
        aula.setSala(this);
    }

    @Override
    public void desassociar(Aula aula) {
        aula.desassociarSala();
    }
}
