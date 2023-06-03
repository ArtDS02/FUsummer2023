/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import dao.QuestionDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import model.Question;

/**
 *
 * @author Thinh
 */
@WebServlet(name = "CalculateResult", urlPatterns = {"/CalculateResult"})
public class CalculateResult extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String CollectionID = request.getParameter("GetCollectionID");
        QuestionDAO q = new QuestionDAO();
        int count = 0;
        String check="";
        HashMap<Integer, String> hashMap = new HashMap<>();
        ArrayList<Question> QuestionList = q.getListQuestionsByID(CollectionID);
        for (int i = 0; i < QuestionList.size(); i++){
            String choose = request.getParameter(String.valueOf(QuestionList.get(i).getQuestionID()));
            if (QuestionList.get(i).getTrueAnswer().equals(choose)){
                count+=1;
            }
            else {
                hashMap.put(QuestionList.get(i).getQuestionID(), choose);
            }
            check=check+choose;
        }
        request.setAttribute("Score", count);
        request.setAttribute("hashMap", hashMap);
        request.getRequestDispatcher("ExamDisplay.jsp").forward(request, response);
    }
}
