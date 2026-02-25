/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package cars.pck.myapp;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.pck.myapp.Car;

/**
 *
 * @author Personal
 */
public class CarsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        CarsDAO dao = new CarsDAO();

        if (action == null) {
            request.setAttribute("carList", dao.getAllCars());
            request.getRequestDispatcher("cars.jsp").forward(request, response);
        } else if (action.equals("Edit")) {
            request.setAttribute("Car", dao.getCarById(Integer.parseInt(request.getParameter("carId"))));
            request.getRequestDispatcher("CatalogServlet?path=cars-form.jsp").forward(request, response);
        } else if (action.equals("Delete")) {
            dao.deleteCar(Integer.parseInt(request.getParameter("carId")));
            response.sendRedirect("CarsServlet");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("txtCarId");

        Car car = new Car();
        car.setBrand(request.getParameter("txtBrand"));
        car.setModel(request.getParameter("txtModel"));
        car.setCarType(Integer.parseInt(request.getParameter("selCarType")));
        car.setFuelType(Integer.parseInt(request.getParameter("selFuelType")));
        car.setTransmission(Integer.parseInt(request.getParameter("selTransmission")));
        car.setCC(request.getParameter("txtCC"));

        CarsDAO dao = new CarsDAO();
        if (id.equals("")) {
            dao.insertCar(car);
        } else {
            car.setId(Integer.parseInt(id));
            dao.updateCar(car);
        }

        response.sendRedirect("CarsServlet");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
