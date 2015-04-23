<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <style>
        table{
            border:1px solid black;
            border-collapse:collapse;
        }
        th{
            border:1px solid black;
        }
        td{
            border:1px solid blue;
        }
    </style>
</head>
<body>

<table>
    <tr>
        <td>Page: </td>
    <c:forEach var="page" items="${paginations.pageLinks}">
        <td>
            <a href="referrallistview?type=${type}&page=${page.page}">${page.page}</a>
        </td>
    </c:forEach>
    </tr>
</table>

<table border="1" width="90%">
    <tr>
        <th width="10%">UBRN</th>
        <th width="30%">Description</th>
        <th width="10%">Type</th>
        <th width="10%">NHS Number</th>
        <th width="10%">STATUS</th>
        <th width="10%">Checkout </th>
        <th width="10%"> Validate</th>
        <th width="10%">Release </th>
        <th width="10%"> </th>
    </tr>
    <c:forEach var="referral" items="${referrals}">

        <tr >
            <td>${referral.ubrn}</td>
            <td>${referral.description}</td>
            <td>${referral.type}</td>
            <td>${referral.patient.nhsNumber}</td>
            <td>${referral.status}</td>

            <c:set var="status" scope="page" value="${referral.status}"/>
            <c:set var="viewType" scope="page" value="${viewType}"/>

            <td>
                <c:if test="${status eq 'NEW'}">
                <form:form method="post" action="referral/checkout">
                    <input type="hidden" name="id" value="${referral.id}">
                    <input type="hidden" name="processId" value="${referral.processId}">
                    <input type="submit" value="Checkout" />
                </form:form>
                </c:if>
            </td>
            <td>
                <c:if test="${status eq 'NEW'}">
                <form:form method="post" action="referral/checkout/validate">
                    <input type="hidden" name="id" value="${referral.id}">
                    <input type="hidden" name="processId" value="${referral.processId}">
                    <input type="submit" value="Checkout and Validate" />
                </form:form>
                </c:if>
            </td>
            <td>
                <c:if test="${viewType eq 'CHECKOUT'}">
                    <form:form method="post" action="referral/release">
                        <input type="hidden" name="id" value="${referral.id}">
                        <input type="hidden" name="processId" value="${referral.processId}">
                        <input type="submit" value="Release" />
                    </form:form>
                </c:if>
            </td>



                <td>
                    <c:if test="${status eq 'CHECKOUT' or status eq 'UPDATE'}"> <a href="referral?referralId=${referral.id}"></c:if>
                        Edit
                     <c:if test="${status eq 'CHECKOUT' or status eq 'UPDATE'}"></a></c:if>
                </td>


        </tr>
    </c:forEach>
</table>
</body>
</html>