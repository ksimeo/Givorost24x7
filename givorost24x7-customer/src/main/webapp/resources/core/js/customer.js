/**
 * @author Ksimeo. Created on 05.02.2017 at 20:11 for "givorost24x7" project.
 * @version 1.0
 * @since 1.0
 */

function irrTypeChange(){

    var irrigationType = parseInt(document.getElementById('irrigation').value);

    if (irrigationType == 0) {
        document.getElementById('result').innerHTML = " ";
    } else if (irrigationType == 1) {
        document.getElementById('01').setAttribute('hidden', 'hidden');
        document.getElementById('product').innerHTML = "Вкажіть тип зрошення &nbsp; " +
            "<table>" +
                    "<tr>" +
                        "<td>" +
                            "<input type=\"radio\" name=\"agroculture\" value=\"r1\" onchange=\"selCultType()\">" +
                        "Зернові культури</input>" +
                            "<br/>" +
                            "<input type=\"radio\" name=\"agroculture\" value=\"r2\" onchange=\"selCultType()\">" +
                        "Кукурудза</input>" +
                            "<br/>" +
                            "<input type=\"radio\" name=\"agroculture\" value=\"r3\" onchange=\"selCultType()\">" +
                        "Соняшник</input>" +
                            "<br/>" +
                            "<input type=\"radio\" name=\"agroculture\" value=\"r4\"onchange=\"selCultType()\">" +
                        "Ріпак </input>" +
                            "<br/>"+
                            "<input type=\"radio\" name=\"agroculture\" value=\"r5\" onchange=\"selCultType()\">Соя" +
                        "</input>" +
                            "<br/>"+
                            "<input type=\"radio\" name=\"agroculture\" value=\"r6\" onchange=\"selCultType()\">Картопля" +
                        "</input><br/>" +
                            "<input type=\"radio\" name=\"agroculture\" value=\"r7\"onchange=\"selCultType()\">Морква" +
                        "</input>" +
                            "</td>" +
                            "<td>" +
                            "<input type=\"radio\" name=\"agroculture\" value=\"r8\" onchange=\"selCultType()\">Огірки" +
                        "</input>" +
                            "<br/>" +
                            "<input type=\"radio\" name=\"agroculture\" value=\"r9\" onchange=\"selCultType()\">Капуста" +
                        "</input>" +
                            "<br/>" +
                            "<input type=\"radio\" name=\"agroculture\" value=\"r10\" onchange=\"selCultType()\">Пасльонові" +
                        "</input>" +
                            "<br/>" +
                            "<input type=\"radio\" name=\"agroculture\" value=\"r11\" onchange=\"selCultType()\">Сади" +
                        "</input>" +
                            "<br/>" +
                            "<input type=\"radio\" name=\"agroculture\" value=\"r12\" onchange=\"selCultType()\">" +
                        "Виноград</input><br/>" +
                            "<input type=\"radio\" name=\"agroculture\" value=\"r13\" onchange=\"selCultType()\">Ягідні " +
                        "культури</input><br/>" +
                            "<input type=\"radio\" name=\"agroculture\" value=\"r14\" onchange=\"selCultType()\">Кімнатні" +
                        " рослини</input>" +
                    "</td>" +
                "</tr>" +
            "</table>";
    } else if (irrigationType == 2) {
        document.getElementById('01').setAttribute('hidden', 'hidden');
        document.getElementById('product').innerHTML = "Вкажіть тип зрошення &nbsp; " +
            "<table>" +
                "<tr>" +
                    "<td>" +
                        "<input type=\"radio\" name=\"agroculture\" value=\"r14\" onchange=\"selCultType()\">Кімнатні" +
                    " рослини</input>" +
                        "<br/>" +
                        "<input type=\"radio\" name=\"agroculture\" value=\"r13\" onchange=\"selCultType())\">Ягідні" +
                    " культури</input><br/>" +
                        "<input type=\"radio\" name=\"agroculture\" value=\"r12\" onchange=\"selCultType()\">Виноград" +
                    "</input>" +
                        "<br/>" +
                        "<input type=\"radio\" name=\"agroculture\" value=\"r11\" onchange=\"selCultType()\">Сади" +
                    "</input>" +
                        "<br/>" +
                        "<input type=\"radio\" name=\"agroculture\" value=\"r10\" onchange=\"selCultType()\">Пасльонові" +
                    "</input>" +
                        "<br/>" +
                        "<input type=\"radio\" name=\"agroculture\" value=\"r9\" onchange=\"selCultType()\">Капуста" +
                    "</input>" +
                        "<br/>" +
                        "<td>" +
                        "<input type=\"radio\" name=\"agroculture\" value=\"r8\" onchange=\"selCultType()\">Огірки" +
                    "</input>" +
                        "<br/>" +
                        "<input type=\"radio\" name=\"agroculture\" value=\"r7\"onchange=\"selCultType()\">Морква" +
                    "</input>" +
                    "</td>" +
                    "<td>" +
                        "<input type=\"radio\" name=\"agroculture\" value=\"r6\" onchange=\"selCultType()\">Картопля" +
                    "</input>" +
                    "<br/>" +
                        "<input type=\"radio\" name=\"agroculture\" value=\"r5\" onchange=\"selCultType()\">Соя" +
                    "</input><br/>"+
                        "<input type=\"radio\" name=\"agroculture\" value=\"r2\" onchange=\"selCultType()\">Кукурудза" +
                    "</input><br/>" +
                        "<input type=\"radio\" name=\"agroculture\" value=\"r4\"onchange=\"selCultType()\">Ріпак</input>" +
                    "<br/>"+
                    "<input type=\"radio\" name=\"agroculture\" value=\"r3\" onchange=\"selCultType()\">Соняшник" +
                        "</input><br/>" +
                    "<input type=\"radio\" name=\"groculture\" value=\"r1\" onchange=\"selCultType()\">Зернові" +
                        " культури</input><br/>" +
                    "</td>" +
                "</tr>" +
            "</table>";
    } else if (irrigationType == 3) {
        document.getElementById('01').setAttribute('hidden', 'hidden');
        document.getElementById('product').innerHTML = "Вкажіть тип зрошення &nbsp; " +
            "<table>" +
                "<tr>" +
                    "<td>" +
                        "<input type=\"radio\" name=\"agroculture\" value=\"r1\" onchange=\"selCultType()\">" +
                    "Зернові культури</input>" +
                        "<br/>" +
                        "<input type=\"radio\" name=\"agroculture\" value=\"r2\" onchange=\"selCultType()\">" +
                    "Кукурудза</input>" +
                        "<br/>" +
                        "<input type=\"radio\" name=\"agroculture\" value=\"r3\" onchange=\"selCultType()\">" +
                    "Соняшник</input>" +
                        "<br/>" +
                        "<input type=\"radio\" name=\"agroculture\" value=\"r4\"onchange=\"selCultType()\">" +
                    "Ріпак </input>" +
                        "<br/>"+
                        "<input type=\"radio\" name=\"agroculture\" value=\"r5\" onchange=\"selCultType()\">Соя" +
                    "</input>" +
                        "<br/>"+
                        "<input type=\"radio\" name=\"agroculture\" value=\"r6\" onchange=\"selCultType()\">Картопля" +
                    "</input><br/>" +
                        "<input type=\"radio\" name=\"agroculture\" value=\"r7\"onchange=\"selCultType()\">Морква" +
                    "</input>" +
                    "</td>" +
                    "<td>" +
                        "<input type=\"radio\" name=\"agroculture\" value=\"r8\" onchange=\"selCultType()\">Огірки" +
                    "</input>" +
                        "<br/>" +
                        "<input type=\"radio\" name=\"agroculture\" value=\"r9\" onchange=\"selCultType()\">Капуста" +
                    "</input>" +
                        "<br/>" +
                        "<input type=\"radio\" name=\"agroculture\" value=\"r10\" onchange=\"selCultType()\">Пасльонові" +
                    "</input>" +
                        "<br/>" +
                        "<input type=\"radio\" name=\"agroculture\" value=\"r11\" onchange=\"selCultType()\">Сади" +
                    "</input>" +
                        "<br/>" +
                        "<input type=\"radio\" name=\"agroculture\" value=\"r12\" onchange=\"selCultType()\">" +
                    "Виноград</input><br/>" +
                        "<input type=\"radio\" name=\"agroculture\" value=\"r13\" onchange=\"selCultType()\">Ягідні " +
                    "культури</input><br/>" +
                        "<input type=\"radio\" name=\"agroculture\" value=\"r14\" onchange=\"selCultType()\">Кімнатні" +
                    " рослини</input>" +
                "</td>" +
            "</tr>" +
        "</table>";
    }
}

