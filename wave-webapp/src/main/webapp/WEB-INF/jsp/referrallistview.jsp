<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<body>

<table>
    <tr>
        <td>Page: </td>
    <c:forEach var="page" items="${paginations.pageLinks}">
        <td>
            <a href="referrallist?type=${type}&page=${page.page}">${page.page}</a>
        </td>
    </c:forEach>
    </tr>
</table>

<table>
    <tr>
        <th>UBRN</th>
        <th>Description</th>
        <th>Type</th>
        <th>NHS Number</th>
        <th>STATUS</th>
        <th> </th>
        <th> </th>
        <th> </th>
    </tr>
    <c:forEach var="referral" items="${referrals}">

        <tr >
            <td>${referral.ubrn}</td>
            <td>${referral.description}</td>
            <td>${referral.type}</td>
            <td>${referral.patient.nhsNumber}</td>
            <td>${referral.status}</td>
            <c:set var="status" scope="page" value="${referral.status}"/>
            <c:if test="${status eq 'NEW'}">
            <td>

                <form:form method="post" action="referral/checkout">
                    <input type="hidden" name="id" value="${referral.id}">
                    <input type="submit" value="Checkout" />
                </form:form>
            </td>
            <td>
                <form:form method="post" action="referral/checkout/validate">
                    <input type="hidden" name="id" value="${referral.id}">
                    <input type="submit" value="Checkout and Validate" />
                </form:form>
            </td>
            </c:if>
            <td>

                <c:if test="${status eq 'CHECKOUT' or status eq 'UPDATE'}">
                    <a href="referral?referralId=${referral.id}">Edit</a>
                </c:if>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>