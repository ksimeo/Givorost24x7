<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="uk-UA">

<jsp:include page="../fragments/header.jsp" />

<div class="container">

    <spring:url value="/order" var="userActionUrl" />

        <div class="container">
            <br/>
            <h3 class="title">Здійснення замовлення</h3>
            <br/>
            <br/>
            <h4>Для здійснення замовлення, будь ласка, заповнить усі поля форми або тільки номер телефону:</h4>
            <br/>
        </div>

    <form:form class="form-horizontal" method="post"
               modelAttribute="orderForm" action="${userActionUrl}">

        <form:hidden path="id" />

        <spring:bind path="tel">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Телефон: +380</label>
                <div class="col-sm-10">
                    <form:input path="tel" class="form-control"
                                id="tel" placeholder="Номер вашого телефону" />
                    <form:errors path="tel" class="control-label" />
                </div>
            </div>
        </spring:bind>
        <%--TODO validation tel.number and e-mail--%>

        <spring:bind path="name">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Ваше і'мя:</label>
                <div class="col-sm-10">
                    <form:input path="name" type="text" class="form-control"
                                id="name" placeholder="Будь ласка, напишить як до вас звертатися (бажано)" />
                    <form:errors path="name" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="email">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Електронна скринька:</label>
                <div class="col-sm-10">
                    <form:input path="email" class="form-control"
                                id="email" placeholder="Бажано" />
                    <form:errors path="email" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <div class="form-group" >
            <label class="col-sm-2 control-label">Марка продукту:</label>
            <div class="col-sm-10">
                <select id="prod" name="product" size="1" onchange="changeProd()">
                    <option name="prod" id="prod0" value="NaN">-Виберіть-тип-продукту-</option>
                    <c:forEach items="${prods}" var="item">
                        <option name="type" value="${item.id}" ${item.id == prodType ? 'selected="selected"' : ''}>
                                ${item.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <spring:bind path="amount">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Кількість продукту обраної марки (л):</label>
                <div class="col-sm-10">
                    <form:input path="amount" type="number" class="form-control"
                                   id="amount" style='width: 2em important;'
                                placeholder="Необходимое количество продукта" />
                    <form:errors path="amount" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="button" onclick="document.location='/'" class="btn-lg btn-primary pull-right">
                    Повернутися на головну</button> &nbsp; &nbsp;
                <button type="submit" class="btn-lg btn-primary pull-right">Здійснити замовлення</button>
            </div>
        </div>
    </form:form>

</div>

<jsp:include page="../fragments/footer.jsp" />

</body>
</html>