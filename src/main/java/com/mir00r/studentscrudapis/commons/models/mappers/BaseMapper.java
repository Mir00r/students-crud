package com.mir00r.studentscrudapis.commons.models.mappers;


import com.mir00r.studentscrudapis.commons.models.dtos.BaseDto;
import com.mir00r.studentscrudapis.commons.models.entities.BaseEntity;

/**
 * @author mir00r on 11/5/22
 * @project IntelliJ IDEA
 */
public interface BaseMapper<T extends BaseEntity, S extends BaseDto> {
    S map(T entity);

    T map(S dto, T exEntity);
}
