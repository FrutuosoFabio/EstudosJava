package com.fabio.todo.domain;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class todo implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String descricao;

    @JsonFormat(pattern = "dd/mm/yyyy")
    private Date dataParaFinalizar;
    private Boolean finalizar = false ;

    public todo()  {
           super() ;
        }

    public todo(Integer id, String titulo, String descricao, Date dataParaFinalizar, Boolean finalizar) {
        super();
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataParaFinalizar = dataParaFinalizar;
        this.finalizar = finalizar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataParaFinalizar() {
        return dataParaFinalizar;
    }

    public void setDataParaFinalizar( Date dataParaFinalizar) {
        this.dataParaFinalizar = dataParaFinalizar;
    }

    public Boolean getFinalizar() {
        return finalizar;
    }

    public void setFinalizar(Boolean finalizar) {
        this.finalizar = finalizar;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        todo other = (todo) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
}
