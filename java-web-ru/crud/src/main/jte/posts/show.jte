@import exercise.dto.posts.PostPage
@import exercise.util.NamedRoutes

@param PostPage page

@template.layout.page(content = @`
    <h2>${page.getPost().getName()}</h2>
    <div>
        <p>${page.getPost().getBody()}</p>
    </div>
    <a href="${NamedRoutes.posts()}">Все посты</a>
`)
    
