<!DOCTYPE html>
<html>

<head>
    <style>
        #header {
            background-color:black;
            color:white;
            text-align:center;
            padding:5px;
        }
        #nav {
            line-height:30px;
            background-color:#eeeeee;
            height:300px;
            width:100px;
            float:left;
            padding:5px;
        }
        #section {
            width:350px;
            float:left;
            padding:10px;
        }
        #footer {
            background-color:black;
            color:white;
            clear:both;
            text-align:center;
            padding:5px;
        }
    </style>
</head>

<body>

<div id="header">
    <h1>Dashboard</h1>
</div>

<div id="nav">
    <a href="referrallist?type=new">New referrals</a> <br>
    <a href="referrallist?type=claimed">Claimed referrals</a> <br>
    <a href="referrallist?type=validated">Validated referrals</a> <br>
    <a href="referrallist?type=incomplete">Incomplete referrals</a> <br>
</div>

<div id="section">

    <jsp:include page="include/referrallistview.jsp"></jsp:include>

</div>

<div id="footer">
    Copyright © ******
</div>

</body>
</html>
