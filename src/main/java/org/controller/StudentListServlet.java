package org.controller;

import org.dao.StudentDao;
import org.model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class StudentListServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        StudentDao.loadData();
        log("init method");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        log("service method");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        //resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        String blockchainFilter = req.getParameter("blockchainFilter");
        String averageMarkFilter = req.getParameter("averageMarkFilter");

        log("list get method");
        List<Student> studentList;

        if (blockchainFilter != null)
            studentList = StudentDao.getStudentsBlockchain();
        else if (averageMarkFilter != null)
            studentList = StudentDao.getExcellentStudents();
        else
            studentList = StudentDao.getStudents();

        out.write("<div align=\"center\"");
        for (Student s: studentList){
            out.write(s.toString() + "<br/>");
        }
        out.write("</div>");
    }
}
