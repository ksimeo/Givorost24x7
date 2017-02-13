<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/header2.jsp" />

<body>

<div class="container">

    <c:if test="${not empty msg}">
        <div class="alert alert-${css} alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert"
                    aria-label="Close">
                <span aria-hidden="true">×</span>
            </button>
            <strong>${msg}</strong>
        </div>
    </c:if>

    <h1>Список продуктів</h1>
    <br/>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>#ID</th>
            <th>Назва продукту</th>
            <th>коефіцієнт витрати</th>
            <th>ціна за літр</th>
            <th></th>
        </tr>
        </thead>

        <c:forEach var="prod" items="${prods}">
            <tr>
                <td>${prod.id}</td>
                <td>${prod.name}</td>
                <td>${prod.coeff}</td>
                <td>${prod.price}</td>
                <td><button class="btn btn-info" onclick="location.href='products/change/${orderUrl}'">Змінити</button>
                    <button class="btn btn-danger" onclick="location.href='products/delete/${orderUrl}'">Видалити
                    </button></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <button type="button" onclick="document.location='/'" class="btn-lg btn-primary pull-right">Додати новий продукт
    </button>
</div>

<jsp:include page="../fragments/footer.jsp" />
