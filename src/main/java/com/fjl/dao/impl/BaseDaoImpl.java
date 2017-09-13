package com.fjl.dao.impl;

import com.fjl.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;


public class BaseDaoImpl<T> implements BaseDao<T> {

    private HibernateTemplate hibernateTemplate;
    private Class<T> entityClass;
    //利用反射获取子类确定的泛型类
    protected BaseDaoImpl(){
        Type genType = getClass().getGenericSuperclass();
        Type[] params=((ParameterizedType)genType).getActualTypeArguments();
        entityClass = (Class<T>) params[0];
        System.out.println(entityClass+"111");
    }
    public T get(Serializable id) {
        return hibernateTemplate.get(entityClass,id);
    }

    public T load(Serializable id) {
        return hibernateTemplate.load(entityClass,id);
    }

    public List loadAll() {
        return hibernateTemplate.loadAll(entityClass);
    }

    public void save(T entity) {
        hibernateTemplate.save(entity);
    }

    public void delete(T entity) {
        hibernateTemplate.delete(entity);
    }

    public void update(T entity) {
        hibernateTemplate.update(entity);
    }

    public void find(String hql) {
        hibernateTemplate.find(hql);
    }

    public void find(String hql, Object... params) {
        hibernateTemplate.find(hql,params);
    }

    /********************************
     * get  set  方法
     *******************************/
    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }
    @Autowired
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}

