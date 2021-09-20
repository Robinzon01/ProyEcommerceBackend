package com.robin.proyecommer.backend.service.generic;

import com.robin.proyecommer.backend.service.exception.ServiceException;

import java.util.List;

public interface IGenericService<T> {
    T findById(T t) throws ServiceException;
    List<T> getAll(String cia) throws ServiceException;
    List<T> findByLike(T t) throws  ServiceException;
    T save(T t) throws ServiceException;
    T delete(T t) throws ServiceException;
}
