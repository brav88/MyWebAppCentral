/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package auth.pck.myapp;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.pck.myapp.User;

/**
 *
 * @author Personal
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String email = request.getParameter("txtEmail");
        //String pwd = request.getParameter("txtPwd");
        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
        }

        //TO-DO preguntar en la base de datos si ese usuario existe
        if (true) {
            User user = new User();
            user.setName("Samuel");

            session = request.getSession();
            session.setAttribute("Name", user.getName());
            
            response.sendRedirect("CarsServlet");
        }
        else{
            response.sendRedirect("error.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
