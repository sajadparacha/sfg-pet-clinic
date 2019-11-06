package com.spring5.sfgpetclinic.services.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService <T,ID>  {
    protected Map<ID,T> map=new HashMap<>();

     T findById(ID id) {
        return map.get(id);
    }


     T save(ID id,T o) {
        map.put(id,o);
        return o;
    }


     Set<T> findAll() {
        return new HashSet<T>( map.values()) ;
    }


     void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }


     void deleteById(ID id) {
        map.remove(id);
    }
}
