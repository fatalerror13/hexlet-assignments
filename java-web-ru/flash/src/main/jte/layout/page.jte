@import gg.jte.Content
@import exercise.dto.BasePage

@param Content content
@param BasePage page

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
@if(page != null && page.getFlash() != null)
    <p style="color:green;">${page.getFlash()}</p>
@endif

<div class="content">${content}</div>
</body>
</html>
