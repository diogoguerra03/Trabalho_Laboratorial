package pt.ipleiria.estg.dei.ei.p2.modelo;

import java.util.LinkedList;

public class Professor extends PessoaComAulas
        implements Funcionario<GabineteProfessor, Sala>{

    private GestorFuncionario<GabineteProfessor, Sala> gestorFuncionario;

    // private GabineteProfessor gabinete;
    //private LinkedList<Horario> horariosAtendimento;

    //construtor(es)
    public Professor(String nome, long numero, GabineteProfessor gabinete){
        //this.nome = nome;
        //this.numero = numero;
        super(nome,numero);
        gestorFuncionario = new GestorFuncionario<>(this);
        setGabinete(gabinete);
    }

    //funcionalidades
    @Override
    public void associar(Aula aula) {
        aula.setProfessor(this);
    }

    @Override
    public void desassociar(Aula aula) {
        aula.desassociarProfessor();
    }

    @Override
    protected void escreverSumario(Aula aula) {
        //adicionar o nome da aula
        aula.adicionarLinhaSumario(aula.getNome());
        //adicionar o numero da aula
        aula.adicionarLinhaSumario(String.valueOf(aula.getNumero()));
        //assinar com o nome do professor
        //aula.adicionarLinhaSumario(nome);
        //super.assinarSumario(Aula);
        assinarSumario(aula);
        //dar aos alunos a preencher o sumario
        //percorrer a lsta de alunos da aula
        for (Aluno aluno : aula.getAlunos()){
            aluno.preencherSumario(aula);
        }
    }

    @Override
    public GabineteProfessor getGabinete() {
        //return gabinete;
        return gestorFuncionario.getGabinete();
    }

    @Override
    public void setGabinete(GabineteProfessor gabinete) {
        gestorFuncionario.setGabinete(gabinete);
    }

    @Override
    public void desassociarGabinete(){
        gestorFuncionario.desassociarGabinete();
    }

    @Override
    public LinkedList<Horario> getHorariosAtendimento() {
        //return new LinkedList<>(horariosAtendimento);
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
    public void abrir(Sala sala){
        gestorFuncionario.abrir(sala);
    }

    @Override
    public void fechar(Sala sala){
        gestorFuncionario.fechar(sala);
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
