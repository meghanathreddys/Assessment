package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import bussiness.BussinessLogic;

@WebServlet("/emxController")
public class EmxController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(EmxController.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain");
		try {
			resp.getWriter().write(BussinessLogic.getResponse(req.getQueryString()));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
}
