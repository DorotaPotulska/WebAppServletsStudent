package com.sda.javagda34.webappdemo.servlets;

import com.sda.javagda34.webappdemo.model.Grade;
import com.sda.javagda34.webappdemo.model.GradeSubject;
import com.sda.javagda34.webappdemo.services.GradeService;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
@Slf4j
@WebServlet
public class GradeEditController extends HttpServlet {

    private final GradeService gradeService = new GradeService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String gradeId = req.getParameter("gradeId");
        String studentId = req.getParameter("studentId");

        Optional<Grade> gradeOptional =gradeService.findById(gradeId);

        if(gradeOptional.isPresent()){
            Grade grade = gradeOptional.get();
            req.setAttribute("grade",grade);
            req.setAttribute("studentId",studentId);
            req.setAttribute("gradeSubjectList", Arrays.asList(GradeSubject.values()));

            req.getRequestDispatcher("/gradeForm.jsp").forward(req,resp);
        }else{
            log.error("unable to find grade.");
            resp.sendRedirect(req.getHeader("referer"));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<Grade> optionalGrade = gradeService.processFormParameters(req);
        if(optionalGrade.isPresent()){

        }
    }
}
