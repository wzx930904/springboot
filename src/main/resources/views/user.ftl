<html>
    <head>

    </head>
    <body>
        <table align="center">
            <tr>
                <th>id</th>
                <th>userName</th>
                <th>password</th>
                <th>gender</th>
            </tr>
            [#list users as user]
                <tr>
                    <td align="center">${user.id}</td>
                    <td align="center">${user.userName}</td>
                    <td align="center">${user.password}</td>
                    [#if user.gender == 1]
                        <td align="center">男</td>
                    [#else]
                        <td align="center">女</td>
                    [/#if]
                </tr>
            [/#list]
        </table>
    </body>

</html>