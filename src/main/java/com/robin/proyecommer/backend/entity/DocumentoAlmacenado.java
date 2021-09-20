package com.robin.proyecommer.backend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Table(name = "DOCUMENTO_ALMACENADO")
public class DocumentoAlmacenado implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected DocumentoAlmacenadoPK documentoAlmacenadoPK;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "FILE_NAME")
    private String fileName;

    @Column(name = "EXTENSION")
    private String extension;

    @Column(name = "ESTADO")
    private String estado;

    @Column(name = "ELIMINADO")
    private boolean eliminado;

    @Transient
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private MultipartFile file;

    @Transient
    private String urlFile;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getUrlFile() {
        return urlFile;
    }

    public void setUrlFile(String urlFile) {
        this.urlFile = urlFile;
    }

    public boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public String getCompleteFileName() {
        return fileName + extension;
    }

    public DocumentoAlmacenado() {
        nombre = "";
        fileName = "";
        extension = "";
        estado = "A";
    }

    public DocumentoAlmacenado(DocumentoAlmacenadoPK documentoAlmacenadoPK) {
        this.documentoAlmacenadoPK = documentoAlmacenadoPK;
    }

    public DocumentoAlmacenado(String noCia, BigInteger codigo) {
        this.documentoAlmacenadoPK = new DocumentoAlmacenadoPK(noCia, codigo);
    }

    public DocumentoAlmacenadoPK getDocumentoAlmacenadoPK() {
        return documentoAlmacenadoPK;
    }

    public void setDocumentoAlmacenadoPK(DocumentoAlmacenadoPK documentoAlmacenadoPK) {
        this.documentoAlmacenadoPK = documentoAlmacenadoPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentoAlmacenadoPK != null ? documentoAlmacenadoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentoAlmacenado)) {
            return false;
        }
        DocumentoAlmacenado other = (DocumentoAlmacenado) object;
        if ((this.documentoAlmacenadoPK == null && other.documentoAlmacenadoPK != null) || (this.documentoAlmacenadoPK != null && !this.documentoAlmacenadoPK.equals(other.documentoAlmacenadoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FACTU.DocumentoAlmacenado[ documentoAlmacenadoPK=" + documentoAlmacenadoPK + " ]";
    }
}
