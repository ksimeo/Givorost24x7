<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/header.jsp" />

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
    <c:choose>
        <c:when test="${prods != null}">

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

        <c:forEach var="prodName" items="${prods}">
            <tr>
                <td>${prodName.id}</td>
                <td>${prodName.name}</td>
                <td>${prodName.coeff}</td>
                <td>${prodName.price}</td>
                <td><button class="btn btn-info" onclick="location.href='products/change/${prodName.id}'">Змінити</button>
                    <button class="btn btn-warning" onclick="location.href='products/delete/${prodName.id}'">Видалити
                    </button></td>
            </tr>
        </c:forEach>
    </table>
        </c:when>
        <c:otherwise>
            <h3>Список продуктів доки що порожній.</h3>
        </c:otherwise>
    </c:choose>
    <br/>
    <button type="button" class="btn-lg btn-primary pull-right" onclick="document.location='/orders/1'">
        До листу замовлень</button> &nbsp;
    <button type="button" class="btn-lg btn-primary pull-right" onclick="document.location='/products/add'">
        Додати новий продукт</button>
</div

<jsp:include page="../fragments/footer.jsp" />