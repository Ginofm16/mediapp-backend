package com.mitocode.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "signo")
public class Signo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSigno;

    @Column(name = "temperatura", nullable = false)
    private String temperatura;

    @Column(name = "pulso", nullable = false)
    private String pulso;

    @Column(name = "ritmo_cardiaco", nullable = false)
    private String ritmoCardiaco;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    public Signo() {
    }

    public Integer getIdSigno() {
        return idSigno;
    }

    public void setIdSigno(Integer idSigno) {
        this.idSigno = idSigno;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getPulso() {
        return pulso;
    }

    public void setPulso(String pulso) {
        this.pulso = pulso;
    }

    public String getRitmoCardiaco() {
        return ritmoCardiaco;
    }

    public void setRitmoCardiaco(String ritmoCardiaco) {
        this.ritmoCardiaco = ritmoCardiaco;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}

