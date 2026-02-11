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
        CarsDAO dao = new CarsDAO();
        List<Car> list = dao.getAllCars();
        request.setAttribute("carList", list);
        request.getRequestDispatcher("cars.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {                
        
        String id = request.getParameter("carId");
        String brand = request.getParameter("txtBrand");
        String model = request.getParameter("txtModel");
        String cc = request.getParameter("txtCC");
        
        Car car = new Car();        
        car.setBrand(brand);
        car.setModel(model);
        car.setCC(cc);
        
        CarsDAO dao = new CarsDAO();
        if(id == null)
        {
            dao.insertCar(car);
        }
        else{
            car.setId(Integer.parseInt(id));
            //TO-DO update
        }
        
        response.sendRedirect("CarsServlet");        
    }

       @Override
    public String getServletInfo() {
        return "Short description";
    }
}
