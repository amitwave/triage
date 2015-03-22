<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<label>My Claimed Referrals</label>
<table>
<c:forEach var="referral" items="${referrals}">
<tr><td><li> =========== </li></td></tr>
    <tr >
       <td>UBRN:</td>
       <td>${referral.ubrn}</td>
    </tr>
    <tr>
       <td>Description:</td>
       <td>${referral.description}</td>
    </tr>
        <tr>
            <td>Type:</td>
            <td>${referral.type}</td>
        </tr>

        <tr>
            <td>NHS:</td>
            <td>${referral.patient.nhsNumber}></td>
        </tr>

    <tr>
        <td>STATUS:</td>
        <td>${referral.status}</td>
    </tr>

    <tr>

        <form method="post" action="referral/checkout">
            <input type="hidden" name="id" value="${referral.id}">

            <input type="submit" value="Checkout" />
        </form>

        <form method="post" action="referral/checkout/validate">
            <input type="hidden" name="id" value="${referral.id}">

            <input type="submit" value="Checkout and Validate" />
        </form>
    </tr>
    <c:set var="status" scope="page" value="${referral.status}"/>
<c:if test="${status eq 'CHECKOUT' or status eq 'UPDATE'}">
    <tr>
        <td><a href="referral?referralId=${referral.id}">EDIT</a> </td>
    </tr>
</c:if>
    </c:forEach>

    </table>



</body>
</html>