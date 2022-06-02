package pt.ipleiria.estg.dei.ei.p2.modelo;

import java.util.LinkedList;

public class GestorAulas {
    private AssociavelAulas associavelAulas;
    private LinkedList<Aula> aulas;

    public LinkedList<Aula> getAulas() {
        return new LinkedList<>(aulas);
    }

    public LinkedList<Aula> getAulas(Horario horario){
        LinkedList<Aula> aulasAux = new LinkedList<>();
        for (Aula aula: aulas) {
            if (aula.getHorario().isSobre(horario)){
                aulasAux.add(aula);
            }
        }
        return aulasAux;
    }

    public void adicionar(Aula aula){
        if(aula == null || aulas.contains(aula)){
            return;
        }
        aulas.add(aula);
        //  aula.setSala(this);
        associavelAulas.associar(aula);
    }

    public void remover(Aula aula){
        if (!aulas.contains(aula)){
            return;
        }
        aulas.remove(aula);
        //  aula.desassociarSala();
        associavelAulas.desassociar(aula);
    }

    public boolean contem(Aula aula){
        return aulas.contains(aula);
    }

    public GestorAulas(AssociavelAulas associavelAulas) {
        this.associavelAulas = associavelAulas;
        aulas = new LinkedList<>();
    }
}
