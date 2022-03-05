<html>
    <body>
        <%--get name from FORM --%>
        <%--<h2>Dear ${param.employeeName}, you are welcome</h2>--%>
        <h2> Dear ${employee.name} ${employee.surname}, your salary is ${employee.salary}</h2> <%--from model--%>
        <h2>Your department is ${employee.department}</h2>
    </body>
</html>
