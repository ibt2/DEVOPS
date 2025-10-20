package com.JAVA.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

import com.JAVA.Beans.Disponibilite;
import com.JAVA.Beans.Medecin;
import com.JAVA.Beans.Plage_horaire;
import com.JAVA.Beans.RDV;
import com.JAVA.DAO.DAOConfigurationException;
import com.JAVA.DAO.DAOFactory;
import com.JAVA.DAO.DisponibiliteDAO;
import com.JAVA.DAO.MedecinDAO;
import com.JAVA.DAO.Plage_horaireDAO;
import com.JAVA.DAO.RDVDAO;
import com.JAVA.DAO.SpecialiteDAO;

/**
 * Servlet implementation class Disp_servlet
 */
@WebServlet("/Disp_servlet")
public class Disp_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String action;
	private SpecialiteDAO specialiteDao;
	private DisponibiliteDAO disponibiliteDAO;
	private MedecinDAO medecinDAO;
	private Plage_horaireDAO plagehoraireDAO;
	private RDVDAO rdvdao;
	
	@Override
    public void init() throws ServletException {
        try {
            // Initialisation de DAOFactory et du DAO de specialite
            DAOFactory daoFactory = DAOFactory.getInstance();
            this.specialiteDao = daoFactory.getSpecialiteDao();
            this.disponibiliteDAO = daoFactory.getDisponibiliteDao();
            this.medecinDAO = daoFactory.getMedecinDao();
            this.plagehoraireDAO = daoFactory.getPlage_horaireDao();
            this.rdvdao = daoFactory.getRDVDao();
        } catch (DAOConfigurationException e) {
            throw new ServletException(e);
        }
    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Disp_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		action = request.getParameter("action");
		
		if(action != null & action.equals("list_disp")) {
			
		String id_spec_string = request.getParameter("id_spec");
		int id_spec = Integer.parseInt(id_spec_string);
		
		ArrayList<Medecin> liste_medecin = new ArrayList<>(); 
		ArrayList<Disponibilite> liste_disponibilite = new ArrayList<>();
		ArrayList<Plage_horaire> liste_plagehoraire = new ArrayList<>();
		
		liste_medecin = medecinDAO.getAll_Spec(id_spec);
		
		for(Medecin medec : liste_medecin) {
			liste_disponibilite.addAll(disponibiliteDAO.getAll_fromMed(medec.getId()));
		}
		
		liste_plagehoraire = plagehoraireDAO.getAll();
		
		request.setAttribute("lst_med", liste_medecin);
		request.setAttribute("lst_disp", liste_disponibilite);
		request.setAttribute("lst_plg", liste_plagehoraire);
		
		request.getRequestDispatcher("all_disp.jsp").forward(request, response);
		
		}
		
		else if(action.equals("ajoutrdv")) {
			
			String id_med_string = request.getParameter("id_med");
			int id_med = Integer.parseInt(id_med_string);
			
			HttpSession session = request.getSession();
			int id_pat = (int) session.getAttribute("id_patient");
			
			String jour = request.getParameter("jour");
			
			String id_plg_string = request.getParameter("id_plg");
			int id_plg = Integer.parseInt(id_plg_string);
			
			RDV rdv = new RDV(id_med,id_pat,jour,id_plg);
			rdvdao.create(rdv);
			
			String id_dispo_string = request.getParameter("id_dispo");
			int id_dispo = Integer.parseInt(id_dispo_string);
			
			disponibiliteDAO.modif_disp(id_dispo);
			request.getRequestDispatcher("Success.jsp").forward(request, response);
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
