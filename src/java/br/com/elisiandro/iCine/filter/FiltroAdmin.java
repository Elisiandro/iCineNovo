/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.elisiandro.iCine.filter;

import br.com.elisiandro.iCine.bean.UsuarioMB;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Elisiandro
 */
//@WebFilter(filterName = "FiltroAdmin", urlPatterns = {"/faces/usuario.xhtml"})
public class FiltroAdmin{ //implements Filter {

//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response,
//            FilterChain chain)
//            throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest) request;
//        HttpServletResponse resp = (HttpServletResponse) response;
//
//        UsuarioMB usuarioMB = (UsuarioMB) req.getSession().getAttribute("usuarioMB");
//        if (usuarioMB != null && usuarioMB.estaLogado()) {
//            //encaminha para o recurso
//            chain.doFilter(request, response);
//        } else {
//            //redireciona para pagina de login
//            resp.sendRedirect(req.getContextPath() + "/faces/login.xhtml");
//        }
//
//    }
//
//    @Override
//    public void destroy() {
//    }
//
//    @Override
//    public void init(FilterConfig filterConfig) {
//    }

}
