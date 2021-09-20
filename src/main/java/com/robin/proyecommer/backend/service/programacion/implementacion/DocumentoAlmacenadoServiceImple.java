package com.robin.proyecommer.backend.service.programacion.implementacion;

import com.robin.proyecommer.backend.entity.DocumentoAlmacenado;
import com.robin.proyecommer.backend.repository.programacion.DocumentoAlmacenadoRepository;
import com.robin.proyecommer.backend.utils.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import java.io.IOException;
import java.util.HashMap;

import static com.robin.proyecommer.backend.utils.Global.*;

@Service
@Transactional
public class DocumentoAlmacenadoServiceImple {

    @Autowired
    private DocumentoAlmacenadoRepository repo;

    private FileStorageService storageService;

    public DocumentoAlmacenadoServiceImple(DocumentoAlmacenadoRepository repo, FileStorageService storageService) {
        this.repo = repo;
        this.storageService = storageService;
    }

    public GenericResponse<Iterable<DocumentoAlmacenado>> list(String cia) {
        return new GenericResponse<Iterable<DocumentoAlmacenado>>(TIPO_RESULT, RPTA_OK, OPERACION_CORRECTA, repo.list(cia));
    }


    public GenericResponse find(Long aLong) {
        return null;
    }


    public GenericResponse save(DocumentoAlmacenado obj) {
        String fileName = (repo.findById(obj.getDocumentoAlmacenadoPK())).orElse(new DocumentoAlmacenado()).getFileName();

        String originalFilename = obj.getFile().getOriginalFilename();
        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));

        fileName = storageService.storeFile(obj.getFile(), fileName);

        obj.setFileName(fileName);
        obj.setExtension(extension);

        return new GenericResponse(TIPO_DATA, RPTA_OK,OPERACION_CORRECTA,repo.save(obj));
    }

    public ResponseEntity<Resource> download(String completefileName, HttpServletRequest request) {
        Resource resource = storageService.loadResource(completefileName);
        String contentType = null;

        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    public ResponseEntity<Resource> downloadByFileName(String cia,String fileName, HttpServletRequest request) {
        DocumentoAlmacenado doc = repo.findByFileName(cia,fileName).orElse(new DocumentoAlmacenado());
        return download(doc.getCompleteFileName(), request);
    }


    public GenericResponse delete(Long aLong) {
        return null;
    }

    public HashMap<String, Object> validate(DocumentoAlmacenado obj) {
        return null;
    }
}
