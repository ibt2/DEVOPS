package com.JAVA.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

import com.JAVA.Beans.Medecin;
import com.JAVA.Beans.Patient;
import com.JAVA.Beans.Plage_horaire;
import com.JAVA.Beans.RDV;
import com.JAVA.DAO.DAOConfigurationException;
import com.JAVA.DAO.DAOFactory;
import com.JAVA.DAO.MedecinDAO;
import com.JAVA.DAO.PatientDAO;
import com.JAVA.DAO.Plage_horaireDAO;
import com.JAVA.DAO.RDVDAO;

/**
 * Servlet implementation class RDV_servlet
 */
@WebServlet("/RDV_servlet")
public class RDV_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private String action;
	 private Plage_horaireDAO plagehoraireDAO;
	 private RDVDAO rdvdao;
	 private MedecinDAO medecinDAO;
	 private PatientDAO patientdao;
    /**
     * @see HttpServlet#HttpServlet()
     */
	 
	 @Override
	    public void init() throws ServletException {
	        try {
	            // Initialisation de DAOFactory et du DAO de specialite
	            DAOFactory daoFactory = DAOFactory.getInstance();
	            this.plagehoraireDAO = daoFactory.getPlage_horaireDao();
	            this.rdvdao = daoFactory.getRDVDao();
	            this.medecinDAO = daoFactory.getMedecinDao();
	            this.patientdao = daoFactory.getPatientDao();
	        } catch (DAOConfigurationException e) {
	            throw new ServletException(e);
	        }
	    }
	 
    public RDV_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		action = request.getParameter("action");
		
		if (action == null || action.equals("list_rdv") || action.equals("ajoutrdv")) {
			
			HttpSession session = request.getSession();
			int id_pat = (int) session.getAttribute("id_patient");
			
			ArrayList<RDV> liste_rdv = rdvdao.getAll_frompat(id_pat);
			ArrayList<Plage_horaire> liste_plagehoraire = plagehoraireDAO.getAll();
			ArrayList<Medecin> liste_med = medecinDAO.getAll();
			
			request.setAttribute("liste_rdv", liste_rdv);
			request.setAttribute("liste_plg", liste_plagehoraire);
			request.setAttribute("liste_med", liste_med);
			
			request.getRequestDispatcher("all_rdv.jsp").forward(request, response);
		}
		else if(action != null && action.equals("rdvMed1")) {
			
			ArrayList<Medecin> liste_med = medecinDAO.getAll();
			request.setAttribute("liste_med", liste_med);
			
			request.getRequestDispatcher("Liste_RDV.jsp").forward(request, response);
			
		}
		else if(action.equals("rdvMed2")) {
			
			int id_medcin = Integer.parseInt(request.getParameter("id_med"));
			ArrayList<RDV> liste_rdv = rdvdao.getAll_frommed(id_medcin);
			
			if(liste_rdv == null || liste_rdv.isEmpty()) {
				request.getRequestDispatcher("Liste_rdv_empty.jsp").forward(request, response);
			}
			else {
			ArrayList<Plage_horaire> liste_plagehoraire = plagehoraireDAO.getAll();
			ArrayList<Patient> liste_pat = patientdao.getAll();
			
			request.setAttribute("liste_rdv", liste_rdv);
			request.setAttribute("liste_plg", liste_plagehoraire);
			request.setAttribute("liste_pat", liste_pat);
			
			request.getRequestDispatcher("Liste_RDV_med.jsp").forward(request, response);
			}
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
