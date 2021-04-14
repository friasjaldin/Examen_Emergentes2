/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.controlador;
import com.emergentes.modelo.GestorVacunas;
import com.emergentes.modelo.Vacunados;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(name = "Principal", urlPatterns = {"/Principal"})
/**
 *
 * @author CristhianFriasJaldin
 */
public class Principal extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
       Vacunados objAlmacena=new Vacunados();
       int id;
       int pos;
       String op = request.getParameter("op");
       
       if(op.equals("nuevo")){
           HttpSession ses=request.getSession();
           GestorVacunas agenda= (GestorVacunas) ses.getAttribute("agenda");
           objAlmacena.setId(agenda.obtieneId());
           request.setAttribute("op", op);
           request.setAttribute("almacena",objAlmacena);
           request.getRequestDispatcher("editar.jsp").forward(request, response);
       }
       if(op.equals("modificar")){
           id=Integer.parseInt(request.getParameter("id"));
           HttpSession ses = request.getSession();
           GestorVacunas agenda=(GestorVacunas) ses.getAttribute("agenda");
           pos=agenda.ubicarVacunado(id);
           objAlmacena=agenda.getLista().get(pos);
           request.setAttribute("op", op);
           request.setAttribute("almacena",objAlmacena);
           request.getRequestDispatcher("editar.jsp").forward(request, response);;
       }
       if(op.equals("eliminar")){
           id=Integer.parseInt(request.getParameter("id"));
           HttpSession ses = request.getSession();
           GestorVacunas agenda=(GestorVacunas) ses.getAttribute("agenda");
           pos= agenda.ubicarVacunado(id);
           agenda.eliminarVacunado(pos);
           ses.setAttribute("agenda", agenda);
           response.sendRedirect("index.jsp");
       }
}
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       Vacunados objAlmacena = new Vacunados();
       int pos;
       String op=request.getParameter("op");
       if(op.equals("grabar")){
           objAlmacena.setId(Integer.parseInt(request.getParameter("id")));
           objAlmacena.setNombre(request.getParameter("nombre"));
           objAlmacena.setPeso(request.getParameter("peso"));
           objAlmacena.setTalla(request.getParameter("talla"));
           objAlmacena.setVacuna(request.getParameter("vacuna"));
           HttpSession ses = request.getSession();
           GestorVacunas agenda=(GestorVacunas) ses.getAttribute("agenda");
           String opg=request.getParameter("opg");
           if(opg.equals("nuevo")){
               agenda.insertVacunado(objAlmacena);
           }else{
               pos=agenda.ubicarVacunado(objAlmacena.getId());
               agenda.modificarVacunado(pos, objAlmacena);
           }
           ses.setAttribute("agenda", agenda);
           response.sendRedirect("index.jsp");
       }
    }
}
