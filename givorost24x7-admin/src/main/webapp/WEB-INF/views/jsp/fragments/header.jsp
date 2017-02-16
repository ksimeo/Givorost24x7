<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
    <title>Живорост24x7</title>
    <link href="../../../../resources/core/css/style.css" rel="stylesheet" type="text/css">
    <spring:url value="/resources/core/css/hello.css" var="coreCss" />
    <spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
    <link href="${bootstrapCss}" rel="stylesheet" />
    <link href="${coreCss}" rel="stylesheet" />
</head>

<spring:url value="/" var="urlHome" />
<spring:url value="/users/add" var="urlAddUser" />
<link rel="shortcut icon" href="../../../../resources/core/images/ico/favicon.ico">

<nav class="navbar navbar-inverse ">
    <div class="container">
        <div class="navbar-header">
            <p class="navbar-brand" href="${urlHome}"><span><img src="../../../../resources/core/images/png/logo.png"
                    width="160" height="30">24х7</span>
        </div>
        <div id="navbar">
            <ul class="nav navbar-nav navbar-right">
                <li class="active"><button class="btn btn-default" onclick="document.location = '/logout'">Вийти
                </button>
                </li>
            </ul>
        </div>
    </div>
</nav>