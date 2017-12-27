<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jst" %>

<portlet:defineObjects />

<portlet:actionURL var="myaction" name="myActionMethod">
</portlet:actionURL>

<ui:error key="name.errorMsg.missing" message="name.errorMsg.missing" />
<ui:error key="email.errorMsg.missing" message="email.errorMsg.missing" />
<ui:error key="number.errorMsg.missing" message="number.errorMsg.missing" />

<b>Validation portlet</b>

<form action="${myaction}" method="post">
	<table>
		<tr>
			<td>Name : </td>
			<td><input type="text" name="name" value='<jst:out value="${bean.name}" />'></td>
		</tr>
		<tr>
			<td>Number : </td>
			<td><input type="text" name="number" value='<jst:out value="${bean.number}" />'></td>
		</tr>
		<tr>
			<td>Email : </td>
			<td><input type="text" name="email" value='<jst:out value="${bean.email}" />'></td>
		</tr>
		<tr>
			<td><input type="submit"></td>
		</tr>
	</table>
</form>
