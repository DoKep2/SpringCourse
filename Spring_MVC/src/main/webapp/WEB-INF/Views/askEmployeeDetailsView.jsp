<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <body>
    <h2>Enter your details</h2>

    <br>
    <br>
        <form:form action="showDetails" modelAttribute="employee">
            <form:input placeholder="name" path="name"/>
            <form:errors path="name"/>
            <br><br>
            <form:input placeholder="surname" path="surname"/>
            <form:errors path="surname"/>
            <br><br>
            <form:input placeholder="salary" path="salary"/>
            <br><br>
            <form:select path="department">
                <%--<form:option value="Information Techology" label="IT"/>
                <form:option value="Human Resourses" label="HR"/>
                <form:option value="Sales" label="Sales"/>--%>
                <form:options items="${employee.departments}"/>
            </form:select>
            <br><br>

            <input type="submit" value="OK">
        </form:form>
    </body>
</html>
