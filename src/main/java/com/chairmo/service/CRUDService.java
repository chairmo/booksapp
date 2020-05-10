package com.chairmo.service;

import java.util.List;

public interface CRUDService <T> {
    List<?> listAll();

    T getById(Integer id);

    T saveOrUpdate(T objectModel);

    void delete(Integer id);
}
