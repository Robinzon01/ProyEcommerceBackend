package com.robin.proyecommer.backend.service.programacion.implementacion;

import com.robin.proyecommer.backend.entity.TapusuPven;
import com.robin.proyecommer.backend.repository.programacion.ITapusuPvenRepo;
import com.robin.proyecommer.backend.service.exception.ServiceException;
import com.robin.proyecommer.backend.service.programacion.interfaz.ITapusuPvenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TapusuPvenServiceImple implements ITapusuPvenService {

    @Autowired
    private ITapusuPvenRepo iTapusuPvenRepo;

    @Override
    public TapusuPven findById(TapusuPven tapusuPven) throws ServiceException {
        return null;
    }

    @Override
    public List<TapusuPven> getAll(String cia) throws ServiceException {
        return null;
    }

    @Override
    public List<TapusuPven> findByLike(TapusuPven tapusuPven) throws ServiceException {
        return null;
    }

    @Override
    public TapusuPven save(TapusuPven tapusuPven) throws ServiceException {
        return null;
    }

    @Override
    public TapusuPven delete(TapusuPven tapusuPven) throws ServiceException {
        return null;
    }

    @Override
    public TapusuPven login(String email, String clave) throws SecurityException {
        return null;
    }
}
