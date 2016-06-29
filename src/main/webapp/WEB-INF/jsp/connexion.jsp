<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="../layout/taglib.jsp" %>


<form class="form-signin" role="form" action="<spring:url value="/login" />" method="POST">
    <h2 class="form-signin-heading">Connectez vous</h2>

    <div class="input-group namegroup">
        <span class="input-group-addon"><i class="fa fa-user fa-fw"></i></span>
        <input type="text" name="username" class="form-control" placeholder="Nom d'Utilisateur" required autofocus>
    </div>
    <div class="input-group passgroup">
        <span class="input-group-addon"><i class="fa fa-unlock-alt fa-fw"></i></span>
        <input type="password" name="password" class="form-control" placeholder="Mot de passe" required>
    </div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Se connecter</button>
    <c:if test="${param.error ne null}">
        <div class="alert alert-warning" role="alert">
            <i class="fa fa-warning"></i>&nbsp;<Strong>Erreur !</Strong>
            Nom d'utilisateur ou mot de passe incorrecte.
        </div>
    </c:if>
</form>
