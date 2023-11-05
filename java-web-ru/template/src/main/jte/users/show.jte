@import exercise.dto.users.UserPage
@param UserPage page

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
<ul>
    <li>Имя: ${page.getUser().getFirstName()}</li>
    <li>Фамилия: ${page.getUser().getLastName()}</li>
    <li>email: ${page.getUser().getEmail()}</li>
</ul>
</body>
</html>