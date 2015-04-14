<html>
<body>
    <form method="post" action="/registration">



    <table>
    <tr>
       <td>Name:</td>
       <td><input type="text" name="name" value=${user.name} /></td>
    </tr>
    <tr>
       <td>Email:</td>
       <td><input type="text" name="email" value=${user.email}/></td>
    </tr>
    <tr>
       <td>Password:</td>
       <td><input type="text" name="password" value=${user.password}/></td>
    </tr>
    </table>

    <input type="submit" />
    </form>
</body>
</html>