@import gg.jte.Content

@param Content content

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<p>
    <a href="/">Main</a>
    <a href="/users">Users</a>
</p>
<div class="content">${content}</div>

<footer>
    <p>Thanks for visiting, come again soon!</p>
</footer>
</body>
</html>