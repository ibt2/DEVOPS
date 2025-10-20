package com.JAVA.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.JAVA.Beans.Medecin;
import com.JAVA.Beans.Specialite;
import com.JAVA.DAO.DAOConfigurationException;
import com.JAVA.DAO.DAOFactory;
import com.JAVA.DAO.MedecinDAO;
import com.JAVA.DAO.PatientDAO;
import com.JAVA.DAO.SpecialiteDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PatientDAO patientdao;
    private String action;
    private MedecinDAO medecinDAO;
    private SpecialiteDAO specialiteDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }


	@Override
    public void init() throws ServletException {
        try {
            // Initialisation de DAOFactory et du DAO de specialite
            DAOFactory daoFactory = DAOFactory.getInstance();
            this.patientdao = daoFactory.getPatientDao();
            this.medecinDAO = daoFactory.getMedecinDao();
            this.specialiteDao = daoFactory.getSpecialiteDao();
            
        } catch (DAOConfigurationException e) {
            throw new ServletException(e);
        }
    }
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		action = request.getParameter("action");
		if(action != null && action.equals("accueil")) {
			
			Map<Integer, Integer> medData = medecinDAO.getStat();
			
			ArrayList<Specialite> liste_spec = specialiteDao.getAll();
			
			Map<String, Integer> datamed = new HashMap<>();;
			
			for (Map.Entry<Integer, Integer> entry : medData.entrySet()) {
				Integer key = entry.getKey();
				Integer value = entry.getValue();
				
				for(Specialite spec : liste_spec) {
					if (spec.getId() == key) {
						datamed.put(spec.getNom(), value);
					}
				}
			}
			
			int tailleDatamed = datamed.size();
			request.setAttribute("tailleDatamed", tailleDatamed);
			
			request.setAttribute("datamed", datamed);
			request.getRequestDispatcher("Accueil.jsp").forward(request, response);
		}
		else if(action == null || action.equals("Accueil_admin")) {
			
			Map<Integer, Integer> medData = medecinDAO.getStat();
			
			ArrayList<Specialite> liste_spec = specialiteDao.getAll();
			
			Map<String, Integer> datamed = new HashMap<>();;
			
			for (Map.Entry<Integer, Integer> entry : medData.entrySet()) {
				Integer key = entry.getKey();
				Integer value = entry.getValue();
				
				for(Specialite spec : liste_spec) {
					if (spec.getId() == key) {
						datamed.put(spec.getNom(), value);
					}
				}
			}
			
			int tailleDatamed = datamed.size();
			request.setAttribute("tailleDatamed", tailleDatamed);
			
			request.setAttribute("datamed", datamed);
			request.getRequestDispatcher("Accueil_admin.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		action = request.getParameter("action");
		if(action == null) {
			
		String id_patient_string = request.getParameter("id_patient");
		int id_patient = Integer.parseInt(id_patient_string);
		
		String password = request.getParameter("password");
		
		if(id_patient == 0 && password.equals("adminpassword")) {
			
			Map<Integer, Integer> medData = medecinDAO.getStat();
			
			ArrayList<Specialite> liste_spec = specialiteDao.getAll();
			
			Map<String, Integer> datamed = new HashMap<>();;
			
			for (Map.Entry<Integer, Integer> entry : medData.entrySet()) {
				Integer key = entry.getKey();
				Integer value = entry.getValue();
				
				for(Specialite spec : liste_spec) {
					if (spec.getId() == key) {
						datamed.put(spec.getNom(), value);
					}
				}
			}
			
			int tailleDatamed = datamed.size();
			request.setAttribute("tailleDatamed", tailleDatamed);
			
			request.setAttribute("datamed", datamed);
			request.getRequestDispatcher("Accueil_admin.jsp").forward(request, response);
			
		}
		else {
		
		boolean bool = patientdao.auth(id_patient, password);
		
		if(bool) {
			
			HttpSession session = request.getSession();
			session.setAttribute("id_patient", id_patient);
			
			Map<Integer, Integer> medData = medecinDAO.getStat();
			
			ArrayList<Specialite> liste_spec = specialiteDao.getAll();
			
			Map<String, Integer> datamed = new HashMap<>();;
			
			for (Map.Entry<Integer, Integer> entry : medData.entrySet()) {
				Integer key = entry.getKey();
				Integer value = entry.getValue();
				
				for(Specialite spec : liste_spec) {
					if (spec.getId() == key) {
						datamed.put(spec.getNom(), value);
					}
				}
			}
			
			int tailleDatamed = datamed.size();
			request.setAttribute("tailleDatamed", tailleDatamed);
			
			request.setAttribute("datamed", datamed);
			request.getRequestDispatcher("Accueil.jsp").forward(request, response);
		}
		else {
			request.setAttribute("bool", bool);
			request.getRequestDispatcher("Authentif.jsp").forward(request, response);
		}
		}
		}
		
		doGet(request, response);
	}

}
