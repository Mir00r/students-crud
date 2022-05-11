package com.mir00r.studentscrudapis.domains.students.services;

import com.mir00r.studentscrudapis.domains.students.models.entites.Student;
import com.mir00r.studentscrudapis.domains.students.repositories.StudentRepository;
import com.mir00r.studentscrudapis.exceptions.notfound.NotFoundException;
import com.mir00r.studentscrudapis.utils.Constants;
import com.mir00r.studentscrudapis.utils.ExceptionUtil;
import com.mir00r.studentscrudapis.utils.PageAttr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author mir00r on 11/5/22
 * @project IntelliJ IDEA
 */
@Service
public class StudentServiceImpl implements IStudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Page<Student> search(String query, Integer page, Integer size) {
        return this.studentRepository.search(query, PageAttr.getPageRequest(page, size));
    }

    @Override
    public Student save(Student entity) {
        return this.studentRepository.save(entity);
    }

    @Override
    public Optional<Student> find(Long id) {
        return this.studentRepository.find(id);
    }

    @Override
    public void delete(Long id, Boolean softDelete) throws NotFoundException {
        if (!softDelete) {
            this.studentRepository.deleteById(id);
            return;
        }
        Student entity = this.find(id).orElseThrow(() -> new NotFoundException(ExceptionUtil.getNotFoundMsg(Student.class.getSimpleName(), Constants.NOT_FOUND_WITH_ID, id)));
        entity.setDeleted(true);
        this.save(entity);
    }
}
