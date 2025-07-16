package org.database.jbdl_springJPA.repository;

import jakarta.transaction.Transactional;
import org.database.jbdl_springJPA.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

public interface StudentRepository extends JpaRepository<Student , Integer> {
    Student findByName(String name);

    Student findByEmail(String email);

    Student findByEmailAndName(String email, String name);

    @Query("from student s where s.name=?1 and s.email=?2")
    Student findByEmailAndNameCustomQuery(String name, String email);

    @Query("update student s set s.email=:email where s.id=:id")
    @Modifying
    @Transactional
    void updateByEmail(int id, String email);

}
