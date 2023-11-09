@import exercise.dto.LoginPage
@import exercise.util.NamedRoutes
@param LoginPage page

@template.layout.page(content = @`
    <form action="${NamedRoutes.loginPath()}" method="post">
        <input type="text" name="name" placeholder="name" value="${page.getName()}">
        <input type="password" name="password" placeholder="password">
        <input type="submit" value="Login">
    </form>

    @if(page.getError() != null)
        ${page.getError()}
    @endif
`)
