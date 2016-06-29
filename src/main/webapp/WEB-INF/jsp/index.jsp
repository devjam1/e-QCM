<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/taglib.jsp" %>
<jsp:useBean id="d" class="java.util.Date"/>
<div class="page-header">
    <span class="badge"><fmt:formatDate value="${d}" pattern="EEEE dd MMM,yyyy HH:mm:ss" dateStyle="long" timeStyle="long"/></span>
</div>
