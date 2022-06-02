package pt.ipleiria.estg.dei.ei.p2.modelo;

import java.util.LinkedList;

public class Gabinete<TFuncionario extends Funcionario> extends Divisao{

    private LinkedList<TFuncionario> funcionarios;

    public Gabinete(String nome, boolean portaAberta) {
        super(nome, portaAberta);
        funcionarios = new LinkedList<>();
    }

    public LinkedList<TFuncionario> getFuncionarios() {
        return new LinkedList<>(funcionarios);
    }

    public void adicionar(TFuncionario funcionario){
        if (funcionario == null || funcionarios.contains(funcionario)){
            return;
        }
        funcionarios.add(funcionario);
        funcionario.setGabinete(this);
    }

    public void remover(TFuncionario funcionario){
        if (!funcionarios.contains(funcionarios)){
            return;
        }
        funcionarios.remove(funcionario);
        funcionario.desassociarGabinete();
    }
}
