package org.controller;

import org.dao.StudentDao;
import org.model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddStudentServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        log("init method");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        log("service method");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log("get method");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/index.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log("post method");
        String name = req.getParameter("name");
        String averageMark = req.getParameter("averageMark");
        String knowsBlockchain = req.getParameter("knowsBlockchain");

        Student student = new Student();
        student.setName(name);
        student.setAverageMark(Float.parseFloat(averageMark));
        if (knowsBlockchain != null)
            student.setKnowsBlockchain(true);
        else
            student.setKnowsBlockchain(false);
        StudentDao.addStudent(student);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/index.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
