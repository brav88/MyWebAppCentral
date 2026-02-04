/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package cars.pck.myapp;

import database.pck.myapp.Database;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Personal
 */
public class getCarsServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Database mydb = new Database();

        ResultSet rs = mydb.GetQuery("SELECT * FROM Cars;");

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet getCarsServlet</title>");
            out.println("<style>table, th, td {border: 1px solid black;border-collapse: collapse;}</style>");            
            out.println("</head>");
            out.println("<body>");
            out.println(" <table>");
            out.println("   <tr>");
            out.println("     <th>Brand</th>");
            out.println("     <th>Model</th>");
            out.println("     <th>Cubic Capacity</th>");
            out.println("   </tr>");
            while (rs.next()) {
                out.println("   <tr>");
                out.println("     <td>" + rs.getString("brand") + "</td>");
                out.println("     <td>" + rs.getString("model") + "</td>");
                out.println("     <td>" + rs.getString("cubicCapacity") + "</td>");
                out.println("   </tr>");
            }
            out.println(" <table>");
            out.println("</body>");
            out.println("</html>");
        } catch (SQLException ex) {
            System.getLogger(getCarsServlet.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
