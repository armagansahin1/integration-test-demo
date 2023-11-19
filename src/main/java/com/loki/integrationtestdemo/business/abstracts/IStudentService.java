package com.loki.integrationtestdemo.business.abstracts;

import com.loki.integrationtestdemo.entity.StudentDAO;

public interface IStudentService {
    StudentDAO add(StudentDAO studentDAO);

    StudentDAO get(Integer id);
}
