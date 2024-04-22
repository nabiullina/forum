<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Users</title>
</head>
<body>
<h1>ALL USERS</h1>
<hr>
<form action="/users" method="get" >
    <h3>Поиск пользователя по имени
    </h3>
    <label>
        <input type="text" name="name"/>
        <input type="submit" value="search"/>
    </label>
</form>
<#list users as user>
    <div>
        <p>
            ${user.name}
            ${user.email}
            ${user.password}
        </p>
    </div>
    <#else>
        <h3>Пользователи не найдены</h3>
</#list>


<h2>
    Создать нового пользователя
</h2>
<form action="/user/create" method="post">
    <label>
        <input type="text" name="name"/>
    </label><br>
    <label>
        <input type="text" name="email"/>
    </label><br>
    <label>
        <input type="text" name="password"/>
    </label><br>
    <input type="submit" value="Добавить пользователя">
</form>
</body>
</html>