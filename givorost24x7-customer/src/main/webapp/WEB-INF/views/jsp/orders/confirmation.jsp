<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="ru">

<jsp:include page="../fragments/header.jsp" />

<div class="container">
    <br/>
    <br/>
    <h3 class="title">Ваше замовлення:</h3>
    <br/>
    <br/>

    <c:if test="${not empty order.id}">
    <div class="row">
        <label class="col-sm-2">Номер заказу:</label>
        <div class="col-sm-10">${order.id}</div>
    </div>
    </c:if>
    <br/>
    <div class="row">
        <label class="col-sm-2">Назва продукту:</label>
        <div class="col-sm-10">${order.prod.name}</div>
    </div>
    <br/>

    <div class="row">
        <label class="col-sm-2">Кiлькiсть:</label>
        <div class="col-sm-10">${order.amount} л.</div>
    </div>
    <br/>

    <c:if test="${not empty order.name}">
    <div class="row">
        <label class="col-sm-2">Ваше iм`я:</label>
        <div class="col-sm-10">${order.name}</div>
    </div>
    </c:if>
    <br/>

    <c:if test="${not empty order.tel}">
    <div class="row">
        <label class="col-sm-2">Ваш контактний телефон:</label>
        <div class="col-sm-10">${order.tel}</div>
    </div>
    </c:if>
    <br/>

    <c:if test="${not empty order.email}">
    <div class="row">
        <label class="col-sm-2">Ел. скринька:</label>
        <div class="col-sm-10">${order.email}</div>
    </div>
    </c:if>
    <br/>
    <br/>
    <c:if test="${not empty msg}">
        <div class="alert alert-${css} alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert"
                    aria-label="Close">
                <span aria-hidden="true">×</span>
            </button>
            <strong>${msg}</strong>
        </div>
    </c:if>


    <button type="button" onclick="document.location='/'" class="btn-lg btn-primary pull-right">Повернутися на головну
    </button>
</div>

<br/>

<jsp:include page="../fragments/footer.jsp" />

</body>
</html>
