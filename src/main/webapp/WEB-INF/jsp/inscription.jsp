<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/taglib.jsp" %>

<div class="alert alert-info">
    <i class="fa fa-info-circle"></i>&nbsp; <Strong>Info! </Strong>Enregistez-vous afin de pouvoir passer ou preparer vos examens en ligne.
</div>

<form:form commandName="utilisateur" cssClass="form-horizontal registrationForm">

    <c:if test="${success eq true}">
        <div class="alert alert-success"><i class="fa fa-check-circle-o"></i>&nbsp;<Strong>Réussite! </Strong>
            L'enregistrement a été effectué avec succès.
        </div>
    </c:if>

    <div class="form-group">
        <label for="login" class="col-sm-2 control-Label">Nom d'utilisateur:</label>
        <div class="col-sm-10">
            <form:input path="login" cssClass="form-control"/>
        </div>
    </div>
    <div class="form-group">
        <label for="mdp" class="col-sm-2 control-Label">Mot de passe:</label>
        <div class="col-sm-10">
            <form:password path="mdp" cssClass="form-control"/>
        </div>
    </div>
    <div class="form-group">
        <label for="mdp" class="col-sm-2 control-Label">Confirmation:</label>
        <div class="col-sm-10">
            <input type="password" name="mdp_encore" id="mdp_encore" class="form-control">
        </div>
    </div>
    <div class="form-group">
        <label for="nom" class="col-sm-2 control-Label">Nom:</label>
        <div class="col-sm-10">
            <form:input path="nom" cssClass="form-control"/>
        </div>
    </div>
    <div class="form-group">
        <label for="prenom" class="col-sm-2 control-Label">Prenom:</label>
        <div class="col-sm-10">
            <form:input path="prenom" cssClass="form-control"/>
        </div>
    </div>
    <div class="form-group">
        <label for="email" class="col-sm-2 control-Label">Email:</label>
        <div class="col-sm-10">
            <form:input path="email" cssClass="form-control"/>
        </div>
    </div>
    <div class="form-group">
        <label for="cin" class="col-sm-2 control-Label">CIN:</label>
        <div class="col-sm-10">
            <form:input path="cin" cssClass="form-control"/>
        </div>
    </div>
    <div class="form-group">
        <label for="numTel" class="col-sm-2 control-Label">Telephone:</label>
        <div class="col-sm-10">
            <form:input path="numTel" cssClass="form-control"/>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-2">
            <button type="submit" class="btn btn-Lg btn-primary">
                <i class="fa fa-check"></i>&nbsp;S'Enregistrer
            </button>
        </div>
    </div>
</form:form>
<script type="text/javascript">

    $(document).ready(function(){

        jQuery.validator.addMethod("valideTel", function(value, element) {
            return this.optional(element) || /^(06)|(05)[0-9]{8}$/.test(value);
        }, "Entrez un numéro de telephone valide commençant par 06 ou 05");

        jQuery.validator.addMethod("valideCin", function(value, element) {
            return this.optional(element) || /^[A-Z]{1,2}[0-9]{6}$/.test(value);
        }, "Entrez un numéro de CIN valide commençant par des lettres majuscule");


        $(".registrationForm").validate({
            rules: {
                login : {
                    required : true,
                    minlength : 3,
                    remote :{
                        url: "<spring:url value='/inscription/valable.html' />",
                        type: "get",
                        data: {
                            username: function () {
                                return $("#login").val();
                            }
                        }
                    }
                },
                email : {
                    required : true,
                    email:true
                },
                mdp: {
                    required : true,
                    minlength : 5
                },
                mdp_encore : {
                    required : true,
                    equalTo: "#mdp"
                },
                nom : {
                    required : true,
                    minlength : 3
                },
                prenom : {
                    required : true,
                    minlength : 3
                },
                cin : {
                    required : true,
                    minlength : 7,
                    valideCin : true
                },
                numTel : {
                    required : true,
                    digits : true,
                    minlength : 10,
                    valideTel : true
                }
            },
            highlight: function (element) {
                $(element).closest('.form-group').removeClass('has-success').addClass('has-error');

            },
            unhighlight: function (element) {
                $(element).closest('.form-group').removeClass('has-error').addClass('has-success');
            },
            messages: {
                login : {
                    required : "Entrez votre nom d'utilisateur",
                    minlength : "Au moins 3 caractères",
                    remote: "Ce nom d'utilisateur existe dejà! "
                },
                email : {
                    required : "Entrez votre email",
                    email:"Entrez un email valide"
                },
                mdp: {
                    required : "Entrez votre mot de passe",
                    minlength : "Au moins 5 caractères"
                },
                mdp_encore : {
                    required : "Retapez le mot de passe",
                    equalTo: "le mot de passe n'est pas le même"
                },
                nom : {
                    required : "Entrez votre nom",
                    minlength : "Au moins 3 caractères"
                },
                prenom : {
                    required : "Entrez votre prenom",
                    minlength : "Au moins 3 caractères"
                },
                cin : {
                    required : "Entrez votre numéro de cin",
                    minlength : "Au moins 7 caractères",
                },
                numTel : {
                    required : "Entrez votre numéro de télephone",
                    digits : "Le numéro de télephone ne doit contenir que des chiffres",
                    minlength : "Au mois 10 chiffres",
                }
            }
        })
    });
</script>