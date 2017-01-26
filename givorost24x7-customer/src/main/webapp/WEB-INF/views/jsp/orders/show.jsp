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

    <c:if test="${not empty msg}">
        <div class="alert alert-${css} alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert"
                    aria-label="Close">
                <span aria-hidden="true">×</span>
            </button>
            <strong>${msg}</strong>
        </div>
    </c:if>

    <h1>Вы заказали:</h1>

    <br />

    <div class="row">
        <label class="col-sm-2">Имя продукта</label>
        <div class="col-sm-10">${order.prod}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Количество</label>
        <div class="col-sm-10">${order.amount}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Имя</label>
        <div class="col-sm-10">${order.name}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Телефон</label>
        <div class="col-sm-10">${order.tel}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Эл. почта</label>
        <div class="col-sm-10">${order.email}</div>
    </div>
</div>

<button type="button" onclick="document.location='/index'" class="btn-lg btn-primary pull-right">На главную
</button>

<jsp:include page="../fragments/footer.jsp" />

</body>
</html>
