<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<portlet:actionURL var="myaction">
</portlet:actionURL>

<b>First Generic portlet</b>

<form action="${myaction}" method="post">
	Name : <input type="text" name="name">
	<input type="submit">
</form>