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

    <c:choose>
        <c:when test="${orderForm['new']}">
            <h1>Заказать товар</h1>
        </c:when>
        <c:otherwise>
            <h1>Изменить заказ</h1>
        </c:otherwise>
    </c:choose>
    <br />

    <spring:url value="/orders" var="userActionUrl" />

    <form:form class="form-horizontal" method="post"
               modelAttribute="orderForm" action="${userActionUrl}">

        <form:hidden path="id" />

        <spring:bind path="name">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Имя</label>
                <div class="col-sm-10">
                    <form:input path="name" type="text" class="form-control"
                                id="name" placeholder="Ваше имя" />
                    <form:errors path="name" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="telNumber">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Телфон</label>
                <div class="col-sm-10">
                    <form:input path="telNumber" class="form-control"
                                id="telNumber" placeholder="Ваш номер телефона" />
                    <form:errors path="telNumber" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="email">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Телфон</label>
                <div class="col-sm-10">
                    <form:input path="email" class="form-control"
                                id="email" placeholder="Ваша эл.почта" />
                    <form:errors path="email" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="prodName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Продукт:</label>
                <div class="col-sm-10">
                    <form:input path="prodName" class="form-control"
                                   id="prodName" placeholder="Название продукта" />
                    <form:errors path="prodName" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="amount">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Количество:</label>
                <div class="col-sm-10">
                    <form:input path="amount" type="number" class="form-control"
                                   id="amount" placeholder="Необходимое количество продукта" />
                    <form:errors path="amount" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${orderForm['new']}">
                        <button type="submit" class="btn-lg btn-primary pull-right">Заказать
                        </button>
                    </c:when>
                    <c:otherwise>
                        <button type="submit" class="btn-lg btn-primary pull-right">Изменить
                        </button>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>

</div>

<jsp:include page="../fragments/footer.jsp" />

</body>
</html>