package station3;
import java.io.IOException;
import java.io.OutputStream;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Part;

@WebServlet("/Station3/*")
/* GET
 * - /Station3/half/n
 * - /Station3/parttype/n
 *
 * POST (contaminated part)
 * - /Station3/partlabel
*/
public class Station3 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private Station3Controller controller;
	
    public Station3() {
    	try {
			controller = new Station3Controller();
		} catch (RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String packages;
		String url = request.getRequestURL().toString();
		int n = getN(url);
		if (url.contains("half"))		
			packages = controller.getHalfPackages(n);
		else {
			String type = getType(url);
			packages = controller.getPartPackages(type, n);
		}
		OutputStream out = response.getOutputStream();
		out.write(packages.getBytes());
		out.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		int poz = url.lastIndexOf('/') + 1;
		String label = url.substring(poz);
		controller.markAsContaminated(label);
	}
	
	private static int getN(String url) {
		int poz = url.lastIndexOf('/') + 1;
		String nString = url.substring(poz);
		return Integer.parseInt(nString);
	}
	
	private static String getType(String url) {
		if (url.contains(Part.LEG))
			return Part.LEG;
		return Part.HALFBODY;
	}
}
