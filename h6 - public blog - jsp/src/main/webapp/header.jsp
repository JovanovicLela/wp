<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#">Public Blog</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="<%=application.getContextPath()%>/posts">Pregled svih objava</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<%=application.getContextPath()%>/new-post">Nova objava</a>
            </li>
        </ul>

    </div>
</nav>
