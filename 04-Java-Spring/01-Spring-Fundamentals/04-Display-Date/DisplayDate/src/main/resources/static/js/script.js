window.onload = function(){
var title = document.getElementsByTagName('title')[0].innerHTML;
var string = "This is the " +title.toLowerCase() +" template";
alert(string);
};