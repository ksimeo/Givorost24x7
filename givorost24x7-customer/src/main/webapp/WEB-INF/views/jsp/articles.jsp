<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ page session="false"%>

<!DOCTYPE html>
<html lang="uk-UA">

<jsp:include page="fragments/header.jsp" />

<!--gallery-->
<div class="gallery">
    <div class="container">
        <h2 class="title">Статті</h2>
        <div class="gallery-grids">
            <div class="col-md-4 port-grids view view-fourth">
                <a class="example-image-link" href="article/1">
                    <img class="img-responsive" src="../../../resources/images/jpg/salat%20mini.jpg" alt="">
                    <div class="mask">
                        <p>Відновлення мікрофлори ґрунту</p>
                    </div>
                </a>
            </div>
            <div class="col-md-4 port-grids view view-fourth">
                <a class="example-image-link" href="article/2">
                    <img class="img-responsive" src="../../../resources/images/jpg/g8.jpg" alt="">
                    <div class="mask">
                        <p>Краткое описание статьи</p>
                    </div>
                </a>
            </div>
            <div class="col-md-4 port-grids view view-fourth">
                <a class="example-image-link" href="article/3">
                    <img class="img-responsive" src="../../../resources/images/jpg/g5.jpg" alt="">
                    <div class="mask">
                        <p>Краткое описание статьи</p>
                    </div>
                </a>
            </div>
        </div>
    </div>
</div>
<div id="lightboxOverlay" class="lightboxOverlay" style="display: none;"></div><div id="lightbox" class="lightbox"
                                                                                    style="display: none;">
</div>
<!--//gallery-->

<jsp:include page="fragments/footer.jsp" />