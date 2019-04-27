package model;

import java.io.Serializable;
import java.util.Objects;

public class Telefone implements Serializable {

    private String codigoPais;
    private String codigoArea;
    private String numero;
    private String completo;

    public Telefone() {
    }

    public Telefone(String codigoPais, String codigoArea, String numero) {
        this.codigoPais = codigoPais;
        this.codigoArea = codigoArea;
        this.numero = numero;
    }

    public Telefone(String completo) {
        this.completo = completo;
    }

    public String getCompleto() {
        return completo;
    }

    public void setCompleto(String completo) {
        this.completo = completo;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getCodigoArea() {
        return codigoArea;
    }

    public void setCodigoArea(String codigoArea) {
        this.codigoArea = codigoArea;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.codigoPais);
        hash = 41 * hash + Objects.hashCode(this.codigoArea);
        hash = 41 * hash + Objects.hashCode(this.numero);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Telefone other = (Telefone) obj;
        if (!Objects.equals(this.codigoPais, other.codigoPais)) {
            return false;
        }
        if (!Objects.equals(this.codigoArea, other.codigoArea)) {
            return false;
        }
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getCodigoPais() + " (" + getCodigoArea() + ") " + getNumero();
    }

    public String toStringComp() {
        return getCompleto();
    }
}
