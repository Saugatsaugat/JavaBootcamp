package com.saugat.bootcamp.service;

import java.util.List;

public interface IService<T, ID> {

    public T get(ID id);

    public List<T> get();

    public T create(T obj);

    public T edit(ID id, T obj);

    public void delete(ID id);
}
