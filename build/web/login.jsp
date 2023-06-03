<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/Login.css" />
        <title>Login</title>
        <style>
            @import url('https://fonts.googleapis.com/css2?family=Poppins:&display=swap');
            body {

                height: 100vh;
                background-color: #f2f2f2;
                background-image: url("img/background.png");
                background-size: cover; /* optional */

            }
            /* Set up the container for the leaves */
            .leaves-container {
                position: relative;
                height: 100vh;
                overflow: hidden;
            }
            /* Style for the individual leaves */
            .leaf {
                position: absolute;
                width: 30px;
                height: 30px;
                background-color: #9ac23c00;
                border-radius: 50%;
                animation: falling 8s ease-in-out infinite;
            }
            /* Keyframe animation for the falling leaves */
            @keyframes falling {
                0% {
                    transform: translateY(-10%);
                }
                100% {
                    transform: translateY(3220%);
                }
            }
            /* Position each leaf randomly within the container */
            .leaf:nth-child(1) {
                left: 5%;
                top: -5%;
                animation-delay: 0.5s;
            }
            .leaf:nth-child(2) {
                left: 25%;
                top: -10%;
                animation-delay: 2s;
            }
            .leaf:nth-child(3) {
                left: 45%;
                top: -15%;
                animation-delay: 3.5s;
            }
            .leaf:nth-child(4) {
                left: 65%;
                top: -20%;
                animation-delay: 1s;
            }
            .leaf:nth-child(5) {
                left: 85%;
                top: -25%;
                animation-delay: 2.5s;
            }
            .leaf:nth-child(6) {
                left: 95%;
                top: -15%;
                animation-delay: 2.5s;
            }

            .leaf:nth-child(7) {
                left: 55%;
                top: -15%;
                animation-delay: 1.5s;
            }

            .leaf:nth-child(8) {
                left: 20%;
                top: -15%;
                animation-delay: 1.0s;
            }
            /* Responsive styles */
            @media screen and (max-width: 600px) {
                .login-box {
                    max-width: 300px;
                }
            }
        </style>
    </head>
    <body>
        <div class="leaves-container">
            <!-- Add 20 leaves to the container -->
            <div class="leaf"><img src="img/leave2.png"></div>
            <div class="leaf"><img src="img/leave2.png"></div>
            <div class="leaf"><img src="img/leave2.png"></div>
            <div class="leaf"><img src="img/leave2.png"></div>
            <br>
            <div class="leaf"><img src="img/leave1.png"></div>
            <div class="leaf"><img src="img/leave1.png"></div>
            <div class="leaf"><img src="img/leave1.png"></div>
            <div class="leaf"><img src="img/leave1.png"></div>
            <div class="leaf"><img src="img/leave1.png"></div>
            <div class="leaf"><img src="img/leave1.png"></div>
            <div class="leaf"><img src="img/leave1.png"></div>
            <div class="leaf"><img src="img/leave1.png"></div>
            <div class="leaf"><img src="img/leave1.png"></div>
            <div class="leaf"><img src="img/leave1.png"></div>
            <div class="leaf"><img src="img/leave1.png"></div>
            <div class="leaf"><img src="img/leave1.png"></div>
            <div class="leaf"><img src="img/leave1.png"></div>
            <div class="leaf"><img src="img/leave1.png"></div>
            <div class="leaf"><img src="img/leave1.png"></div>
            <div class="leaf"><img src="img/leave1.png"></div>
            <div class="leaf"><img src="img/leave1.png"></div>
            <div class="leaf"><img src="img/leave1.png"></div>
            <div class="leaf"><img src="img/leave1.png"></div>



        </div>

        <div class="form_login">
            <form action="LoginServlet" method="post">
                <h1 class="login_heading">Login</h1>
                <p class="text-danger">${error}</p>
                <lable class="login_text">Full Name</lable>
                <input value="" type="text"  class="login_input" name="username">
                <lable class="login_text">Password</lable>
                <input value="" type="password"  class="login_input" name="password">
                <input type="checkbox" name="remember"value="1">Remember Me
                <button class="login_btn" type="submit">Login</button>
                <p class="login_already">
                    <span>Do not have an account ? <a href="register.jsp" class="login-btn-register">Register</a></span>
                </p>
            </form>
        </div> 
    </body>
</html>
