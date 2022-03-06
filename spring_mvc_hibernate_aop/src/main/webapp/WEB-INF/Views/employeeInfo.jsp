<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE>
<html>
    <body>
        <h2>Employee Info</h2>
        <br>
    <form:form action="saveEmployee" modelAttribute="employee">
        <form:hidden path="id"/>
        <form:input placeholder = "name" path="name"/>
        <br><br>
        <form:input placeholder = "Surame" path="surname"/>
        <br><br>
        <form:input placeholder = "Department" path="department"/>
        <br><br>
        <form:input placeholder = "Salary" path="salary"/>
        <br><br>
        <input type="submit" value="OK">
    </form:form>
    </body>
</html>
