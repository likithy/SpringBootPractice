<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<h2>
Add new Todo !!!
</h2>
<br>
<div class="container">
<form:form class="col-form-label" method="post" modelAttribute="toDo">
    <fieldset class="mb-3">
        <form:label path="description">Description :</form:label>
        <form:input name="description" type="text" class="input-group" required="required" path="description"/>
        <form:errors path="description" cssClass="text-bg-danger"/>
    </fieldset>
    <fieldset class="mb-3">
        <form:label path="targetDate">Target Date :</form:label>
        <form:input name="targetDate" type="date" class="input-group" required="required" path="targetDate"/>
        <form:errors path="targetDate" cssClass="text-bg-danger"/>
    </fieldset>
    <fieldset>
        <form:label path="done">Done :</form:label>
        <form:checkbox path="done" />
        <form:errors path="done" cssClass="text-bg-danger"/>
    </fieldset>
    <br>
    <input class="btn btn-primary btn-outline" type="submit">
</form:form>
</div>
<script type="text/javascript">
$('#targetDate').datepicker({
    format: 'yyyy-mm-dd',
    startDate: '-3d'
});
</script>
<%@ include file="common/footer.jspf" %>
