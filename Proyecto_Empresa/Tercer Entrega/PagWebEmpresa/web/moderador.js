
function inicio(){
	
document.getElementById('titulo').innerHTML="Inicio";

var texto="Bienvenido a mi pagina web";
document.getElementById("textToEncode").innerHTML = texto;
        
	}

function catalogo(){
    
document.getElementById('titulo').innerHTML="Catalogo";
 
   
}

function quienesSomos(){
   
 document.getElementById('titulo').innerHTML="Quienes Somos";
var texto="DIDIER SPORT es una empresa proyectada en el sector de las confecciones con una gran trayectoria, contamos con personal calificado y excelentes equipos que nos permiten garantizar la calidad y la oportuna atención de todas las necesidades comerciales de nuestros clientes.";
document.getElementById("textToEncode").innerHTML = texto;
 
   
}

function contactenos(){
   
 document.getElementById('titulo').innerHTML="Contactenos";
 

   
}


function registrar(){

}

function loggear(){

}

function mision(){
document.getElementById('titulo').innerHTML="Mision";

var texto="Somos una empresa comprometida que lo único que nos interesa es satisfacer las necesidades y requerimiento de nuestros clientes y del mercado.";
document.getElementById("textToEncode").innerHTML = texto;
}

function vision(){
document.getElementById('titulo').innerHTML="Vision";

var texto="Nos vemos como una empresa líder, cumpliendo con la excelencia  del mercado a nivel nacional como internacional.";
document.getElementById("textToEncode").innerHTML = texto;
}

function showMe (it, box) {
var vis = (box.checked) ? "block" : "none";
document.getElementById(it).style.display = vis;
}