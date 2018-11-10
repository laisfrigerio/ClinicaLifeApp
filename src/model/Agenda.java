package model;

import java.sql.Timestamp;

public class Agenda {
    private int id;
    private Profissional profissional; 
    private Consulta consulta;
    private Timestamp dataAgendamento;
    private int numeroSessao;
    private String observacao;
    private String repetir;
    
    public static final String DIARIAMENTE = "Diariamente";
    public static final String SEMANALMENTE = "Semanalmente";
    public static final String QUINZENALMENTE = "Quinzenalmente";
    public static final String MENSALMENTE = "Mensalmente";
    public static final String ANUALMENTE = "Anualmente";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public Timestamp getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(Timestamp dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public int getNumeroSessao() {
        return numeroSessao;
    }

    public void setNumeroSessao(int numeroSessao) {
        this.numeroSessao = numeroSessao;
    }

    public String getObservacao() {
        return this.observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    public String getRepetir() {
        return repetir;
    }

    public void setRepetir(String repetir) {
        this.repetir = repetir;
    }
}
