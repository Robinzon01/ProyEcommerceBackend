package com.robin.proyecommer.backend.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.math.BigInteger;

@Embeddable
public class DocumentoAlmacenadoPK implements Serializable {

    @Column(name = "NO_CIA")
    private String noCia;

    @Column(name = "CODIGO")
    private BigInteger codigo;

    public DocumentoAlmacenadoPK() {
    }

    public DocumentoAlmacenadoPK(String noCia, BigInteger codigo) {
        this.noCia = noCia;
        this.codigo = codigo;
    }

    public String getNoCia() {
        return noCia;
    }

    public void setNoCia(String noCia) {
        this.noCia = noCia;
    }

    public BigInteger getCodigo() {
        return codigo;
    }

    public void setCodigo(BigInteger codigo) {
        this.codigo = codigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (noCia != null ? noCia.hashCode() : 0);
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentoAlmacenadoPK)) {
            return false;
        }
        DocumentoAlmacenadoPK other = (DocumentoAlmacenadoPK) object;
        if ((this.noCia == null && other.noCia != null) || (this.noCia != null && !this.noCia.equals(other.noCia))) {
            return false;
        }
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FACTU.DocumentoAlmacenadoPK[ noCia=" + noCia + ", codigo=" + codigo + " ]";
    }

}
