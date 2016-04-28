var numBiglietto = 1;


$(document).ready(function(){
    console.log("act: "+numBiglietto);
    $("#b-numB"+numBiglietto).html(numBiglietto++);
    var prevBiglietto = numBiglietto-1;
    console.log("prev: "+prevBiglietto);
    $("#add-biglietti").click(function(){
        $("#prenota-biblietto").removeClass('invis');
    });
    $("#categorie"+prevBiglietto).change(function(){
        console.log(prevBiglietto);
        var scontoP = $(this).val();
        scontoP = parseInt(scontoP);
        var prezzo = $('#prezzo').text();
        prezzo = parseInt(prezzo);
        var sconto = prezzo*scontoP/100;
        var tariffa = prezzo - sconto;
        console.log("sconto: "+scontoP+" prezzo: "+prezzo+"sconto- : "+sconto +" tariffa: "+tariffa);
        $("#price"+prevBiglietto).html(tariffa);
    });
    //add a new row in the table
    $("#add").click(function(){
        var string = "<tr id=b"+numBiglietto+">";
        var actualB=numBiglietto;
        string+="<td id='b-numB"+numBiglietto+"'>"+numBiglietto+++"</td>";
        string+="<td id='b-titolo"+actualB+"'>"+$("#b-titolo"+prevBiglietto).html()+"</td>";
        string+="<td id='b-categoria"+actualB+"'><select id='categorie"+actualB+"' name='cat"+actualB+"'>"+$("#categorie"+prevBiglietto).html()+"</select></td>";
        string+="<td id='b-price"+actualB+"'>"+$("#b-price"+prevBiglietto).html()+"</td>";
        string+="<td id='b-validita"+actualB+"'>"+$("#b-validita"+prevBiglietto).html()+"</td></tr>";
        
        $("#biglietti").append(string);
    });
});
