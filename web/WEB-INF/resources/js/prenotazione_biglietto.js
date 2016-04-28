var numBiglietto = 0;

function getNumBiglietto(){
    return numBiglietto++;
}

function getTariffa(prezzo,categoria){
    var sconto = document.getElementById("#"+categoria).selectedIndex;
    var tariffa = prezzo*sconto/100;
    return tariffa;
}
