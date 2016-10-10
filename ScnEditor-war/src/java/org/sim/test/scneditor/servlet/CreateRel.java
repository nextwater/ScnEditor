/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sim.test.scneditor.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.sim.test.db.entity.RRel;
import org.sim.test.db.entity.XEvent;
import org.sim.test.db.facade.RRelFacade;
import org.sim.test.db.facade.XEventFacade;

/**
 *
 * @author g
 */
@WebServlet(name = "CreateRel", urlPatterns = {"/CreateRel"})
public class CreateRel extends HttpServlet {

    @EJB XEventFacade xFacade;
    @EJB RRelFacade rFacade;
    
    private int cid=0;
    private int sid=0;
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
        String aid = request.getParameter("agent");
        try (PrintWriter out = response.getWriter()) {
            if(aid==null){
                printForm(out);
            }
            else {
                cid = Integer.parseInt(request.getParameter("scenarioid"));
                sid = Integer.parseInt(request.getParameter("stepid"));
                String value = request.getParameter("value");
                String oid = request.getParameter("obj");
                String tid = request.getParameter("task");
                RRel rel = new RRel();
                rel.setValue(value);
                String id = aid+":"+(oid==null?tid:oid);
                id += ":"+String.valueOf(cid)+":"+String.valueOf(sid);
                rel.setRid(id);
                rFacade.create(rel);
                XEvent xevent = new XEvent();
                xevent.setRid(id);
                xevent.setScenarioid(cid);
                xevent.setStepid(sid);
                xFacade.create(xevent);
                response.sendRedirect("/ScnEditor-war/CreateRel");
            }
        }
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

    private void printForm(PrintWriter out) {
        out.print(
"<!DOCTYPE html>\n" +
"<!--\n" +
"To change this license header, choose License Headers in Project Properties.\n" +
"To change this template file, choose Tools | Templates\n" +
"and open the template in the editor.\n" +
"-->\n" +
"<html>\n" +
"    <head>\n" +
"        <title>TODO supply a title</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"    </head>\n" +
"    <body>\n" +
"        <form action=\"CreateRel\">\n" +
"            <table>\n" +
"                <thead>\n" +
"                    <tr>\n" +
"                        <th>ScenarioID</th>\n" +
"                        <th>StepID</th>\n" +
"                    </tr>\n" +
"                </thead>\n" +
"                <tbody>\n" +
"                    <tr>\n" +
"                        <td><input type=\"text\" name=\"scenarioid\" value=\"0\"/></td>\n" +
"                        <td><input type=\"text\" name=\"stepid\"/ value=\"0\"></td>\n" +
"                    </tr>\n" +
"                </tbody>\n" +
"            </table>\n" +
"            <table>\n" +
"                <thead>\n" +
"                    <tr>\n" +
"                        <th>Agents</th><th>Objs</th><th>Tasks</th>\n" +
"                    </tr>\n" +
"                </thead>\n" +
"                <tbody>\n" +
"                    <tr>\n" +
"                        <td><select name=\"agent\" size=5>");
        xFacade.findAgentsBySceneId(cid).stream().forEach((a)->{
            String s=a.split(":")[0];
            out.printf("<option>%s</option>",s);
        });
        out.print(
"                        </select></td>\n" +
"                        <td><select name=\"obj\" size=5>");
        xFacade.findObjsBySceneId(cid).stream().forEach((a)->{
            out.printf("<option>%s</option>", a.split(":")[0]);
        });
        out.print("</select></td>\n" +
"                        <td><select name=\"task\" size=5>");
        xFacade.findTasksBySceneId(cid).stream().forEach((a)->{
            out.printf("<option>%s</option>", a.split(":")[0]);
        });
        out.print("</select></td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <intpu type=\"text\" name=\"value\"/>\n" +
"                    </tr>\n" +
"                </tbody>\n" +
"            </table>\n" +
"\n" +
"            <input type=\"submit\" value=\"ok\">\n" +
"            \n" +
"        </form>\n" +
"    </body>\n" +
"</html>\n" +
"");
    }

}
