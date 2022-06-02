package pt.ipleiria.estg.dei.ei.p2.modelo;

import java.util.LinkedList;

public class Aula extends Identificador{
    //atributos
    //private String nome;
    //private long numero;
    private StringBuilder sumario;
    private Professor professor;
    private LinkedList<Aluno> alunos;
    private Horario horario;
    private Sala sala;

    //construtor
    public Aula(String nome, long numero, Horario horario, Sala sala){
        this(nome, numero, null, sala, null, new LinkedList<>());
        /*this.nome = nome;
        this.numero = numero;
        //this.sumario ="";
        this.sumario = new StringBuilder();
        this.professor = null;
        this.alunos = new LinkedList<>();
         */
    }

    public Aula(String nome, long numero, Horario horario, Sala sala, Professor professor, LinkedList<Aluno> alunos){
        //this.nome = nome;
        //this.numero = numero;
        super(nome, numero);
        this.horario = horario;
        //this.sala = sala;
        setSala(sala);
        this.sumario = new StringBuilder();
        //this.professor = professor;
        setProfessor(professor);
        //this.alunos = alunos;
        this.alunos = new LinkedList<>();
        for (Aluno aluno: alunos) {
            adicionar(aluno);
        }
    }

    //metodos
    //acessores
    /*
    public String getNome() {
        return nome;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }
     */

    public String getSumario() {
        //return sumario;
        return sumario.toString();
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {

        if(professor == null || this.professor == professor){
            return;
        }

        // se a aula já tinha professor desassocia o professor da aula
        if(this.professor != null){
            this.professor.remover(this);
        }
        // ou desassociarProfessor()

        //atribuir professor
        this.professor = professor;
        //adicionar a aula ao professor
        professor.adicionar(this);
    }

    public void desassociarProfessor(){
        if(professor == null){
            return;
        }
        /*
        this.professor.remover(this);
        professor = null;
        */
        Professor professorARemover = this.professor;
        this.professor = null;
        professorARemover.remover(this);
    }

    public LinkedList<Aluno> getAlunos() {
        // return alunos;
        return new LinkedList<>(alunos); //faz copia de segurança para não conseguirem manipular todos os alunos
    }

    public Horario getHorario() {
        return horario;
    }

    //funcionalidades
    public void remover(Aluno aluno){
        if (!alunos.contains(aluno)){
            return;
        }
        alunos.remove(aluno);
        aluno.remover(this);
    }

    public void adicionar(Aluno aluno){
        if(aluno == null || alunos.contains(aluno)){
            return;
        }
        alunos.add(aluno);
        aluno.adicionar(this);
    }

    public void atribuir(Professor professor){

    }

    public void adicionarLinhaSumario(String linha){
        //sumario = sumario + linha + "\n";
       /* StringBuilder sb = new StringBuilder(sumario);
        sb.append(linha).append("\n");

        sumario = sb.toString();
        */
        sumario.append(linha).append("\n");
    }

    public Sala getSala(){
        return sala;
    }

    public void setSala(Sala sala){
        if(sala == null || this.sala == sala){
            return;
        }
        //ver se o segurança já tinha gabinete
        if (this.sala != null){
            this.sala.remover(this);
        }

        this.sala = sala;
        sala.adicionar(this);
    }

    public void desassociarSala(){
        if (sala == null){
            return;
        }
        Sala salaAremover = sala;
        sala = null;
        salaAremover.remover(this);
    }
}
