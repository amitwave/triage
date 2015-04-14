<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head lang="en">
        <style type="text/css">
            ul{
                padding: 0;
                list-style: none;
            }
            ul li{
                float: top;
                width: 100px;
                text-align: center;
                line-height: 21px;
            }
            ul li a{
                display: block;
                padding: 5px 10px;
                color: #333;
                background: #f2f2f2;
                text-decoration: none;
            }
            ul li a:hover{
                color: #fff;
                background: #939393;
            }
            ul li ul{
                display: none;
            }
            ul li:hover ul{
                display: block; /* display the dropdown */
                background: #efeff2;
            }
        </style>

    </head>
    <body>
    <ul>
        <li><a href="#">Home</a></li>
        <li>
            <a href="#">Referrals &#9662;</a>
            <ul>
                <li><a href="../referral" target="mainpage">Create New</a></li>
                <li><a href="../referrallistview?type=new" target="mainpage">New Entries</a></li>
                <li><a href="../referrallistview?type=claimed" target="mainpage">Claimed</a></li>
                <li><a href="../referrallistview?type=validated" target="mainpage">Validated</a></li>
                <li><a href="../referrallistview?type=incomplete" target="mainpage">Incomplete</a></li>
            </ul>
        </li>
        <li><a href="#">Referrers &#9662;</a></li>
    </ul>
    </body>
</html>