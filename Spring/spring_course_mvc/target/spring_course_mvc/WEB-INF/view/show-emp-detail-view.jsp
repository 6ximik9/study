<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<body>

<h2>Dear Employee, you are WELCOME!!!</h2>

<br>
<br>

<%--<h2>Yout name: ${param.employeeName}</h2>--%>

<h2>Your name: ${employee.name}</h2>
<br>
<br>
<h2>Your surname: ${employee.surname}</h2>
<br>
<br>
<h2>Your salary: ${employee.salary}</h2>
<br>
<br>
<h2>Your department: ${employee.department}</h2>
<br>
<br>
<h2>Your car: ${employee.carBrand}</h2>
<br>
<br>
<h2>Language(s):
    <ul>
        <c:forEach var="lang" items="${employee.languages}">
        <li>  ${lang}  </li>
        </c:forEach>

    </ul>
</h2>

<h2>Phone number: ${employee.phoneNumber}</h2>

<h2>Your email: ${employee.email}</h2>

</body>
</html>