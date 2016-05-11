package station1;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Station1/*")
public class Station1 extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Station1Controller controller;

	public Station1() {
		try {
			controller = new Station1Controller();
		} catch (RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}

	// /Station1/n
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("asd");
		String url = request.getRequestURL().toString();
		int i = url.lastIndexOf('/') + 1;
		controller.recievePigs(Integer.parseInt(url.substring(i)));
	}
}
