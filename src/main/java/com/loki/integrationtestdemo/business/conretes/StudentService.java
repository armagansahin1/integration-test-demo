package com.loki.integrationtestdemo.business.conretes;

import com.loki.integrationtestdemo.business.abstracts.IStudentService;
import com.loki.integrationtestdemo.core.exceptions.ResourceNotFoundException;
import com.loki.integrationtestdemo.dataAccess.StudentRepository;
import com.loki.integrationtestdemo.entity.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

@Service
public class StudentService implements IStudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    @Transactional
    public StudentDAO add(StudentDAO studentDAO){
        return studentRepository.save(studentDAO);
    }

    @Override
    public StudentDAO get(Integer id) {
        return studentRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }
}
