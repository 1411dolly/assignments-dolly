var xmlHttp;
function srvTime(){
    try {
        xmlHttp = new XMLHttpRequest();
    }
    catch (e) {
                alert("AJAX not supported");
            }
    xmlHttp.open('HEAD',window.location.href.toString(),false);
    xmlHttp.setRequestHeader("Content-Type", "text/html");
    xmlHttp.send('');
    return xmlHttp.getResponseHeader("Date");
}
var st = srvTime();
var date = new Date(st);

