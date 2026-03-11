/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package auth.pck.myapp;

import java.io.IOException;
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
        HttpSession session = request.getSession(false);
        session.invalidate();
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("txtEmail");
        String pwd = request.getParameter("txtPwd");
        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
        }

        UsersDAO dao = new UsersDAO();
        User user = dao.getAuthLogin(email, pwd);

        if (user != null) {
            session = request.getSession();
            session.setAttribute("User", user);

            response.sendRedirect("CarsServlet");
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
