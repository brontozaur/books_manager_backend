package com.popa.books.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "editura")
public class Editura implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idEditura", nullable = false, unique = true)
    private Long idEditura;

    @Column(name = "numeEditura", unique = true)
    private String numeEditura = "";

    public Long getIdEditura() {
        return idEditura;
    }

    public void setIdEditura(Long idEditura) {
        this.idEditura = idEditura;
    }

    public String getNumeEditura() {
        return numeEditura;
    }

    public void setNumeEditura(String numeEditura) {
        this.numeEditura = numeEditura;
    }
}
