<%-- 
    Document   : ResultDisplay
    Created on : 31 May, 2023, 10:09:36 PM
    Author     : Thinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:out value="${Score}" />
        <c:set var="score" value="${requestScope.Score}" />
        <h1>Ket qua la ${requestScope.Score}</h1>
    </body>
</html>
