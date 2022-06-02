package pt.ipleiria.estg.dei.ei.p2.modelo;

public class Horario {
    //atributos
    private DiaSemana diaSemana;
    private int horaDeInicio;
    private int duracao;

    //construtor(es)
    public Horario(DiaSemana diaSemana, int horaDeInicio, int duracao){
        this.diaSemana = diaSemana;
        this.horaDeInicio = horaDeInicio;
        this.duracao = duracao;
    }

    //metodos
    public DiaSemana getDiaSemana() {
        return diaSemana;
    }

    public int getHoraDeInicio() {
        return horaDeInicio;
    }

    public int getDuracao() {
        return duracao;
    }

    public boolean isSobre(Horario horario){
        int horaFimThis = this.horaDeInicio + this.duracao;
        int horaFimHorario = horario.horaDeInicio + horario.duracao;

        /*if(this.diaSemana == horario.diaSemana &&
                horaFimHorario > this.horaDeInicio &&
                horaFimThis > horario.horaDeInicio){
            return true;
        }
        return false;
         */

        return this.diaSemana == horario.diaSemana &&
                horaFimHorario > this.horaDeInicio &&
                horaFimThis > horario.horaDeInicio;
    }

    @Override
    public String toString() {
        return diaSemana + " " +horaDeInicio + "h - " + (horaDeInicio+duracao) + "h";
    }
}
