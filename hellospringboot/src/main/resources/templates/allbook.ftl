<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理页面</title>
</head>
<body>
    <table>
        <tr>
            <th>编号</th>
            <th>图书名称</th>
            <th>操作</th>
        </tr>
        <#list bookList as book>     
        <tr>     
            <td>${book.ID}</td>     
            <td>${book.name}</td>  
            <td>
                <a href="/book-sys/preUpdate?ID=${book.ID}">修改</a>
                <a href="/book-sys/delete?ID=${book.ID}">删除</a>
            </td>
        </tr>  
       </#list>
       <a href="/bookadd.html">添加图书</a>  
    </table>  
</body>
</html>