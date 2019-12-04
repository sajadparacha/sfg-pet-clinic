package com.spring5.sfgpetclinic.services.map;

import com.spring5.sfgpetclinic.model.BaseEntity;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
/**
 * If no profile is defined spring will have a default profile , otherwise the profiles defined will be taken.
 * In this case since we have not defined a profile yet default will be used by Spring hence this class will be loaded
 */
@Profile({"default","map"})
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
