<html>
<style>
    .login{
        color: black;
        background-color: #909000;;
        border: 2px solid darkblue;
        padding: 5px;
        position:absolute;
    }
</style>

<body >
    <form method="post" action="login" class="login">
    <table>
    <tr>
       <td>Name:</td>
       <td><input type="text" name="name" value=${user.name}/></td>
    </tr>
    <tr>
       <td>Password:</td>
       <td><input type="password" name="password" value=${user.password}/>></td>
    </tr>
    </table>

    <input type="submit" />
    <a href="registration">Signup</a>
    </form>

</body>
</html>