function selCultType() {
    document.getElementById('product').removeAttribute('hidden');
}

function changeProdType() {
    document.getElementById('prod0').setAttribute('hidden', 'hidden');
}

function changeDim() {
    document.getElementById('dim0').setAttribute('hidden', 'hidden');
}

function changeAmount() {
    var coeff1 = parseInt(document.getElementById('irrigation').value);
    var coeff2 = parseInt(document.getElementById('culture').value);
    var coeff3 = parseFloat(document.getElementById('product').value);
    var coeff4 = parseFloat(document.getElementById('dimension').value);
    var amount = parseInt(document.getElementById('amount').value);

    if (coeff1 != null && coeff2 != null && coeff3 != null && coeff4 != null && amount != null) {
        document.getElementById('result').innerHTML = "" +
            "<hr/>" +
                "<h2>" +
                    "<p style=\"color:#006942;\">" +
                    "Вам знадобиться \' + res + \' л обраного бiогумату </p>" +
                "</h2> " +
                "<h2>" +
                    "<input type=\"button\" value=\"Замовити\" onclick=\"document.location = \'/order?numb=\'+" +
            " \'numb&id=\' + type + \" />" +
            "<input type=\"button\" value=\"Повернутися на головну\" onclick=\"document.location = \'/\'" +
            " \'numb&id=\' + type + \" /></h2>";
    }
}