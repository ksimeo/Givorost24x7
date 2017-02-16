<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/header.jsp" />

<div class="container">

    <c:choose>
        <c:when test="${prodForm.id == null}">
            <h1>Додати продукт</h1>
        </c:when>
        <c:otherwise>
            <h1>Зменити продукт</h1>
        </c:otherwise>
    </c:choose>
    <br />

    <spring:url value="/products/add" var="userActionUrl" />

    <form:form class="form-horizontal" method="post"
               modelAttribute="prodForm" action="${userActionUrl}">

        <form:hidden path="id" />

        <spring:bind path="name">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Назва продукту: </label>
                <div class="col-sm-10">
                    <form:input path="name" type="text" class="form-control"
                                id="name" placeholder="Введить назву продукту" />
                    <form:errors path="name" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="coeff">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Коефіцієнт: </label>
                <div class="col-sm-10">
                    <form:input path="coeff" class="form-control"
                                id="coeff" placeholder="Введить коеффіцієнт використання:" />
                    <form:errors path="coeff" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="price">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Ціна:</label>
                <div class="col-sm-10">
                    <form:input path="price" class="form-control"
                                   id="price" placeholder="Введіть ціну за 1 литр продукту" />
                    <form:errors path="price" class="control-label" />
                </div>
            </div>
        </spring:bind>
        <br/>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="button" class="btn-lg btn-primary pull-right" onclick="document.location='/products'">
                    До листу продуктів</button> &nbsp;
                <c:choose>
                    <c:when test="${prodForm.id == null}">
                        <button type="submit" class="btn-lg btn-primary pull-right">Додати продукт</button>
                    </c:when>
                    <c:otherwise>
                        <button type="submit" class="btn-lg btn-primary pull-right">Оновити продукт</button>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>

</div>

<jsp:include page="../fragments/footer.jsp" />
