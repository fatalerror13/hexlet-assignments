@import exercise.dto.articles.NewArticlePage

@param NewArticlePage page

@template.layout.page(
content = @`
    @if(page.getErrors() != null)
        <ul>
            @for(var validator : page.getErrors().values())
                @for(var error : validator)
                    <li>${error.getMessage()}</li>
                @endfor
            @endfor
        </ul>
    @endif

    <form action="/articles" method="post">
        <div>
            <label for="title">
                title
                <input type="text" id="title" name="title" value="${page.getTitle()}">
            </label>
            <label for="content">
                content
                <textarea id="content" name="content">${page.getContent()}</textarea>
            </label>

            <input type="submit" value="Create">
        </div>
    </form>
`
)

