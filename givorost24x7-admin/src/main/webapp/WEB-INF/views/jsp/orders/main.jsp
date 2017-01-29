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

    <h1>All Orders</h1>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>#ID</th>
            <th>Prod Name</th>
            <th>Tel number</th>
            <th>Name</th>
            <th>Amount</th>
        </tr>
        </thead>

        <c:forEach var="order" items="${orders}">
            <tr>
                <td>${order.id}</td>
                <td>${order.prod}</td>
                <td>${order.tel}</td>
                <td>${order.name}</td>
                <td>${order.amount}</td>
            </tr>
        </c:forEach>
    </table>
    <ul class="pagination pull-center">
<c:forEach var="pagenumb" items="${pagin}">
   <li>${pagenumb == page ? '<li class="active">' : ''} <a href="/showorderspage/${pagenumb}">${pagenumb}</a>
   ${pagenumb == page ? '<li class="active">' : ''}</li>
</c:forEach>
    </ul>
</div>
</body>
</html>
