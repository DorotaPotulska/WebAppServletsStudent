package com.sda.javagda34.webappdemo.servlets;

import com.sda.javagda34.webappdemo.services.GradeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet
public class GradeDeleteController extends HttpServlet {

    private final GradeService gradeService= new GradeService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String gradeId = req.getParameter("gradeId");

        gradeService.deleteGrade(gradeId);

        resp.sendRedirect(req.getHeader("referer"));
    }
}
