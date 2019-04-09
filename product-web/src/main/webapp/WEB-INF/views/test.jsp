<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>index</title>
<script type="text/javascript" src="../js/common/vue.min.js"></script>
</head>

<body>
	<div id="app">
		<p>{{ message }}</p>
	</div>
	<script>
		new Vue({
			el : '#app',
			data : {
				message : 'Hello Vue.js!'
			}
		})
	</script>
</body>
</html>
