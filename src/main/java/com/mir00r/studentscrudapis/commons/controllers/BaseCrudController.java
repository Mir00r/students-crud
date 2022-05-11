package com.mir00r.studentscrudapis.commons.controllers;

import com.mir00r.studentscrudapis.commons.models.dtos.BaseDto;
import com.mir00r.studentscrudapis.exceptions.notfound.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

/**
 * @author mir00r on 11/5/22
 * @project IntelliJ IDEA
 */
public interface BaseCrudController<T extends BaseDto> {
    ResponseEntity<Page<T>> search(String query, Integer page, Integer size);

    ResponseEntity<T> find(Long id) throws NotFoundException;

    ResponseEntity<T> create(T dto);

    ResponseEntity<T> update(Long id, T dto) throws NotFoundException;

    ResponseEntity<Object> delete(Long id) throws NotFoundException;
}
