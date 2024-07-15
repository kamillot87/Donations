<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="Common/Header.jsp"/>
</header>

<section class="login-page">
    <h2>Załóż konto</h2>
    <form:form method="post" action="/register" modelAttribute="user" onsubmit="return passwordValidate()" >

        <div class="form-group">
            <form:input type="text" path="name" placeholder="Name" />
        </div>
        <div class="form-group">
            <form:input type="text" path="lastName" placeholder="Lastname" />
        </div>
        <div class="form-group">
            <form:input type="email" path="email" placeholder="Email" />
        </div>
        <div class="form-group">
            <form:input type="password" id="pass1" path="password" placeholder="Hasło" />
        </div>
        <div class="form-group">
            <input type="password" id="pass2" name="password2" placeholder="Powtórz hasło" />
        </div>

        <div class="form-group form-group--buttons">
            <a href="/" class="btn btn--without-border">Zaloguj się</a>
            <button class="btn" type="submit">Załóż konto</button>
        </div>
    </form:form>
</section>
<script>

    function passwordValidate () {
        var pass1 = document.getElementById("pass1").value;
        var pass2 = document.getElementById("pass2").value;

        if (pass1 !== pass2) {
            alert ("Passwords are different. Please write correct password and repeat it");
            return false
        }
        return true;
    }
</script>

<jsp:include page="Common/Footer.jsp"/>
