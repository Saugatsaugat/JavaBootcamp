package com.saugat.bootcamp.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public abstract class AbstractService<T, ID> implements IService<T, ID> {

    public abstract JpaRepository<T, ID> getRepository();

    @Override
    public T get(ID id) {
        return getRepository().findById(id).get();
    }

    @Override
    public List<T> get() {
        return getRepository().findAll();
    }

    @Override
    public T create(T obj) {
        return getRepository().save(obj);
    }

    @Override
    public T edit(ID id, T obj) {
        if(getRepository().existsById(id)){
            return getRepository().save(obj);
        }
        return null;
    }

    @Override
    public void delete(ID id) {
        getRepository().deleteById(id);
    }


}
