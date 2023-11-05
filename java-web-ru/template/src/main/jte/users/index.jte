@import exercise.dto.users.UsersPage
@import exercise.model.User
@param UsersPage page

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>${page.getHeader()}</title>
</head>
<body>
    <h1>${page.getHeader()}</h1>
    @if(page.getUsers().isEmpty())
        <p>Users is empty</p>
    @else
        <ul>
            @for(User user: page.getUsers())
                <li>
                    <a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a>
                    <p>email: ${user.getEmail()}</p>
                </li>
            @endfor
        </ul>
    @endif
</body>
</html>
