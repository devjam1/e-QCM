<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@include file="taglib.jsp" %>
<html>
<head>

    <link rel="icon" href="/img/favicon.png" type="image/png">

    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/font-awesome.min.css">
    <link rel="stylesheet" href="/css/style.css">

    <script src="/js/jquery.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/jquery.validate.min.js"></script>

    <title><tiles:getAsString name="title"/></title>
</head>
<body>
<tilesx:useAttribute name="current"/>

<!-- Static navbar -->
<nav class="navbar navbar-default navbar-static-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand grayscale ${current == 'index' ? 'active' : ''}" href='<spring:url value="/"/>'>
                <img src="../../img/icon.png" alt="logo" class="pull-left"/>
                <span><Strong>e-QCM</Strong></span>
            </a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <security:authorize access="hasRole('ROLE_ADMIN')">
                    <li class="${current == 'users' ? 'active' : ''}"><a href="<spring:url value="/users.html"/>">
                        <i class="fa fa-users fa-fw"></i>&nbsp;Users</a></li>
                </security:authorize>
                <security:authorize access="isAuthenticated()">
                    <li class="${current == 'account' ? 'active' : ''}"><a href="<spring:url value="/account.html"/>">
                        <span class="glyphicon glyphicon-briefcase" aria-hidden="true"></span>&nbsp;Account Details</a>
                    </li>
                </security:authorize>
            </ul>
            <ul class="nav navbar-nav navbar-right">

                <security:authorize access="!isAuthenticated()">
                    <li class="${current == 'register' ? 'active' : ''}">
                        <a href="<spring:url value="/inscription.html"/>">
                            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                            S'enregister
                        </a>
                    </li>
                </security:authorize>
                <security:authorize access="!isAuthenticated()">
                    <li class="${current == 'login' ? 'active' : ''}">
                        <a href="<spring:url value="/connexion.html"/>">
                            <span class="glyphicon glyphicon-log-in" aria-hidden="true"></span>
                            Connexion
                        </a>
                    </li>
                </security:authorize>

                <security:authorize access="isAuthenticated()">
                        <form class="navbar-form navbar-right" method="post" action="<spring:url value="/logout"/>">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            <button class="btn logout" type="submit">
                                <span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
                                Deconnexion
                            </button>
                        </form>
                </security:authorize>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <tiles:insertAttribute name="body"/>
</div>
<footer>
    <center class="footer">
        <tiles:insertAttribute name="footer"/>
    </center>
</footer>
</body>
</html>
