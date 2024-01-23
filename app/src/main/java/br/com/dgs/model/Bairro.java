package br.com.dgs.model;

import java.util.Objects;

public class Bairro {
    private String id;
    private String nome;
    private String uf;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Bairro() {
    }

    public Bairro(String id, String nome, String uf) {
        this.id = id;
        this.nome = nome;
        this.uf = uf;
    }

    @Override
    public String toString() {
        return "Bairro{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", uf='" + uf + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bairro bairro = (Bairro) o;
        return id.equals(bairro.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
