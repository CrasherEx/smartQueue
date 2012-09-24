<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
	<head>
		<jsp:include page="/WEB-INF/views/externalIncludes/bootsstrapIncludes.jsp" />
		<title>Home</title>
	</head>
	<body>
		<jsp:include page="/WEB-INF/views/bars/topBar.jsp" />
		<div class="container">
			<jsp:include page="/WEB-INF/views/rows/row1/logoAndLogin.jsp" />
			<jsp:include page="/WEB-INF/views/rows/row2/changeCity.jsp" />
			<jsp:include page="/WEB-INF/views/rows/row3/searchBar.jsp" />
			<jsp:include page="/WEB-INF/views/rows/row4/helloWorldAndFavorites.jsp" />
		</div>
	</body>
</html>