<html>
<head>
<style>
    body {
        background-color: #67C5F8;
        font-family: "Helvetica Neue", Helvetica, Arial;
        padding-top: 20px;
    }

    .container {
        width: 406px;
        max-width: 406px;
        margin: 0 auto;
    }

    #signup {
        padding: 0px 25px 25px;
        background: #fff;
        box-shadow:
        0px 0px 0px 5px rgba( 255,255,255,0.4 ),
        0px 4px 20px rgba( 0,0,0,0.33 );
        -moz-border-radius: 5px;
        -webkit-border-radius: 5px;
        border-radius: 5px;
        display: table;
        position: static;
    }

    #signup .header {
        margin-bottom: 20px;
    }

    #signup .header h3 {
        color: #333333;
        font-size: 24px;
        font-weight: bold;
        margin-bottom: 5px;
    }

    #signup .header p {
        color: #8f8f8f;
        font-size: 14px;
        font-weight: 300;
    }

    #signup .sep {
        height: 1px;
        background: #e8e8e8;
        width: 406px;
        margin: 0px -25px;
    }

    #signup .inputs {
        margin-top: 25px;
    }

    #signup .inputs label {
        color: #8f8f8f;
        font-size: 12px;
        font-weight: 300;
        letter-spacing: 1px;
        margin-bottom: 7px;
        display: block;
    }

    input::-webkit-input-placeholder {
        color:    #b5b5b5;
    }

    input:-moz-placeholder {
        color:    #b5b5b5;
    }

    #signup .inputs  input[type=password], input[type=text]{
        background: #f5f5f5;
        font-size: 0.8rem;
        -moz-border-radius: 3px;
        -webkit-border-radius: 3px;
        border-radius: 3px;
        border: none;
        padding: 13px 10px;
        width: 330px;
        margin-bottom: 20px;
        box-shadow: inset 0px 2px 3px rgba( 0,0,0,0.1 );
        clear: both;
    }


    #signup .inputs input[type=password]:focus, input[type=text]:focus {
        background: #fff;
        box-shadow: 0px 0px 0px 3px #fff38e, inset 0px 2px 3px rgba( 0,0,0,0.2 ), 0px 5px 5px rgba( 0,0,0,0.15 );
        outline: none;
    }



    #signup .inputs label {
        float: left;
        font-size: 14px;
        font-style: italic;
        margin-right: 30px;
        margin-top: 12px;
    }

    #signup .inputs #submit {
        width: 100%;
        margin-top: 20px;
        padding: 15px 0;
        color: #fff;
        font-size: 14px;
        font-weight: 500;
        letter-spacing: 1px;
        text-align: center;
        text-decoration: none;
        background: -moz-linear-gradient(
                top,
                #b9c5dd 0%,
                #a4b0cb);
        background: -webkit-gradient(
                linear, left top, left bottom,
                from(#b9c5dd),
                to(#a4b0cb));
        -moz-border-radius: 5px;
        -webkit-border-radius: 5px;
        border-radius: 5px;
        border: 1px solid #737b8d;
        -moz-box-shadow:
        0px 5px 5px rgba(000,000,000,0.1),
        inset 0px 1px 0px rgba(255,255,255,0.5);
        -webkit-box-shadow:
        0px 5px 5px rgba(000,000,000,0.1),
        inset 0px 1px 0px rgba(255,255,255,0.5);
        box-shadow:
        0px 5px 5px rgba(000,000,000,0.1),
        inset 0px 1px 0px rgba(255,255,255,0.5);
        text-shadow:
        0px 1px 3px rgba(000,000,000,0.3),
        0px 0px 0px rgba(255,255,255,0);
        display: table;
        position: static;
        clear: both;
    }

    #signup .inputs #submit:hover {
        background: -moz-linear-gradient(
                top,
                #a4b0cb 0%,
                #b9c5dd);
        background: -webkit-gradient(
                linear, left top, left bottom,
                from(#a4b0cb),
                to(#b9c5dd));
    }
</style>
<title>Triage</title>
</head>
<body >
<div class="container">
    <form method="post" action="login" id="signup">
        <div class="header">
            <h3>LogIn</h3>
        </div>
        <div class="sep"></div>
        <div class="inputs">
            <input type="text" name="name" placeholder="User Name" autofocus value=${user.name} >
            <input type="password" name="password" placeholder="Password" autofocus value=${user.password}>
            <input id="submit" type="submit">
            <a href="./registration"><label>Sign up</label></a>
        </div>

    </form>
</div>
</body>
</html>