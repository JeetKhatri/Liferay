<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<portlet:defineObjects />

<c:set var="color" value="${color}"></c:set>
<c:choose>
	<c:when test="${color=='blue'}">
		<font color='blue'>you select Blue color</font>
	</c:when>
	<c:when test="${color=='blue'}">
		<font color='blue'>you select Blue color</font>
	</c:when>
	<c:otherwise>
		<font color='black'>you select No color</font>
	</c:otherwise>
</c:choose>
