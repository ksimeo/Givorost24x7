<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ page session="false"%>

<!DOCTYPE html>
<html lang="uk-UA">

<jsp:include page="../fragments/header.jsp" />

<script type="text/javascript">


</script>

<div class="container">
    <br/>
    <br/>
    <h4 class="title">Розрахунок потрібної вам кiлькостi нашого продукту</h4>
    <br/>

    <div>
    <div>Вкажіть тип зрошення &nbsp;
        <label>
            <select id="irrigation" name="irrigation" size="1" onchange="irrTypeChange()">
                <option id="01" value="0">Виберіть-тип-зрошення</option>
                <option value="1">Обработка насiння</option>
                <option value="2">Позакорнева обробка</option>
                <option value="3">Капельне зрошення</option>
            </select>
        </label>
    </div>
    <br/>
        <output id="result"></output>
    <br/>

        <%--<div id="culture" hidden="hidden">--%>
            <%--виберіть тип культури, яку необхідно удобрювати--%>
            <%--<div>--%>
                <%--<table>--%>
                    <%--<tr>--%>
                        <%--<td>--%>
                            <%--<input type="radio" name="agroculture" value="r1" onchange="changeText0()">Зернові--%>
                            <%--культури</input><br/>--%>
                            <%--<input type="radio" name="agroculture" value="r2"--%>
                                   <%--onchange="changeText0()">Кукурудза</input><br/>--%>
                            <%--<input type="radio" name="agroculture" value="r3"--%>
                                   <%--onchange="changeText0()">Соняшник</input><br/>--%>
                            <%--<input type="radio" name="agroculture" value="r4"--%>
                                   <%--onchange="changeText0()">Ріпак </input><br/>--%>
                            <%--<input type="radio" name="agroculture" value="r5" onchange="changeText0()">Соя</input>--%>
                            <%--<br/>--%>
                            <%--<input type="radio" name="agroculture" value="r6"--%>
                                   <%--onchange="changeText0()">Картопля</input><br/>--%>
                            <%--<input type="radio" name="agroculture" value="r7"--%>
                                   <%--onchange="changeText0()">Морква</input>--%>
                        <%--</td>--%>
                        <%--<td>--%>
                            <%--<input type="radio" name="agroculture" value="r8"--%>
                                   <%--onchange="changeText0()">Огірки</input><br/>--%>
                            <%--<input type="radio" name="agroculture" value="r9"--%>
                                   <%--onchange="changeText0()">Капуста</input><br/>--%>
                            <%--<input type="radio" name="agroculture" value="r10"--%>
                                   <%--onchange="changeText0()">Пасльонові</input><br/>--%>
                            <%--<input type="radio" name="agroculture" value="r11" onchange="changeText0()">Сади</input>--%>
                            <%--<br/>--%>
                            <%--<input type="radio" name="agroculture" value="r12"--%>
                                   <%--onchange="changeText0()">Виноград</input><br/>--%>
                            <%--<input type="radio" name="agroculture" value="r13" onchange="changeText0()">Ягідні--%>
                            <%--культури</input><br/>--%>
                            <%--<input type="radio" name="agroculture" value="r14" onchange="changeText0()">Кімнатні--%>
                            <%--рослини</input>--%>
                        <%--</td>--%>
                    <%--</tr>--%>
                <%--</table>--%>
            <%--</div>--%>
        <div id = "product" hidden>
            Вкажіть тип культури і введіть площа яку необхідно удобрювати <br/>
            <select id="prodType" name="prodType" onchange="changeProdType()" size="1">
                <option id="prod0" value="0">-Виберіть-тип-продукту-</option>
                <option value="1">Бiогумат для вiдкритого грунту</option>
                <option value="2">Бiогумат для закритого грунту</option>
            </select>
            <input type="number" id="amount">
            <select id="razmern" name="products" size="1">
                <option id="dim0" value="0">виберiть-розмiрнiсть</option>
                <option value="1">Га</option>
                <option value="100">Ар</option>
                <option value="10000">кв.м</option>
            </select>
        </div>
    <br/>
    <br/>
        <input type="button" value="Замовити" onclick="document.location = '/order?numb='"/>
        <input type="button" value="Повернутися на головну" onclick="document.location = '/index'"/>


        + res + \&type=\ + id/>

    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
</div>

<jsp:include page="../fragments/footer.jsp" />