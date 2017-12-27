<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="ui" %>

<portlet:defineObjects />

<portlet:actionURL var="myaction" name="myActionMethod">
</portlet:actionURL>

<ui:error key="name.errorMsg.missing" message="Invalid name" />
<ui:error key="email.errorMsg.missing" message="Invalid email" />
<ui:error key="number.errorMsg.missing" message="Invalid number" />

<b>Validation portlet</b>

<form action="${myaction}" method="post">
	<table>
		<tr>
			<td>Name : </td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>Number : </td>
			<td><input type="text" name="number"></td>
		</tr>
		<tr>
			<td>Email : </td>
			<td><input type="text" name="email"></td>
		</tr>
		<tr>
			<td><input type="submit"></td>
		</tr>
	</table>
</form>
