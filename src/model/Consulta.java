/**
 * @author Lais Frigério da Silva
 */

package model;

public class Consulta {
    private int id, qntdSessao;
    private double valor;
    private Paciente cliente;
    private Procedimento procedimento;
    
    public Consulta(){}

    public Paciente getCliente() {
        return cliente;
    }

    public void setCliente(Paciente cliente) {
        this.cliente = cliente;
    }

    public Procedimento getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQntdSessao() {
        return qntdSessao;
    }

    public void setQntdSessao(int qntdSessao) {
        this.qntdSessao = qntdSessao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Paciente getPaciente() {
        return cliente;
    }

    public void setPaciente(Paciente p) {
        this.cliente = p;
    }   
}
