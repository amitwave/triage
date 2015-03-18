<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<table>
<c:forEach var="referralData" items="${referrals}">
<tr><td><li> =========== </li></td></tr>
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

        <tr>
            <td>NHS:</td>
            <td><input type="text" name="patient.nhsNumber" value=${referralData.patient.nhsNumber}></input></td>
        </tr>

    <tr>
        <td><a href="referral?referralId=${referralData.id}">EDIT</a> </td>
    </tr>

    </c:forEach>

    </table>

</body>
</html>