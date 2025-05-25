package org.example.psklab1.interfaces;

import java.util.List;

public interface GenericDAO<T> {

    List<T> getAll();

    T create(T t);

    T findById(Long id);

    T deleteById(Long id);

    T update(T t);
}
