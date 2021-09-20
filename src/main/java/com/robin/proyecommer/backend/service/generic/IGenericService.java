package com.robin.proyecommer.backend.service.generic;


import com.robin.proyecommer.backend.service.exception.ServiceException;

import java.util.List;

public interface IGenericService<T> {
    T findById(Long id) throws ServiceException;
    List<T> getAll() throws ServiceException;
    List<T> findByLike(T t) throws  ServiceException;
    T save(T t) throws ServiceException;
    T delete(Long id) throws ServiceException;
}
