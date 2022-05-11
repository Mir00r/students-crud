package com.mir00r.studentscrudapis.domains.students.models.mappers;

import com.mir00r.studentscrudapis.commons.models.mappers.BaseMapper;
import com.mir00r.studentscrudapis.domains.students.models.dtos.StudentDto;
import com.mir00r.studentscrudapis.domains.students.models.entites.Student;
import org.springframework.stereotype.Component;

/**
 * @author mir00r on 11/5/22
 * @project IntelliJ IDEA
 */
@Component
public class StudentMapper implements BaseMapper<Student, StudentDto> {
    @Override
    public StudentDto map(Student entity) {
        StudentDto dto = new StudentDto();

        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());

        dto.setName(entity.getName());
        return dto;
    }

    @Override
    public Student map(StudentDto dto, Student exEntity) {
        Student entity = exEntity == null ? new Student() : exEntity;
        entity.setName(dto.getName());
        return entity;
    }
}
