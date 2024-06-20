package cms;

import java.io.IOException;
import java.util.List;

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
import org.hibernate.query.Query;

@WebServlet("/displayCars")
public class DisplayAllCars extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		SessionFactory sf = new Configuration().configure().addAnnotatedClass(Car.class).buildSessionFactory();
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();

		Query<Car> query = session.createQuery("from Car");
		List<Car> cars = query.list();

		req.setAttribute("carList", cars);
		RequestDispatcher dispatcher = req.getRequestDispatcher("displayAllCars.jsp");
		dispatcher.forward(req, resp);

		trans.commit();
		session.close();


	}
}
