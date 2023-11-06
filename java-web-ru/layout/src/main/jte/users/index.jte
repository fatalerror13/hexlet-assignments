@import exercise.dto.users.UsersPage
@import exercise.model.User
@param UsersPage page

@template.layout.page(content = @`
    <ul>
        @for(User user: page.getUsers())
            <li>${user.getFirstName()} ${user.getLastName()}</li>
        @endfor
    </ul>
`)