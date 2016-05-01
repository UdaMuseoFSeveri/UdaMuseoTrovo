var numBiglietto = 1;

function setPrice(select, tariffa) {
    var num = select.parentElement.parentElement.childNodes[0].textContent;
    document.getElementById("b-price" + num).innerHTML = tariffa;
}//setPrice

function getPrice(select){
    var num = select.parentElement.parentElement.childNodes[0].textContent;
    return parseInt(document.getElementById("b-price" + num).textContent);
}//getPrice

function changePrice(e) {
    var select;

    if (document.all)
        select = e.srcElement;
    else
        select = e.target;

    var prezzo = document.getElementById("prezzo").textContent;
    var scontoP = select.value;
    scontoP = parseInt(scontoP);
    prezzo = parseInt(prezzo);
    var sconto = prezzo * scontoP / 100;
    var tariffa = prezzo - sconto;
    console.log("sconto: " + scontoP + " prezzo: " + prezzo + "sconto- : " + sconto + " tariffa: " + tariffa);
    tariffa+=checkServizi();  
    setPrice(select, tariffa);
}//changePrice

/**
 * funzione per controllare in un dato momento il valore totale dei servizi selezionati
 * @returns {Number} il totale dei servizi selezionati
 */
function checkServizi(){
    var prezzi=0;
    $("#b-servizi"+numBiglietto+".servizi:checked").each(function(){
        prezzi+=parseInt($(this).val());
    });
    console.log("prezzo serivzi controllati: "+prezzi);
    return prezzi;
}
function aggiornaPrezzo(e,prezzoServizio) {
    var select;

    if (document.all)
        select = e.srcElement;
    else
        select = e.target;

    pBiglietto=getPrice(select.parentElement);
    console.log("prezzo biglietto: "+pBiglietto+"prezzo servizio:" + prezzoServizio);
    if(select.checked) var tariffa = pBiglietto + prezzoServizio;
    else var tariffa = pBiglietto - prezzoServizio;
    setPrice(select.parentElement, tariffa);
}

$(document).ready(function () {
    var price = document.getElementById("prezzo").textContent;
    price = parseInt(price);
    console.log("act: " + numBiglietto);
    $("#b-numB" + numBiglietto).html(numBiglietto++);
    var prevBiglietto = numBiglietto - 1;
    console.log("prev: " + prevBiglietto);
    $("#add-biglietti").click(function () {
        $("#prenota-biblietto").removeClass('invis');
    });

    //add a new row in the table
    $("#add").click(function () {
        var string = "<tr id=b" + numBiglietto + ">";
        var actualB = numBiglietto;
        string += "<td id='b-numB" + numBiglietto + "'>" + numBiglietto++ + "</td> ";
        string += "<td id='b-titolo" + actualB + "'>" + $("#b-titolo" + prevBiglietto).html() + "</td> ";
        string += "<td id='b-categoria" + actualB + "'>" + $("#b-categoria" + prevBiglietto).html() + "</select></td> ";
        string += "<td id='b-price" + actualB + "'>" + price + "</td> ";
        string += "<td id='b-validita" + actualB + "'>" + $("#b-validita" + prevBiglietto).html() + "</td>";
        string += "<td id='b-servizi" + actualB + "'>" + $("#b-servizi" + prevBiglietto).html() + "</td></tr>";

        $("#biglietti").append(string);
    });
});
