<%-- 
    Document   : ExamDisplay
    Created on : 30 May, 2023, 7:59:02 PM
    Author     : Thinh
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="a" class="dao.QuestionDAO" scope="request"></jsp:useBean>
            <link href="css/styleExam.css" rel="stylesheet">
            <title>Exam</title>
        </head>
        <body>

        <c:set var="CollectionID" value="1"></c:set>
            <form action="CalculateResult" method="post">
                <input style="display: none"  type="text" id="GetCollectionID" name="GetCollectionID" value="${CollectionID}">
            <h1>Bo de : ${CollectionID}</h1>
            <c:forEach items="${a.getListQuestionsByID(CollectionID)}" var="b" begin="0" end="8">
                <% boolean test = true; %>
                <div class="question">  
                    <p>Câu ${b.getQuestionID()}:${b.getDetail()}</p>
                </div>
                <div class="answers">
                    <c:if test="${!requestScope.hashMap.containsKey(b.getQuestionID())}">
                        <input type="radio" id="A${b.getQuestionID()}" name="${b.getQuestionID()}" value="A">${b.getAnswerA()}<br>
                        <input type="radio" id="B${b.getQuestionID()}" name="${b.getQuestionID()}" value="B">${b.getAnswerB()}<br>
                        <input type="radio" id="C${b.getQuestionID()}" name="${b.getQuestionID()}" value="C">${b.getAnswerC()}<br>
                        <input type="radio" id="D${b.getQuestionID()}" name="${b.getQuestionID()}" value="D">${b.getAnswerD()}<br>
                    </c:if>
                    <c:if test="${requestScope.hashMap.containsKey(b.getQuestionID())}">
                        <c:choose>
                            <c:when test="${requestScope.hashMap.containsValue('A')}">
                                <span style="color: Red; font-weight: bold;"><input type="radio" id="A${b.getQuestionID()}" name="${b.getQuestionID()}" value="A" checked>${b.getAnswerA()}</span><br>
                                <input type="radio" id="B${b.getQuestionID()}" name="${b.getQuestionID()}" value="B">${b.getAnswerB()}<br>
                                <input type="radio" id="C${b.getQuestionID()}" name="${b.getQuestionID()}" value="C">${b.getAnswerC()}<br>
                                <input type="radio" id="D${b.getQuestionID()}" name="${b.getQuestionID()}" value="D">${b.getAnswerD()}<br>
                            </c:when>
                            <c:when test="${requestScope.hashMap.containsValue('B')}">
                                <input type="radio" id="A${b.getQuestionID()}" name="${b.getQuestionID()}" value="A">${b.getAnswerA()}<br>
                                <span style="color: Red; font-weight: bold;"><input type="radio" id="B${b.getQuestionID()}" name="${b.getQuestionID()}" value="B" checked>${b.getAnswerB()}</span><br>
                                <input type="radio" id="C${b.getQuestionID()}" name="${b.getQuestionID()}" value="C">${b.getAnswerC()}<br>
                                <input type="radio" id="D${b.getQuestionID()}" name="${b.getQuestionID()}" value="D">${b.getAnswerD()}<br>
                            </c:when>
                            <c:when test="${requestScope.hashMap.containsValue('C')}">
                                <input type="radio" id="A${b.getQuestionID()}" name="${b.getQuestionID()}" value="A">${b.getAnswerA()}<br>
                                <input type="radio" id="B${b.getQuestionID()}" name="${b.getQuestionID()}" value="B">${b.getAnswerB()}<br>
                                <span style="color: Red; font-weight: bold;"><input type="radio" id="C${b.getQuestionID()}" name="${b.getQuestionID()}" value="C" checked>${b.getAnswerC()}</span><br>
                                <input type="radio" id="D${b.getQuestionID()}" name="${b.getQuestionID()}" value="D">${b.getAnswerD()}<br>
                            </c:when>
                            <c:otherwise>
                                <input type="radio" id="A${b.getQuestionID()}" name="${b.getQuestionID()}" value="A">${b.getAnswerA()}<br>
                                <input type="radio" id="B${b.getQuestionID()}" name="${b.getQuestionID()}" value="B">${b.getAnswerB()}<br>
                                <input type="radio" id="C${b.getQuestionID()}" name="${b.getQuestionID()}" value="C">${b.getAnswerC()}<br>
                                <span style="color: Red; font-weight: bold;"><input type="radio" id="D${b.getQuestionID()}" name="${b.getQuestionID()}" value="D" checked>${b.getAnswerD()}</span><br>
                                </c:otherwise>
                            </c:choose>
                        </c:if>
                </div>
            </c:forEach>
            <button class="submit-btn" type="submit">Gửi</button>
        </form>
    </body>
</html>
