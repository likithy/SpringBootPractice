<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<h2>
Please check all your To do's !!!
</h2>
<hr>
<br>
<div class="container">
<table class="table table-bordered">
    <thead class="table-header table-dark">
    <tr>
        <th class="table-primary">Description</th>
        <th class="table-primary">Target Date</th>
        <th class="table-primary"> Is Done ?</th>
        <th class="table-primary"> Remove To ?</th>
        <th class="table-primary"> UPDATE</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${toDos}" var="todo">
        <tr>
            <td class="table-striped">${todo.description}</td>
            <td class="table-striped">${todo.targetDate}</td>
            <td class="table-striped">${todo.done}</td>
            <td class="table-striped"><a href="delete-todo?id=${todo.id}" class="btn btn-outline-danger">DELETE</a>
            </td>
            <td class="table-striped"><a href="update-todo?id=${todo.id}" class="btn btn-outline-success">UPDATE</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="add-todo" class="btn btn-success">Add To Do</a>
</div>
<%@ include file="common/footer.jspf" %>