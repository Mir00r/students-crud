package com.mir00r.studentscrudapis.domains.students.controllers;

import com.mir00r.studentscrudapis.commons.controllers.BaseCrudController;
import com.mir00r.studentscrudapis.domains.students.models.dtos.StudentDto;
import com.mir00r.studentscrudapis.domains.students.models.entites.Student;
import com.mir00r.studentscrudapis.domains.students.models.mappers.StudentMapper;
import com.mir00r.studentscrudapis.domains.students.services.IStudentService;
import com.mir00r.studentscrudapis.exceptions.notfound.NotFoundException;
import com.mir00r.studentscrudapis.routes.Router;
import com.mir00r.studentscrudapis.utils.Constants;
import com.mir00r.studentscrudapis.utils.ExceptionUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author mir00r on 11/5/22
 * @project IntelliJ IDEA
 */
@RestController
@Api(tags = Constants.STUDENTS)
public class StudentController implements BaseCrudController<StudentDto> {

    private final IStudentService studentService;
    private final StudentMapper studentMapper;

    @Autowired
    public StudentController(IStudentService studentService, StudentMapper studentMapper) {
        this.studentService = studentService;
        this.studentMapper = studentMapper;
    }

    @Override
    @ApiOperation(value = "Get all list of players", response = StudentDto[].class)
    @GetMapping(Router.SEARCH_ALL_STUDENTS)
    public ResponseEntity<Page<StudentDto>> search(@RequestParam(value = "q", defaultValue = "") String query,
                                                   @RequestParam(value = "page", defaultValue = "0") Integer page,
                                                   @RequestParam(value = "size", defaultValue = "10") Integer size) {

        Page<Student> entities = this.studentService.search(query, page, size);
        return ResponseEntity.ok(entities.map(this.studentMapper::map));
    }

    @Override
    @ApiOperation(value = "Get Student by id", response = StudentDto[].class)
    @GetMapping(Router.FIND_STUDENTS_BY_ID)
    public ResponseEntity<StudentDto> find(@PathVariable("id") Long id) throws NotFoundException {
        Student entity = this.studentService.find(id).orElseThrow(() -> new NotFoundException(ExceptionUtil.getNotFoundMsg(Student.class.getSimpleName(), Constants.NOT_FOUND_WITH_ID, id)));
        return ResponseEntity.ok(this.studentMapper.map(entity));
    }

    @Override
    @ApiOperation(value = "Create a new Student", response = StudentDto[].class)
    @PostMapping(Router.CREATE_STUDENTS)
    public ResponseEntity<StudentDto> create(@Valid @RequestBody StudentDto dto) {
        Student entity = this.studentService.save(this.studentMapper.map(dto, null));
        return ResponseEntity.ok(this.studentMapper.map(entity));
    }

    @Override
    @ApiOperation(value = "Update an existing Student by id", response = StudentDto[].class)
    @PatchMapping(Router.UPDATE_STUDENTS_BY_ID)
    public ResponseEntity<StudentDto> update(@PathVariable("id") Long id, @Valid @RequestBody StudentDto dto) throws NotFoundException {
        Student entity = this.studentService.find(id).orElseThrow(() -> new NotFoundException(ExceptionUtil.getNotFoundMsg(Student.class.getSimpleName(), Constants.NOT_FOUND_WITH_ID, id)));
        entity = this.studentService.save(this.studentMapper.map(dto, entity));
        return ResponseEntity.ok(this.studentMapper.map(entity));
    }

    @Override
    @ApiOperation(value = "Delete Student by id", response = StudentDto[].class)
    @DeleteMapping(Router.DELETE_STUDENTS_BY_ID)
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) throws NotFoundException {
        this.studentService.delete(id, true);
        return ResponseEntity.ok().build();
    }
}
