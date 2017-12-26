<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<portlet:actionURL var="myaction" name="myActionMethod">
</portlet:actionURL>

<portlet:renderURL var="myRenderURL">
	<portlet:param name="jspPage" value="/html/firstmvcdemo/greeting.jsp"/>
</portlet:renderURL>

<b>First MVC portlet</b>

<form action="${myaction}" method="post">
	Name : <input type="text" name="name">
	<input type="submit">
</form>

<a href="${myRenderURL}">Click for greetings.</a>
