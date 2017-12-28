<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<portlet:actionURL name="colorSelection" var="color"></portlet:actionURL>

<form action="${color}" method="post">
	<table>
		<tr>
			<td><input type="radio" name="name" value="red" />Red color</td>
			<td><input type="radio" name="name" value="blue" />Blue color</td>
		</tr>
		<tr>
			<td><input type="submit"></td>
		</tr>
	</table>
</form>
