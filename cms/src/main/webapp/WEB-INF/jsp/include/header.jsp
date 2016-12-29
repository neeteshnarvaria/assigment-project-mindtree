<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">Mindtree-Blog</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <c:choose>
                        <c:when test="${empty pageContext.request.userPrincipal.name}">
                            <a href="/login" role="button" aria-haspopup="true"
                               aria-expanded="false">Login</a>
                        </c:when>
                        <c:otherwise>
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                               aria-expanded="false"><c:out value="${pageContext.request.userPrincipal.name}"/><span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="javascript:formSubmit()"> Logout</a>
                                    <form action="/logout" method="post" id="logoutForm">
                                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                    </form>
                                </li>
                            </ul>
                        </c:otherwise>
                    </c:choose>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<script>
    function formSubmit() {
        document.getElementById("logoutForm").submit();
    }
</script>