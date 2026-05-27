package com.whayan.odontosys.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_dentistas")

public class Dentista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, unique = true, length = 20)
    private String cro;

    @Column(nullable = false, length = 50)
    private String especialidade;

    @Column(length = 20)
    private String telefone;

    public Dentista() {
    }

    public Dentista(Long id, String nome, String cro, String especialidade, String telefone) {
        this.id = id;
        this.nome = nome;
        this.cro = cro;
        this.especialidade = especialidade;
        this.telefone = telefone;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCro() { return cro; }
    public void setCro(String cro) { this.cro = cro; }

    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
}