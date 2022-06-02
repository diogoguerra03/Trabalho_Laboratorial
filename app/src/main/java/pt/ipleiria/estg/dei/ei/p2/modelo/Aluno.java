package pt.ipleiria.estg.dei.ei.p2.modelo;

public class Aluno extends PessoaComAulas {
    //Atributos


    //construtor
    public Aluno(String nome, long numero){
        super(nome,numero);
    }

    //Metodos
    @Override
    public void associar(Aula aula) {
        aula.adicionar(this);
    }

    @Override
    public void desassociar(Aula aula) {
        aula.remover(this);
    }

    @Override
    protected void escreverSumario(Aula aula) {
        //assinar o sumario
        assinarSumario(aula);
    }
}
