package com.JAVA.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.util.ArrayList;

import com.JAVA.DAO.SpecialiteDAO;
import com.JAVA.Beans.Specialite;
import com.JAVA.DAO.DAOConfigurationException;
import com.JAVA.DAO.DAOFactory;

/**
 * Servlet implementation class Spec_servlet
 */
@WebServlet("/Spec_servlet")
public class Spec_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String action;
	private SpecialiteDAO specialiteDao;
	
	
	@Override
    public void init() throws ServletException {
        try {
            // Initialisation de DAOFactory et du DAO de specialite
            DAOFactory daoFactory = DAOFactory.getInstance();
            this.specialiteDao = daoFactory.getSpecialiteDao();
        } catch (DAOConfigurationException e) {
            throw new ServletException(e);
        }
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Spec_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		action = request.getParameter("action");
		if(action == null || action.equals("list")) {
			
        ArrayList<Specialite> lst_spe = specialiteDao.getAll();
        
	
		request.setAttribute("liste_spe", lst_spe);
		
		request.getRequestDispatcher("all_specialite.jsp").forward(request, response);
		}
		else if(action.equals("list_spec")) {
			
			ArrayList<Specialite> lst_spe = specialiteDao.getAll();
	        
			
			request.setAttribute("liste_spe", lst_spe);
			
			request.getRequestDispatcher("all_specialite_admin.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		action = request.getParameter("action");
		
		if(action == null || action.equals("list")) {
			response.sendRedirect("Spec_servlet?action=list");
		}
		else if(action.equals("add_spec")) {
			String name_form = request.getParameter("nom_form");

			
			Specialite spec = new Specialite(0,name_form);
			specialiteDao.create(spec);
			response.sendRedirect("Spec_servlet?action=list");
		}
		else if(action.equals("form2")) {
			String name_form = request.getParameter("nom");

			
			Specialite spec = new Specialite(0,name_form);
			specialiteDao.create(spec);
			response.sendRedirect("Spec_servlet?action=list_spec");
		}
	}

}
