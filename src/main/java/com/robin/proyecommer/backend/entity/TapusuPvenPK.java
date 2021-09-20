package com.robin.proyecommer.backend.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class TapusuPvenPK implements Serializable {

    @Column(name = "NO_CIA")
    private String noCia;

    @Column(name = "USUARIO")
    private String usuario;

    public TapusuPvenPK() {
    }

    public TapusuPvenPK(String noCia, String usuario) {
        this.noCia = noCia;
        this.usuario = usuario;
    }

    public String getNoCia() {
        return noCia;
    }

    public void setNoCia(String noCia) {
        this.noCia = noCia;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (noCia != null ? noCia.hashCode() : 0);
        hash += (usuario != null ? usuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TapusuPvenPK)) {
            return false;
        }
        TapusuPvenPK other = (TapusuPvenPK) object;
        if ((this.noCia == null && other.noCia != null) || (this.noCia != null && !this.noCia.equals(other.noCia))) {
            return false;
        }
        if ((this.usuario == null && other.usuario != null) || (this.usuario != null && !this.usuario.equals(other.usuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TapusuPvenPK[ noCia=" + noCia + ", usuario=" + usuario + " ]";
    }
}
