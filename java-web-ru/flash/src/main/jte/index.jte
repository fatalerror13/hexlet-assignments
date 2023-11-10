@import exercise.dto.BasePage
@import exercise.util.NamedRoutes

@param BasePage page = null

@template.layout.page(
    content = @`
        <h2>Welcome to Hexlet</h2>
        <ul>
            <li><a href="${NamedRoutes.postsPath()}">Posts</a></li>
        </ul>
    `, page = page
)
