/**
 * @author Lais Frigério da Silva
 */

package model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Horario {
    private int id;
    private Time hora;
    private List<Agenda> agendamentos;
    
    public Horario() {
        this.agendamentos = new ArrayList(5);
        for(int i = 0; i<5; i++)
            this.agendamentos.add(new Agenda());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }
    
    public List<Agenda> getAgendamentos() {
        return this.agendamentos;
    }
    
    public Agenda getAgendamento(int column){
        if (!this.agendamentos.isEmpty() && this.agendamentos.size() > column-1)
            return this.agendamentos.get(column-1);
        return null;
    }
    
    public void setAgendamento(int column, Agenda agenda) {
        this.agendamentos.add(column-1, agenda);
    }
}
