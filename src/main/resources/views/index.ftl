<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>index</title>
</head>

<style>
    td{
        width: 80px;
        text-align: center;
    }
</style>

<body>
<h1>User List</h1>

<table border="1px">
    <tr>
        <td>id</td>
        <td>username</td>
        <td>password</td>
    </tr>
    <#list userList as user>
        <tr>
            <td>${user.id}</td>
            <td>${user.userName}</td>
            <td>${user.userPwd}</td>
        </tr>
    </#list>
</table>
</body>
</html>