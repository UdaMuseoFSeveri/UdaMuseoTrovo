function checkServizi() {
    var prezzi = 0;
    $(".servizi:checked").each(function () {
        prezzi += parseFloat($(this).val());
    });
    console.log("prezzo serivzi controllati: " + prezzi);
    return prezzi;
}

$(document).ready(function () {
    $('.servizi:checked').each(function () {
        $(this).removeAttr("checked");
    });

    $("#add-biglietti").click(function () {
        $("#prenota-biblietto").removeClass('invis');
    });

    $(".categorie").change(function (e) {
       // e.preventDefault(); 
        var codice = $('.categorie option:selected').attr('data-codice');
        $("#i-categoria").prop("value", codice);
        console.log("codice: " + codice);

        var prezzo = parseFloat($("#prezzo").html());
        var percSconto = parseFloat($(this).val());
        var tariffa = prezzo - (prezzo * percSconto / 100);
        tariffa += checkServizi();
        $("#price").text(tariffa);
        console.log("prezzo: " + prezzo + " sconto: " + percSconto + " tariffa: " + tariffa);
    });

    $(".servizi").click(function () {
        var actualPrice = parseFloat($("#price").html());
        if ($(this).prop("checked")) {
            var tariffa = actualPrice + parseFloat($(this).val());
            $("#price").text(tariffa);
            var s = "<input name='servizi' id='s-" + $(this).data('codice') + "' value='" + $(this).data('codice') + "' type='hidden' />";
            $("#inputBiglietto").append(s);
        } else {
            var tariffa = actualPrice - parseFloat($(this).val());
            var selected = $(this).data('codice');
            $("#s-" + selected).remove();
            $("#price").text(tariffa);
        }

    });
});
