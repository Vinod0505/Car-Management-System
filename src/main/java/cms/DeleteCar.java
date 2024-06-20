package cms;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@WebServlet("/deleteCar")
public class DeleteCar extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		int carId = Integer.parseInt(req.getParameter("carId"));
		
		SessionFactory sf = new Configuration().configure().addAnnotatedClass(Car.class).buildSessionFactory();
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		
		Car car = session.get(Car.class, carId);

		session.delete(car);
		
		trans.commit();
		session.close();

		req.setAttribute("dcar", car);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("displayAllCars.jsp");
		requestDispatcher.forward(req, resp);
	}
}
