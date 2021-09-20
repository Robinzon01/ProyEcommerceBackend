package com.robin.proyecommer.backend.controller.programacion;

import com.robin.proyecommer.backend.entity.DocumentoAlmacenado;
import com.robin.proyecommer.backend.service.programacion.implementacion.DocumentoAlmacenadoServiceImple;
import com.robin.proyecommer.backend.utils.GenericResponse;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api/documento-almacenado")
public class DocumentoAlmacenadoController {
    private DocumentoAlmacenadoServiceImple service;

    public DocumentoAlmacenadoController(DocumentoAlmacenadoServiceImple service) {
        this.service = service;
    }

    @GetMapping("/cia/{cia}")
    public GenericResponse list(@PathVariable("cia") String cia) {
        return service.list(cia);
    }

    @GetMapping("/cod/{id}")
    public GenericResponse find(@PathVariable Long id) {
        return null;
    }

    @GetMapping("/download/{cia}/{fileName}")
    public ResponseEntity<Resource> download(@PathVariable("cia") String cia,@PathVariable("fileName") String fileName, HttpServletRequest request) {
        return service.downloadByFileName(cia,fileName, request);
    }

    @PostMapping
    public GenericResponse save(@ModelAttribute DocumentoAlmacenado obj) {
        return service.save(obj);
    }

    public GenericResponse update(Long aLong, DocumentoAlmacenado obj) {
        return null;
    }
    
    public GenericResponse delete(Long aLong) {
        return null;
    }
}
