package station3;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Part;

@WebServlet("/Station3/*")
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

    // /Station3/MIX/n
    // /Station3/LEG/n
    // /Station3/HALFBODY/n
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String packages = null;
		String url = request.getRequestURL().toString();
		
		int n = getN(url);
		String shop = getShop(request.getHeader("Authorization"));
		
		if (url.contains(Part.MIX))		
			packages = controller.getMixPackages(shop, n);
		else if (url.contains(Part.LEG))
			packages = controller.getPartPackages(shop, 'L', n);
		else if (url.contains(Part.HALFBODY))
			packages = controller.getPartPackages(shop, 'B', n);		
		OutputStream out = response.getOutputStream();
		out.write(packages.getBytes());
		out.flush();
	}

	// /Station3/partLabel
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		int poz = url.lastIndexOf('/') + 1;
		String label = url.substring(poz);
		controller.markAsContaminated(label);
	}
	
	// util
	private static int getN(String url) {
		int poz = url.lastIndexOf('/') + 1;
		String nString = url.substring(poz);
		return Integer.parseInt(nString);
	}
	
	private static String getShop(String header) {		
	    String credE = header.substring("Basic".length()).trim();
	    String credentials = new String(Base64.getDecoder().decode(credE),Charset.forName("UTF-8"));
	    return credentials.split(":",2)[1];
	}
}
