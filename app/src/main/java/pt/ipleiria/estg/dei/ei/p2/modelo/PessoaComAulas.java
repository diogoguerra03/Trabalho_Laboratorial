package pt.ipleiria.estg.dei.ei.p2.modelo;

import java.util.LinkedList;

public abstract class PessoaComAulas extends Pessoa implements RepositorioAulas, AssociavelAulas{
    //atributos
    //protected LinkedList<Aula> aulas;

    protected GestorAulas gestorAulas;

    public PessoaComAulas(String nome, long numero) {
        super(nome, numero);
        //this.aulas = new LinkedList<>();
        gestorAulas = new GestorAulas(this);
    }

    @Override
    public LinkedList<Aula> getAulas() {
        //return aulas
        //return new LinkedList<>(aulas);
        return gestorAulas.getAulas();
    }

    @Override
    public LinkedList<Aula> getAulas(Horario horario) {

        return gestorAulas.getAulas(horario);

       /* //criar uma nova lista auxiliar
        LinkedList<Aula> listAuxiliar = new LinkedList<>();

        for (Aula aula : this.aulas) {
            if (horario.isSobre(aula.getHorario())) {
                listAuxiliar.add(aula);
            }
        }
        //devolver uma lista de aulas
        return listAuxiliar;

        */
    }

    @Override
    public void adicionar(Aula aula) {

        gestorAulas.adicionar(aula);

        /*
        if (aula == null || this.aulas.contains(aula)) {
            return;
        }
        //adicionar a aula à lista de aulas
        this.aulas.add(aula);
        //associar a pessoa à aula
        associar(aula);

         */
    }

    //  protected abstract void associar(Aula aula);
    //  protected abstract void desassociar(Aula aula);
    protected abstract void escreverSumario(Aula aula);

    @Override
    public void remover(Aula aula) {
       gestorAulas.remover(aula);
       /* if (!this.aulas.contains(aula)) {
            return;
        }
        //remover a aula da lista
        this.aulas.remove(aula);
        //desassociar a pessoa da aula
        desassociar(aula);

        */
    }

    protected void assinarSumario(Aula aula) {
        aula.adicionarLinhaSumario(nome);
    }

    public void preencherSumario(Aula aula) {
        if (!contem(aula)) {
            return;
        }
        //escrever o seu sumário
        escreverSumario(aula);
    }

    @Override
    public boolean contem(Aula aula) {
        return gestorAulas.contem(aula);
    }
}
