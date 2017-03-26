var header = `
<h1 id="title">NexVid</h1>
    <div id="headerRight">
        <a href="login.html" id="loginLink">Login</a>
        <div class="dropdown pull-right">
            <a class="btn btn-default" href="#" data-toggle="dropdown" class="dropdown-toggle">
                <i class="fa fa-align-justify" title="Align Justify"></i>
            </a>
            <ul class="dropdown-menu">
                <li><a href="index.html">Home</a></li>
                <li><a href="login.html">Login</a></li>
            </ul>
        </div>
    </div>`


$(document).ready(function() {
    document.getElementById("banner").innerHTML = header;
});