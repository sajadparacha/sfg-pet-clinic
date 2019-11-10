package com.spring5.sfgpetclinic.services;

import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public interface CrudService<T, ID> {
    T findById(ID id);
    T save(T t);
    Set<T> findAll();
    void delete(T object);
    void deleteById(ID id);


}
