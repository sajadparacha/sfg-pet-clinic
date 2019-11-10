package com.spring5.sfgpetclinic.services.map;

import com.spring5.sfgpetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService <T extends BaseEntity,ID extends Long>  {
    protected Map<Long,T> map=new HashMap<>();

     T findById(ID id) {
        return map.get(id);
    }


     T save(T o) {
         if(o!=null) {
             if(o.getId()==null)
                 o.setId(getNextId());
             map.put(getNextId(), o);
         }else
         {
             throw new RuntimeException("Object can't be null");
         }

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

    Long getNextId(){
         Long nextId=null;
         try {
             nextId = Collections.max(map.keySet()) + 1;
         }catch(NoSuchElementException e){
             nextId=1L;

         }
         return nextId;
    }
}
