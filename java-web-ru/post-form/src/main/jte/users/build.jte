@template.layout.page(
content = @`
    <form action="/users" method="post">
        <div>
            <label for="firstName">
                firstName
                <input type="text" id="firstName" name="firstName">
            </label>
            <label for="lastName">
                lastName
                <input type="text" id="lastName" name="lastName">
            </label>
            <label for="email">
                email
                <input type="text" id="email" name="email">
            </label>
            <label for="password">
                password
                <input type="password" id="password" name="password">
            </label>
            <label for="passwordConfirm">
                password
                <input type="password" id="passwordConfirm" name="passwordConfirm">
            </label>
            <input type="submit" value="Register">
        </div>
    </form>
`
)

