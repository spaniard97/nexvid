$(document).ready(function() {

  $("#loginButton").click(function() {

    var password = $("#password").val();
    var emailInput = $("#email").val();
    var email;

    if (/[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$/.test(emailInput)) {
      email = emailInput;
    } else {
      window.alert("Invalid email address");
    }

  })
})
