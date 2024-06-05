<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>blog</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>
<%@ include file="../layout/header.jsp"%>

<div class="container">
	<form action="/action_page.php">
		<div class="form-group">
			<label for="userName">UserName</label> <input type="text" class="form-control" placeholder="username" id="username">
		</div>
		<div class="form-group">
			<label for="email">Email</label> <input type="email" class="form-control" placeholder="email" id="email">
		</div>
		<div class="form-group">
			<label for="pwd">Password</label> <input type="password" class="form-control" placeholder="password" id="password">
		</div>
	</form>
	<!---id로 해시태ㅡ를 전달해야함-->
	<!-- form 안에 있을경우 input 버튼에 포커스가 있을떄 엔터를 누르면 자동 서브밋 동작을 함. 그래서 밖으로 빼준다. -->
	<button id="btn-save" class="btn btn-primary">회원가입</button>
	<script src="/blog/js/user.js"></script>
</div>

<%@ include file="../layout/footer.jsp"%>
</body>
</html>