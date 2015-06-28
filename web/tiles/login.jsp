<script type="text/javascript">
    $(document).ready( function()
    {
        document.f.j_username.focus();
    });
</script>

<div class="container top-3padded col-md-4 col-md-offset-4">
    <div class="panel panel-info">
        <div class="panel-heading">Administrator Login</div>
        <div class="panel-body">
            <c:if test="${param.error != null}">
                <div class="alert alert-danger">
                    <p>Your login credentials were entered incorrectly. Please try again.</p>
                </div>
            </c:if>
            <form name="f" action="${pageContext.request.contextPath}/j_spring_security_check" method="POST">
                <div class="form-group">
                    <label for="j_username">Username</label>
                    <input type="text" name="j_username" id="j_username" value="" class="form-control">
                </div>
                <div class="form-group">
                    <label for="j_password">Password</label>
                    <input type="password" name="j_password" id="j_password" value="" class="form-control">
                </div>
                <div class="form-group">
                    <label for="rememberMe">Remember Me</label>
                    <input id="rememberMe" type="checkbox" name="_spring_security_remember_me" checked="true"/>
                </div>
                <input name="submit" type="submit" value="Login" class="btn btn-primary"/>
            </form>
        </div>
    </div>
</div>
