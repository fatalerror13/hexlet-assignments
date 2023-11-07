@import exercise.dto.users.UsersPage
@import exercise.model.User

@param UsersPage page

@template.layout.page(
content = @`
    <form method="get">
        <label for="term">
            <div>Search by username</div>
            <input type="text" name="term" id="term" value="${page.getTerm()}">
            <input type="submit" value="Search">
        </label>
    </form>


        @if(page.getUsers().isEmpty())
            <p>Users not found</p>
        @else
            <ul>
                @for(User user : page.getUsers())
                    <li>${user.getFirstName()} ${user.getLastName()}</li>
                @endfor
            </ul>
        @endif

`
)
