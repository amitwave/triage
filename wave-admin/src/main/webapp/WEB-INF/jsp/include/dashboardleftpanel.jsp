<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
<head lang="en">
    <meta charset="UTF-8">
    <style>
        #nav {
            line-height:30px;
            background-color:#eeeeee;
            height:300px;
            width:100px;
            float:left;
            padding:5px;
        }
    </style>
</head>
<body>
<div id="nav">
    <a href="../referral" target="middlepanel">Create referrals</a> <br>
    <a href="../referrallist?type=new" target="middlepanel">New referrals</a> <br>
    <a href="../referrallist?type=claimed" target="middlepanel">Claimed referrals</a> <br>
    <a href="../referrallist?type=validated" target="middlepanel">Validated referrals</a> <br>
    <a href="../referrallist?type=incomplete" target="middlepanel">Incomplete referrals</a> <br>
</div>
</body>
</html>