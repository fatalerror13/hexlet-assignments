@import exercise.dto.posts.PostsPage
@import exercise.model.Post
@import exercise.util.NamedRoutes
@param PostsPage page

@template.layout.page(content = @`
    @if(page.getPosts().isEmpty())
        <p>Posts are empty</p>
    @endif

    <ul>
        @for(Post post: page.getPosts())
            <li><a href="${NamedRoutes.post(post.getId())}">${post.getName()}</a></li>
        @endfor
    </ul>

    <div>
        @if(page.isHasPrev())
            <a href="${NamedRoutes.posts()}?page=${page.getPage() - 1}">Prev</a>
        @endif
        @if(page.isHasNext())
            <a href="${NamedRoutes.posts()}?page=${page.getPage() + 1}">Next</a>
        @endif
    </div>
`)

