<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/taglib.jsp" %>

<script type="text/javascript">
    $(document).ready(function () {
        $('.nav-tabs a:first').tab('show');
        $('.triggerRemove').click(function (e) {
            e.preventDefault();
            $('#modalRemove .removeBtn').attr("href", $(this).attr("href"));
            $('#modalRemove').modal();
        });
    });
</script>
Users Dashboard
<br/><br/>
<table class="table table-bordered table-hover table-striped">
    <thead>
    <tr>
        <th>User Name</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>
                <a class="user" href="<spring:url value="/users/${user.id}.html"/>">
                    <c:out value="${user.name}" />
                </a>
                <a class="btn btn-danger btn-xs removeUser triggerRemove"
                   href="<spring:url value="/users/remove/${user.id}.html" />"><i class="fa fa-minus"></i></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myRemoveModalLabel">User Removing ...</h4>
            </div>
            <div class="modal-body">
                Do you really want to remove this user ?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                <a href="" class="btn btn-danger removeBtn"><i class="fa fa-remove"></i>&nbsp;Remove</a>
            </div>
        </div>
    </div>
</div>
