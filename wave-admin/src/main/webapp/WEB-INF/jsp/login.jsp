<html>
<body>
    <form method="post" action="login">

    <table>
    <tr>
       <td>Name:</td>
       <td><input type="text" name="name" value=${user.name}></input></td>
    </tr>
    <tr>
       <td>Password:</td>
       <td><input type="text" name="password" value=${user.password}></input></td>
    </tr>
    </table>

    <input type="submit" />
    </form>
</body>
</html>