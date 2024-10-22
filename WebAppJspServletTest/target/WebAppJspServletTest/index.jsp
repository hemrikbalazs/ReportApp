<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.List"%>
<%@page import="models.Statistic"%>
<head>
    <title>Statistics List</title>
</head>

<html>
    <body>
        <h1>Statistics List</h1>

        <form action="WebAppJspServletTest/" method="get">
            <label for="listSelection">Choose a List (1 or 2)!: </label>
            <input type="number" id="listSelection" name="listSelection" min="1" max="2" required>
            <input type="submit" value="Submit">
        </form>

        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Season</th>
                <th>Lesson Count</th>
                <th>Hours Worked</th>
                <th>Average Student Age</th>
            </tr>
            <%
                List<Statistic> statistics = (List<Statistic>) request.getAttribute("statistics");
                if (statistics != null) {
                    for (Statistic stat : statistics) {
            %>
            <tr>
                <td><%= stat.getFirstName()%></td>
                <td><%= stat.getLastName()%></td>
                <td><%= stat.getSeason()%></td>
                <td><%= stat.getLessonCount()%></td>
                <td><%= stat.getHoursWorked()%></td>
                <td><%= stat.getAverageStudentAge()%></td>
            </tr>
            <%
                }
            } else {
            %>
            <tr>
                <td colspan="6">No statistics available.</td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>
