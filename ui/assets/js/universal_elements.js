var header = `
<h1 id="title">NexVid</h1>
    <div id="headerRight">
        <a href="login.html" id="loginLink">Login</a>
        <a class="btn btn-default" href="#">
            <i class="fa fa-align-justify fa-2x" title="Align Justify"></i>
        </a>
    </div>`


$(document).ready(function() {
    document.getElementById("banner").innerHTML = header;
});