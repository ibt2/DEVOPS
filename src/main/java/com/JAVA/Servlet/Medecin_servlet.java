package com.JAVA.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import com.JAVA.Beans.Medecin;
import com.JAVA.Beans.Specialite;
import com.JAVA.DAO.DAOConfigurationException;
import com.JAVA.DAO.DAOFactory;
import com.JAVA.DAO.MedecinDAO;
import com.JAVA.DAO.SpecialiteDAO;

/**
 * Servlet implementation class Medecin_servlet
 */
@WebServlet("/Medecin_servlet")
public class Medecin_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String action;
    private MedecinDAO medecinDAO;
    private SpecialiteDAO specialiteDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    
    @Override
    public void init() throws ServletException {
        try {
            // Initialisation de DAOFactory et du DAO de specialite
            DAOFactory daoFactory = DAOFactory.getInstance();
            this.medecinDAO = daoFactory.getMedecinDao();
            this.specialiteDao = daoFactory.getSpecialiteDao();
        } catch (DAOConfigurationException e) {
            throw new ServletException(e);
        }
    }
    
    public Medecin_servlet() {
        
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		action = request.getParameter("action");
		
		if(action == null || action.equals("list_med")) {
			
			ArrayList<Medecin> liste_med = medecinDAO.getAll();
			ArrayList<Specialite> liste_spec = specialiteDao.getAll();
			
			request.setAttribute("liste_med", liste_med);
			request.setAttribute("liste_spec", liste_spec);
			
			request.getRequestDispatcher("All_medecin.jsp").forward(request, response);
			
		}
		else if(action.equals("form1")){
			
			ArrayList<Specialite> liste_spec = specialiteDao.getAll();
			
			request.setAttribute("liste_spec", liste_spec);
			
			request.getRequestDispatcher("form_addmed.jsp").forward(request, response);
			
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    action = request.getParameter("action");

	    if (action != null) {
	        if (action.equals("form2")) {
	            String nom = request.getParameter("nom");
	            String prenom = request.getParameter("prenom");
	            int tel = Integer.parseInt(request.getParameter("tel"));
	            int id_sp = Integer.parseInt(request.getParameter("id_spec"));

	            medecinDAO.create(new Medecin(0, nom, prenom, tel, id_sp));

	            response.sendRedirect("Medecin_servlet?action=list_med");
	        } else if (action.equals("delete")) {
	            int id = Integer.parseInt(request.getParameter("id"));
	            medecinDAO.delete(id);
	            response.sendRedirect("Medecin_servlet?action=list_med");
	        }
	    }
	}

		
}
