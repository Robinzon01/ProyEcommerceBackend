package com.robin.proyecommer.backend.repository.programacion;

import com.robin.proyecommer.backend.entity.DocumentoAlmacenado;
import com.robin.proyecommer.backend.entity.DocumentoAlmacenadoPK;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DocumentoAlmacenadoRepository extends CrudRepository<DocumentoAlmacenado, DocumentoAlmacenadoPK> {

    @Query("SELECT da FROM DocumentoAlmacenado da WHERE da.documentoAlmacenadoPK.noCia = :cia AND da.estado = 'A' AND da.eliminado = false")
    Iterable<DocumentoAlmacenado> list(String cia);

    @Query("SELECT da FROM DocumentoAlmacenado da WHERE da.documentoAlmacenadoPK.noCia = :cia AND da.fileName = :fileName AND da.estado = 'A' AND da.eliminado = false")
    Optional<DocumentoAlmacenado> findByFileName(String cia, String fileName);
}
