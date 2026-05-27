package com.whayan.odontosys.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_consultas")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;

    @Column(nullable = false, length = 20)
    private String status;


    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;


    @ManyToOne
    @JoinColumn(name = "dentista_id", nullable = false)
    private Dentista datis;


    public Consulta() {
    }

    public Consulta(Long id, LocalDateTime dataHora, String status, Paciente paciente, Dentista dentista) {
        this.id = id;
        this.dataHora = dataHora;
        this.status = status;
        this.paciente = paciente;
        this.datis = dentista;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }

    public Dentista getDentista() { return datis; }
    public void setDentista(Dentista dentista) { this.datis = dentista; }
}