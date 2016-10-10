/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sim.test.scneditor.servlet;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.sim.test.db.entity.OPlat;
import org.sim.test.db.entity.XEvent;
import org.sim.test.db.facade.OPlatFacade;
import org.sim.test.db.facade.XEventFacade;

/**
 *
 * @author g
 */
@WebServlet(name = "CreateOPlat", urlPatterns = {"/CreateOPlat"})
public class CreateOPlat extends HttpServlet {

    @EJB OPlatFacade oFacade;
    @EJB XEventFacade xFacade;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String cid=request.getParameter("scenarioid");
        String sid=request.getParameter("stepid");
        String aid=request.getParameter("fqid");
        String fqtid=aid+":"+cid+":"+sid;
        String label=request.getParameter("label");
        OPlat a = new OPlat();
        a.setFqid(fqtid);
        a.setLabel(label);
        a.setX(Double.parseDouble(request.getParameter("x")));
        a.setY(Double.parseDouble(request.getParameter("y")));
        oFacade.create(a);
        XEvent e = new XEvent();
        e.setFqid(fqtid);
        e.setScenarioid(Integer.parseInt(cid));
        e.setStepid(Integer.parseInt(sid));
        xFacade.create(e);
        response.sendRedirect("#");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
