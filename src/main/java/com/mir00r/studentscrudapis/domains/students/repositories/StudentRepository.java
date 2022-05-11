package com.mir00r.studentscrudapis.domains.students.repositories;

import com.mir00r.studentscrudapis.domains.students.models.entites.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author mir00r on 11/5/22
 * @project IntelliJ IDEA
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE (:q IS NULL OR s.name LIKE %:q%) AND s.deleted=false")
    Page<Student> search(@Param("q") String q, Pageable pageable);

    @Query("SELECT s FROM Student s WHERE s.id=:id AND s.deleted=false")
    Optional<Student> find(@Param("id") Long id);

    @Query("SELECT s FROM Student s WHERE s.uuid=:uuid AND s.deleted=false")
    Optional<Student> findByUuId(@Param("uuid") String uuid);
}
