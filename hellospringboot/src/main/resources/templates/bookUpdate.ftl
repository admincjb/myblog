<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书更新页面</title>
</head>
<body>
<form action="/book-sys/update" method="post">
<input type="hidden" name="ID" value="${bookOne.ID}"/>
图书名称：<input type="text" name="name" value="${bookOne.name}"/><br/>
<input type="submit" value="提交"/>
</form>
</body>
</html>