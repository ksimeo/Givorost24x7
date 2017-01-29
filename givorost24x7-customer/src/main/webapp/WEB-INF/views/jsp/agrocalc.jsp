<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ru">

<jsp:include page="fragments/header.jsp" />

<h2 style="text-align: center">Здесь будет калькулятор расчета необходимого количества продукта</h2>

<div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
        <button type="button" class="btn-lg btn-primary pull-right" onclick="document.location='/orders/add'">
            К странице заказа</button>
    </div>
</div>

<jsp:include page="fragments/footer.jsp" />
</body>
</html>
