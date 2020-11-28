<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<table border="1" width="100%" cellpadding="0" cellspacing="0" align="center">
    <tbody>
    <tr>
        <th>id</th>
        <th>用户名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>电话</th>
        <th>时间</th>
    </tr>
    <#list data as user>
        <tr>

            <td>${user.id!}</td>
            <td>${user.name!}</td>
            <td>${user.sex!}</td>
            <td>${user.age!}</td>
            <td>${user.phone!}</td>
            <td>${user.time?number_to_datetime?string("YYYY-MM-dd HH:mm:ss")}</td>
        </tr>
    </#list>
    </tbody>
</table>

</html>
