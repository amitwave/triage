<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
    <form method=post>

    <table>

    <tr >
       <td>UBRN:</td>
       <td><input type="text" name="ubrn" value=${referralData.ubrn}></input></td>
    </tr>
    <tr>
       <td>Description:</td>
       <td><input type="text" name="description" value=${referralData.description}></input></td>
    </tr>
        <tr>
            <td>Type:</td>
            <td><input type="text" name="type" value=${referralData.type}></input></td>
        </tr>


        <tr >
            Patient Details:
            <td>NHS:</td>
            <td><input type="text" name="patient.nhsNumber" value=${referralData.patient.nhsNumber}></input></td>
        </tr>


    </table>

    <input type="submit" />
    </form>
</body>
</html>