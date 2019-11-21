<!doctype html>
<html>
<head>
    <link rel="stylesheet" href="../static/css/style.css">
    <title>SigIn</title>
</head>
<body>
<div class="form-style-3">
    <form method="post" action="/login">
        <fieldset>
            <legend>Sign In</legend>
            <#if error??>
                <h1>Неправильный логин или пароль</h1>
            </#if>
            <label for="login"><span>Login <span class="required">*</span></span><input type="text"
                                                                                        class="input-field"
                                                                                        name="login"
                                                                                        value=""/></label>
            <label for="password"><span>Password<span class="required">*</span></span><input type="password"
                                                                                             class="input-field"
                                                                                             name="password"
                                                                                             value=""/></label>
        </fieldset>
        <fieldset>
            <label><span> </span><input type="submit" value="SignIn"/></label>
        </fieldset>
    </form>
    <form action="/signUp">
        <button type="submit">SignUp</button>
    </form>
</div>

</body>
</html>