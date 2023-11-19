package com.loki.integrationtestdemo.dataAccess;

import com.loki.integrationtestdemo.entity.StudentDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentDAO,Integer> {
}
