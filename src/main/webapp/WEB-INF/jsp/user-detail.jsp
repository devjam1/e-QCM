<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/taglib.jsp" %>

<h1><c:out value="${user.name}"/></h1>

<script type="text/javascript">
    $(document).ready(function () {
        $('.nav-tabs a:first').tab('show');
        $('.triggerRemove').click(function (e) {
            e.preventDefault();
            $('#modalRemove .removeBtn').attr("href", $(this).attr("href"));
            $('#modalRemove').modal();
        });
        $('.blogForm').validate({
            rules: {
                name : {
                    required : true,
                    minlength : 3
                },
                url : {
                    required : true,
                    url:true
                }
            },
            highlight: function (element) {
                $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
            },
            unhighlight: function (element) {
                $(element).closest('.form-group').removeClass('has-error').addClass('has-success');
            }
        })
    });
</script>

<div>
    <ul class="nav nav-tabs" role="tablist">
        <c:forEach items="${user.blogs}" var="blog">
            <li role="presentation">
                <a href="#blog_${blog.id}" aria-controls="blog_${blog.id}" role="tab" data-toggle="tab">
                    <c:out value="${blog.name}"/>
                </a>
            </li>
        </c:forEach>
    </ul>
    <div class="tab-content">
        <c:forEach items="${user.blogs}" var="blog">
            <div role="tabpanel" class="tab-pane fade" id="blog_${blog.id}">
                <h1><c:out value="${blog.name}"/></h1>
                <p><c:out value="${blog.url}"/></p>
                <a href="<spring:url value='/blog/remove/${blog.id}.html'/>"
                   class="btn btn-danger btn-sm triggerRemove">
                    <i class="fa fa-minus"></i>
                    &nbsp;Remove Blog</a>
                <br>
                <br>
                <table class="table table-bordered table-hover table-striped">
                    <thead>
                    <tr>
                        <th>Date</th>
                        <th>Item</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${blog.items}" var="item">
                        <tr>
                            <td><fmt:formatDate value="${item.publishedDate}" pattern="dd/MM/yyyy HH:mm:ss" /></td>
                            <td>
                                <dl>
                                    <dt><a href="<c:out value="${item.link}"/>" target="_blank">${item.title}</a></dt>
                                    <dd>${item.description}</dd>
                                </dl>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:forEach>
    </div>

</div>

<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myRemoveModalLabel">Blog Removing ...</h4>
            </div>
            <div class="modal-body">
                Do you really want to remove this blog ?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                <a href="" class="btn btn-danger removeBtn">
                    <i class="fa fa-remove"></i>
                    &nbsp;Remove</a>
            </div>
        </div>
    </div>
</div>
