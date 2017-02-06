<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ page session="false"%>

<!DOCTYPE html>
<html lang="uk-UA">

<jsp:include page="fragments/header.jsp" />

<!--gallery-->
<div class="gallery">
    <div class="container">
        <h2 class="title">Продукція</h2>
        <div class="gallery-grids">
            <div class="col-md-4 port-grids view view-fourth">
                <a class="example-image-link" href="product/1">
                    <img class="img-responsive" src="../../../resources/images/jpg/verm%20mini.jpg" alt="">
                    <div class="mask">
                        <p>Гній, не реалізовані овочі  - ми перетворюємо на краще добриво в світі</p>
                    </div>
                </a>
            </div>
            <div class="col-md-4 port-grids view view-fourth">
                <a class="example-image-link" href="product/2">
                    <img class="img-responsive" src="../../../resources/images/jpg/biogumus%20mishok.jpg" alt=""/>
                    <div class="mask">
                        <p>Біогумус - органічне добриво пролонгованої дії</p>
                    </div>
                </a>
            </div>
            <div class="col-md-4 port-grids view view-fourth">
                <a class="example-image-link" href="product/3">
                    <img class="img-responsive" src="../../../resources/images/jpg/Kan%20pole%2010.jpg" alt="">
                    <div class="mask">
                        <p>Природний стимулятор рослин</p>
                    </div>
                </a>
            </div>
            <div class="col-md-4 port-grids view view-fourth">
                <a class="example-image-link" href="product/4">
                    <img class="img-responsive" src="../../../resources/images/jpg/Komplekt.jpg" alt="">
                    <div class="mask">
                        <p></p>
                    </div>
                </a>
            </div>
        </div>
    </div>
</div>

<jsp:include page="fragments/footer.jsp" />