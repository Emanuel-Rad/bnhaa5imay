package station3;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Part;
import model.Package;
import util.JsonUtil;


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
    	controller = new Station3Controller();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Package> packages;
		String url = request.getRequestURL().toString();
		if (url.contains("half")) {
			int n = getN(url);
			System.out.println("requested " + n + " halves");
			packages = controller.getHalfPackages(n);
		}
		else {
			int n = getN(url);
			String type = getType(url);
			System.out.println("requested " + n + " " + type);
			packages = controller.getMixPackages(type, n);
		}
		OutputStream out = response.getOutputStream();
		JsonUtil.writePackages(out, (Collection<Package>) packages);
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
