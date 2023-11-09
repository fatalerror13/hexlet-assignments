@import exercise.dto.MainPage
@import exercise.util.NamedRoutes
@param MainPage page

@template.layout.page(content = @`
    @if(page.getName() != null)
        <div>Hello, ${page.getName()}</div>
        <a href="${NamedRoutes.logoutPath()}">Выйти</a>
    @else
        <a href="${NamedRoutes.loginPath()}">Войти</a>
    @endif
`)
