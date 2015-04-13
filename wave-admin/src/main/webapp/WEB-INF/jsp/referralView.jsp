<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>

        <input type="hidden" name="id" value=${referralCommand.id}>
    <table border="1">

    <tr >
       <td>UBRN:</td>
       <td>${referralCommand.ubrn}</td>
    </tr>
    <tr>
       <td>Description:</td>
       <td>${referralCommand.description}</td>
    </tr>
        <tr>
            <td>Type:</td>
            <td>${referralCommand.type}</td>
        </tr>


        <tr >
            Patient Details:
            <td>NHS:</td>
            <td>${referralCommand.patient.nhsNumber}</td>
        </tr>


        <tr>
            <td><a href="../dashboard">Dashboard</a> </td>
        </tr>
    </table>




</body>
</html>