@import exercise.dto.posts.PostsPage
@import exercise.model.Post
@import exercise.util.NamedRoutes

@param PostsPage page

@template.layout.page(content = @`
    @if(page.getPosts().isEmpty())
        <p>Posts are empty</p>
    @else
        @for(Post post: page.getPosts())
            <div>
                <a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a>
            </div>
        @endfor
    @endif

    <div>
        <a href="${NamedRoutes.buildPostPath()}">Add new post</a>
    </div>


`, page = page)
