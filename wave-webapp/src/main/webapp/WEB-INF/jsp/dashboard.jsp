<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>


<a href="referral">Create New Referral</a>
<BR/>
<label>My Claimed Referrals</label>
<table border="1">
    <tr>
        <th>UBRN</th>
        <th>Description</th>
        <th>Type</th>
        <th>NHS</th>
        <th>STATUS</th>
    </tr>
<c:forEach var="referral" items="${claimedReferrals}">


    <tr >

    <td>${referral.ubrn}</td>


    <td>${referral.description}</td>


    <td>${referral.type}</td>


    <td>${referral.patient.nhsNumber}</td>


    <td>${referral.status}</td>



    <c:set var="status" scope="page" value="${referral.status}"/>

    <c:if test="${status eq 'CHECKOUT'}">

        <td><a href="referral?referralId=${referral.id}">EDIT</a> </td>
        <td>
            <form method="post" action="referral/release">
                <input type="hidden" name="id" value="${referral.id}">

                <input type="submit" value="Release" />
            </form>
        </td>

</c:if>
    </c:forEach>

    </table>
<BR/>

<label>New Referrals</label>
<table border="1">
    <tr>
        <th>UBRN</th>
        <th>Description</th>
        <th>Type</th>
        <th>NHS</th>
        <th>STATUS</th>
    </tr>
    <c:forEach var="referral" items="${newReferrals}">


        <tr >

            <td>${referral.ubrn}</td>


            <td>${referral.description}</td>


            <td>${referral.type}</td>


            <td>${referral.patient.nhsNumber}</td>


            <td>${referral.status}</td>

            <td>
            <form method="post" action="referral/checkout">
                <input type="hidden" name="id" value="${referral.id}">

                <input type="submit" value="Checkout" />
            </form>
            </td>

        </tr>

    </c:forEach>

</table>

<BR/>

<label>Validated Referrals</label>
<table border="1">
    <tr>
        <th>UBRN</th>
        <th>Description</th>
        <th>Type</th>
        <th>NHS</th>
        <th>STATUS</th>
    </tr>
    <c:forEach var="referral" items="${validatedReferrals}">

        <tr >

            <td>${referral.ubrn}</td>


            <td>${referral.description}</td>


            <td>${referral.type}</td>


            <td>${referral.patient.nhsNumber}</td>


            <td>${referral.status}</td>

            <td>
            <td><a href="referral/view?referralId=${referral.id}">View</a> </td>
            </td>

        </tr>

    </c:forEach>

</table>


<BR/>

<label>Incomplete Referrals</label>
<table border="1">
    <tr>
        <th>UBRN</th>
        <th>Description</th>
        <th>Type</th>
        <th>NHS</th>
        <th>STATUS</th>
    </tr>
    <c:forEach var="referral" items="${incompleteReferrals}">

        <tr >

            <td>${referral.ubrn}</td>


            <td>${referral.description}</td>


            <td>${referral.type}</td>


            <td>${referral.patient.nhsNumber}</td>


            <td>${referral.status}</td>

            <td>
            <td><a href="referral/view?referralId=${referral.id}">View</a> </td>
            </td>


            <td><a href="referral?referralId=${referral.id}">EDIT</a> </td>
            <td>
                <form method="post" action="referral/release">
                    <input type="hidden" name="id" value="${referral.id}">

                    <input type="submit" value="Release" />
                </form>
            </td>

        </tr>

    </c:forEach>

</table>


</body>
</html>