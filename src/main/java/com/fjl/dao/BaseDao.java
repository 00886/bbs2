package com.fjl.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {
    T get(Serializable id);
    T load(Serializable id);
    List<T> loadAll();
    void save(T entity);
    void delete(T entity);
    void update(T entity);
    void find(String hql);
    void find(String hql,Object...params);
}
