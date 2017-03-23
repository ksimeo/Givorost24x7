/**
 * Created by @Ksimeo on 22.02.17.
 */

function ajaxDoReader(orderId) {

    var paramData = "orderId=" + orderId;
    $.ajax({
        type:'GET',
        url:'/orders/read/' + orderId,
        data: paramData,
        success: function(servletResult) {
            console.log("Date:" + servletResult.date + "State:" + servletResult.state);
            document.getElementById('orderRead-' + orderId).innerHTML = "<h6>Переглянуто: " + servletResult.date + "</h6>";
            document.getElementById("orderRead-" + orderId).style.display = "true";
            document.getElementById('state-' + orderId).innerHTML = servletResult.state;
            document.getElementById('order-' + orderId).style.color = "gray !important";
        },
        error: function() {
            console.log('error');
        }
    });
}
