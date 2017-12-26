<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>

<portlet:defineObjects />

<portlet:actionURL var="myaction" name="myActionMethod">
</portlet:actionURL>

<portlet:renderURL var="myRenderURL">
	<portlet:param name="jspPage" value="/html/firstmvcdemo/greeting.jsp"/>
</portlet:renderURL>

<b>First MVC portlet</b>

<form action="${myaction}" method="post">
	Name : <input type="text" name="name">
	<%-- Name : <input type="text" name="<portlet:namespace/>name" id="<portlet:namespace/>name"> --%>
	<%-- way 2 for handling namespace pro. --%>
	<input type="submit">
</form>

<a href="${myRenderURL}">Click for greetings.</a>

<!-- way 3 for handling namespace pro. -->
<%-- <aui:form action="${myaction}" method="post">
	<aui:input name="name" type="text"></aui:input>
	<aui:button type="submit" name="submit" value="submit"></aui:button>
</aui:form> --%>