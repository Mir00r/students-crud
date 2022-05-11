package com.mir00r.studentscrudapis.commons.services;

import com.mir00r.studentscrudapis.commons.models.entities.BaseEntity;
import com.mir00r.studentscrudapis.exceptions.notfound.NotFoundException;
import org.springframework.data.domain.Page;

import java.util.Optional;

/**
 * @author mir00r on 11/5/22
 * @project IntelliJ IDEA
 */
public interface BaseCrudService<T extends BaseEntity> {
    Page<T> search(String query, Integer page, Integer size);

    T save(T entity);

    Optional<T> find(Long id);

    void delete(Long id, Boolean softDelete) throws NotFoundException;
}
