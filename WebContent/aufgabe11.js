

function connectToWebSocketServer() {
   webSocket = new WebSocket("ws://192.168.178.23:8080/webprog2/chat/" + document.getElementById('name').value);

    webSocket.onopen = function () {
        document.getElementById("myTextArea").innerHTML = 'connected';
    };

    webSocket.onmessage = function (event) {
         document.getElementById('myTextArea').innerHTML = document.getElementById('myTextArea').innerHTML + "\n" + event.data ;
    };

    webSocket.onclose = function () {
        document.getElementById('myTextArea').innerHTML = document.getElementById('myTextArea').innerHTML + "\nDisconnected...";

    };

    webSocket.onerror = function (error) {
        alert("Error in Socket. Reason: " + error);
        console.log('WebSocket Error ' + error);
    };

}

function disconnect() {
    webSocket.send('disconnected');
    webSocket.close();
    
}


function myFunction() {
    webSocket.send(document.getElementById('mytext').value);

}