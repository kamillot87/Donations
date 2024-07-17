<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Document</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
    <script src="/resources/js/app.js"></script>
</head>
<body>
<header class="header--main-page">
    <nav class="container container--70">
        <ul class="nav--actions">
            <c:if test="${pageContext.request.userPrincipal != null}">

                <li class="logged-user">
                    Witaj ${userData.name}
                    <ul class="dropdown">
                        <li><a href="#">Profil</a></li>
                        <li><a href="#">Moje zbiórki</a></li>
                        <li><a href="/logout" class="btn btn--small btn--without-border">Wyloguj</a></li>

                    </ul>
                </li>
            </c:if>
            <c:if test="${pageContext.request.userPrincipal == null}">
                <li><a href="/login" class="btn btn--small btn--without-border">Zaloguj</a></li>
                <li><a href="/register" class="btn btn--small btn--highlighted">Załóż konto</a></li>
            </c:if>
        </ul>

        <ul>
            <li><a href="/" class="btn btn--without-border active">Start</a></li>
            <li><a href="#stepss" class="btn btn--without-border">O co chodzi?</a></li>
            <li><a href="#about" class="btn btn--without-border">O nas</a></li>
            <li><a href="#helpss" class="btn btn--without-border">Fundacje i organizacje</a></li>
            <li><a href="#contacs" class="btn btn--without-border">Kontakt</a></li>
        </ul>
    </nav>