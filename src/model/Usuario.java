/**
 * @author Lais Frigério da Silva
 */

package model;

import java.io.Serializable;

public class Usuario implements Serializable {
    private int id, tipoFunc;
    private String nome, login, senha;
    private Profissional profissional;
    
    public Usuario(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String usuario) {
        this.login = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public int getTipoFunc() {
        return tipoFunc;
    }

    public void setTipoFunc(int tipoFunc) {
        this.tipoFunc = tipoFunc;
    }   
}
