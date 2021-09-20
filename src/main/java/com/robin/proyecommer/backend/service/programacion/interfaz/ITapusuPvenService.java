package com.robin.proyecommer.backend.service.programacion.interfaz;

import com.robin.proyecommer.backend.entity.TapusuPven;
import com.robin.proyecommer.backend.service.generic.IGenericService;

public interface ITapusuPvenService extends IGenericService<TapusuPven> {
    TapusuPven login(String email,String clave) throws SecurityException;
}
