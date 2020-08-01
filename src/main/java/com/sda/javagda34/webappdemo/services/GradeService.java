package com.sda.javagda34.webappdemo.services;

import com.sda.javagda34.webappdemo.database.EntityDao;
import com.sda.javagda34.webappdemo.model.Grade;
import com.sda.javagda34.webappdemo.model.GradeSubject;
import com.sda.javagda34.webappdemo.model.Student;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletRequest;
import java.util.Optional;

@Slf4j
public class GradeService {

    private EntityDao<Grade> gradeEntityDao = new EntityDao<>();
    private EntityDao<Student> studentEntityDao = new EntityDao<>();

    public Optional<Grade> processFormParameters(ServletRequest req) {
        String studentId = req.getParameter("studentId");
        String gradeValue = req.getParameter("gradeValue");
        String subject = req.getParameter("subject");

        Long sId;
        Double gValue;
        GradeSubject gSubject;

        try {
            sId = Long.parseLong(studentId);
            gValue = Double.parseDouble(gradeValue);
            gSubject = GradeSubject.valueOf(subject);
        } catch (Exception e) {
            log.error("Unable to parse value.");
            return Optional.empty();
        }

        Optional<Student> studentOptional = studentEntityDao.findById(sId, Student.class);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            Grade grade = new Grade(null, gValue, gSubject, null, student);
            gradeEntityDao.saveOrUpdate(grade);
            return Optional.of(grade);
        } else {
            log.error("Student not found");
        }
        return Optional.empty();
    }

    public void save(Grade grade) {
        log.info("Saving" + grade);
        gradeEntityDao.saveOrUpdate(grade);
    }

    public void deleteGrade(String gradeId) {
        Long gradeIdentifier = Long.parseLong(gradeId);

        Optional<Grade> optionalGrade = gradeEntityDao.findById(gradeIdentifier, Grade.class);

        if(optionalGrade.isPresent()){
            Grade grade = optionalGrade.get();

            gradeEntityDao.delete(grade);
        }else{
            log.error("Couldn't find grade.");
        }

    }

    public Optional<Grade> findById(String gradeId) {
        return gradeEntityDao.findById(Long.parseLong(gradeId),Grade.class);
    }
}
