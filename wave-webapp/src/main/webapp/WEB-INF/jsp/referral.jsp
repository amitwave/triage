<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
    <form method=post>
        <input type="hidden" name="id" value=${referralCommand.id}>
    <table>

    <tr >
       <td>UBRN:</td>
       <td><input type="text" name="ubrn" value=${referralCommand.ubrn}></input></td>
    </tr>
    <tr>
       <td>Description:</td>
       <td><input type="text" name="description" value=${referralCommand.description}></input></td>
    </tr>
        <tr>
            <td>Type:</td>
            <td><input type="text" name="type" value=${referralCommand.type}></input></td>
        </tr>


        <tr >
            Patient Details:
            <td>NHS:</td>
            <td><input type="text" name="patient.nhsNumber" value=${referralCommand.patient.nhsNumber}></input></td>
        </tr>


    </table>

    <input type="submit" />
    </form>
</body>
</html>