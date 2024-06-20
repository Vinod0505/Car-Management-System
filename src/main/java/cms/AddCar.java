package cms;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@WebServlet("/addCar")
public class AddCar extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String carBrand = req.getParameter("carBrand");
		String carModel = req.getParameter("carModel");
		int carPrice = Integer.parseInt(req.getParameter("carPrice"));
		
		Car car = new Car();
		car.setCarBrand(carBrand);
		car.setCarModel(carModel);
		car.setCarPrice(carPrice);
		
		SessionFactory sf = new Configuration().configure().addAnnotatedClass(Car.class).buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(car);
		transaction.commit();
		session.close();
		
		resp.sendRedirect("index.jsp");
	}
}
