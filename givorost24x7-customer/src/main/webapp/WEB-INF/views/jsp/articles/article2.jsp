<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ page session="false"%>

<!DOCTYPE html>
<html lang="uk-UA">

<jsp:include page="../fragments/header2.jsp" />

<!-- single -->
<div class="single">
    <div class="container">
        <h2 class="title">Статья 2</h2>
        <div class="single-info">
            <div class="col-md-12 single-left">
                <ul>
                    <li><span class="glyphicon glyphicon-calendar" aria-hidden="true"></span> 2016-11-03 08:27:00</li>
                </ul>
                <img class="img-responsive" src="../../../../resources/images/jpg/g8.jpg" alt="">
                <p>
                    <i>Краткое описание статьи</i>
                </p>
                <p>
                    <em>Чекайте на нову статю</em>
                </p>
            </div>
        </div>
    </div>
</div>
<!-- //single -->
<!--contact-->
<div class="contact" id="contact">
    <div class="map">
        <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d281820.13181192306!2d35.2978987!3d48.7135223!
        3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x0!2zNDjCsDQ3JzQxLjAiTiAzNcKwMjInMDMuMyJF!5e1!3m2!1suk!2sua!4v14785961
        99634" allowfullscreen></iframe>
        <div class="map-color">
        </div>
    </div>
    <div class="contact-grids">
        <div class="col-md-3 contact-grid">
            <div class="call">
                <div class="col-xs-2 contact-grdl">
                    <span class="glyphicon glyphicon-phone" aria-hidden="true"></span>
                </div>
                <div class="col-xs-10 contact-grdr">
                    <ul>
                        <li>+380 68 85 44 665</li>
                        <li>+380 95 24 25 505</li>
                    </ul>
                </div>
                <div class="clearfix"> </div>
            </div>
            <div class="address">
                <div class="col-xs-2 contact-grdl">
                    <span class="glyphicon glyphicon-send" aria-hidden="true"></span>
                </div>
                <div class="col-xs-10 contact-grdr">
                    <ul>
                        <li>Євецько-Миколаївка, Новомосковський р-н, Дніпропетровської обл. Україна</li>
                    </ul>
                </div>
                <div class="clearfix"> </div>
            </div>
            <div class="mail">
                <div class="col-xs-2 contact-grdl">
                    <span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
                </div>
                <div class="col-xs-10 contact-grdr">
                    <ul>
                        <li><a href="mailto:givorost@gmail.com">givorost@gmail.com</a></li>
                    </ul>
                </div>
                <div class="clearfix"> </div>
            </div>
        </div>
        <div class="clearfix"> </div>
    </div>
</div>
<!--//contact-->

<jsp:include page="../fragments/footer.jsp" />