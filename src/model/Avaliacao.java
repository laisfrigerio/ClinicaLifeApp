/**
 * @author Lais Frigério da Silva
 */

package model;

import java.util.Date;

public class Avaliacao {
    private int id;
    private String diagnosticoClinico, diagnosticoFisio, medico;
    private Date dataAvaliacao;
    private Profissional fisioterapeuta;
    private Paciente paciente;
    
    public Avaliacao(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiagnosticoClinico() {
        return diagnosticoClinico;
    }

    public void setDiagnosticoClinico(String diagnosticoClinico) {
        this.diagnosticoClinico = diagnosticoClinico;
    }

    public String getDiagnosticoFisio() {
        return diagnosticoFisio;
    }

    public void setDiagnosticoFisio(String diagnosticoFisio) {
        this.diagnosticoFisio = diagnosticoFisio;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public Date getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(Date dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    public Profissional getFisioterapeuta() {
        return fisioterapeuta;
    }

    public void setFisioterapeuta(Profissional fisioterapeuta) {
        this.fisioterapeuta = fisioterapeuta;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    
}
