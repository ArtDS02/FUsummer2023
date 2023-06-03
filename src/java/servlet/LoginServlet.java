/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import dao.AccountDAO;
import model.Account;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        
//        AccountDAO accountDAO = new AccountDAO();
//        Account acc = accountDAO.getAccountByName(username, password);
//        if(acc == null){
//            request.setAttribute("error", "username or password incorrect");
//            request.getRequestDispatcher("login.jsp").forward(request, response);
//        }else{
//            HttpSession session = request.getSession();
//            session.setAttribute("acc", acc);
//            session.setMaxInactiveInterval(100);
//            response.sendRedirect("index.jsp");
//         
//        }
        

        AccountDAO acc = new AccountDAO();
        if (acc.getAccountByName(username).getUsername() != null) {
            if (acc.getAccountByName(username).getUsername().equals(username) && acc.getAccountByName(username).getPassword().equals(password)) {
                
                response.sendRedirect("index.jsp");
            } else {
                response.sendRedirect("login.jsp");
            }
        }else {
                response.sendRedirect("login.jsp");
            }
   

    }
}
