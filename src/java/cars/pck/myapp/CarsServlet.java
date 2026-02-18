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
import java.util.List;
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
            List<Car> list = dao.getAllCars();
            request.setAttribute("carList", list);
            request.getRequestDispatcher("cars.jsp").forward(request, response);
        }
        if(action.equals("Edit")){
            String carId = request.getParameter("carId");
            Car car = dao.getCarById(Integer.parseInt(carId));
            request.setAttribute("Car", car);
            request.getRequestDispatcher("cars-form.jsp").forward(request, response);
        } 
        if(action.equals("Delete")){
            String carId = request.getParameter("carId");
            dao.deleteCar(Integer.parseInt(carId));           
            response.sendRedirect("CarsServlet");
        } 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("txtCarId");
        String brand = request.getParameter("txtBrand");
        String model = request.getParameter("txtModel");
        String cc = request.getParameter("txtCC");

        Car car = new Car();
        car.setBrand(brand);
        car.setModel(model);
        car.setCC(cc);

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
