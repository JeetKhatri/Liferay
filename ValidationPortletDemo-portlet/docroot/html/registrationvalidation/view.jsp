<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jst" %>

<portlet:defineObjects />

<portlet:actionURL var="myaction" name="myActionMethod">
</portlet:actionURL>


<jst:if test="${!empty errorList}">
	<ul>
		<jst:forEach items="${errorList }" var="error">
				<li style="color: red" ><jst:out value="${error}" /></li>
		</jst:forEach>
	</ul>
</jst:if>

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
