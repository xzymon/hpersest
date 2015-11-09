package com.xzymon.hpersest.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xzymon.hpersest.model.Store;
import com.xzymon.hpersest.util.AppConstants;


@WebServlet(name="TestServlet", urlPatterns="/test")
public class TestServlet extends HttpServlet {

	private static final long serialVersionUID = 4164864493531445023L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		
		PrintWriter out = resp.getWriter();
		out.println("<html><body><h2>Hello from TestServlet!</h2>");
		
		SessionFactory factory = (SessionFactory) req.getServletContext().getAttribute(AppConstants.HIBERNATE_SESSION_FACTORY_ATTR_NAME);
		Session session = factory.openSession();
		session.beginTransaction();
		List<Store> result = session.createQuery("from Store").list();
		if(result!=null){
			out.println("<table>");
			out.println("<tr><th>Id</th><th>Nazwa</th></tr>");
			for(Store store : result ){
				out.printf("<tr><td>%1$d</td><td>%2$s</td></tr>",store.getId(), store.getName());
			}
			out.println("</table>");
		}
		session.getTransaction().commit();
		session.close();
		out.println("</body></html>");
		
	}
}