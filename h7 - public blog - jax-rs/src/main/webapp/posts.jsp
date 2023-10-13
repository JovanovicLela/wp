<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Posts</title>
    <%@include file="styles.jsp"%>
</head>
<body>
<%@ include file="header.jsp" %>


<div class="container">
    <div id="main"></div>
</div>

<script>
    fetch('/api/posts', {
        method: 'GET'
    }).then(response => {
        return response.json();
    }).then(posts => {
        const mainDiv = document.getElementById('main')
        const allPosts = document.createElement('h1');
        allPosts.innerText = 'Objavljeni postovi'
        mainDiv.appendChild(document.createElement('br'))
        mainDiv.appendChild(document.createElement('br'))
        mainDiv.appendChild(allPosts)
        mainDiv.appendChild(document.createElement('br'))
        for (const post of posts) {
            makePostCard(post)
        }
        const btnNewPost = document.createElement('button');
        btnNewPost.innerText = 'New post'
        btnNewPost.classList.add('btn', 'btn-primary')
        btnNewPost.style.marginLeft = '10px'
        btnNewPost.onclick = ()=>newPostForm()
        mainDiv.appendChild(btnNewPost);
        mainDiv.appendChild(document.createElement('br'))

    })

    function newPostForm() {
        const mainDiv = document.getElementById('main');
        mainDiv.innerHTML = '';
        const newForm = document.createElement('form');
        newForm.method = 'POST'

        const authorDiv = document.createElement('div');
        authorDiv.className = 'form-group'
        const lblAuthor = document.createElement('label');
        lblAuthor.innerText = 'Author'
        const inputAuthor = document.createElement('input')
        inputAuthor.type = 'text'
        inputAuthor.className='form-control'
        inputAuthor.id = 'author'
        inputAuthor.name = 'author'
        inputAuthor.placeholder = 'Author'
        inputAuthor.required = true
        authorDiv.appendChild(lblAuthor);
        authorDiv.appendChild(inputAuthor);
        newForm.appendChild(authorDiv)

        const titleDiv = document.createElement('div');
        titleDiv.className = 'form-group'
        const lblTitle = document.createElement('label');
        lblTitle.innerText = 'Title'
        const inputTitle = document.createElement('input')
        inputTitle.type = 'text'
        inputTitle.className='form-control'
        inputTitle.id = 'title'
        inputTitle.name = 'title'
        inputTitle.placeholder = 'Enter a title'
        inputTitle.required = true
        titleDiv.appendChild(lblTitle);
        titleDiv.appendChild(inputTitle);
        newForm.appendChild(titleDiv)

        const contentDiv = document.createElement('div');
        contentDiv.className = 'form-group'
        const lblContent = document.createElement('label');
        lblContent.innerText = 'Content'
        const txtAreaContent = document.createElement('textarea')
        txtAreaContent.type = 'text'
        txtAreaContent.className='form-control'
        txtAreaContent.rows = 7
        txtAreaContent.cols = 18
        txtAreaContent.id = 'content'
        txtAreaContent.name = 'content'
        txtAreaContent.placeholder = 'Enter a content'
        contentDiv.appendChild(lblContent);
        contentDiv.appendChild(txtAreaContent);
        newForm.appendChild(contentDiv)

        const newPostButton = document.createElement('button');
        newPostButton.innerText = 'Save post'
        newPostButton.classList.add('btn', 'btn-primary')
        newPostButton.type = 'button'
        newPostButton.style.marginLeft = '10px'
        newPostButton.onclick = ()=>savePost()
        newForm.appendChild(newPostButton)
        mainDiv.appendChild(newForm)
    }
    //------------------------------------------------

    function makePostCard(post) {
        const mainDiv = document.getElementById('main');
        const cardDiv = document.createElement('div');
        cardDiv.className = 'card';
        const cardBody = document.createElement('div');
        cardBody.className = 'card-body';
        const postTitle = document.createElement('h3');
        postTitle.className = 'card-title';
        postTitle.innerText = post.title;
        const postContent = document.createElement('p');
        postContent.className = 'card-cont';
        postContent.innerText = post.content;
        const postHref = document.createElement('a');
        postHref.innerText = 'Opsirnije...';
        postHref.style.color = "#6262ff";

        postHref.onclick = ()=>postCommentsForm(post);
        mainDiv.appendChild(document.createElement('br'))

        cardBody.appendChild(postTitle);
        cardBody.appendChild(postContent);
        cardBody.appendChild(postHref);
        cardBody.appendChild(document.createElement('br'));
        cardDiv.appendChild(cardBody);
        mainDiv.appendChild(cardDiv);
        mainDiv.appendChild(document.createElement('br'))

    }

    function postCommentsForm(post) {
        const mainDiv = document.getElementById('main');
        mainDiv.innerHTML = '';

        const title = document.createElement('h2')
        title.innerText = post.title
        const postDate = document.createElement('h5')
        postDate.innerText = new Date(post.postdate)
        const author = document.createElement('h6')
        author.innerText = post.author
        const content = document.createElement('p')
        content.innerText = post.content
        mainDiv.appendChild(title)
        mainDiv.appendChild(postDate)
        mainDiv.appendChild(author)
        mainDiv.appendChild(content)
        mainDiv.appendChild(document.createElement('br'))
        const newComment = document.createElement('h3')
        newComment.innerText = 'New comment'
        mainDiv.appendChild(newComment)
        const newCommentForm = document.createElement('form')
        newCommentForm.method = 'POST'

        const divName = document.createElement('div');
        divName.className = 'form-group'
        const lblName = document.createElement('label');
        lblName.innerText = 'Name'
        const inputName = document.createElement('input')
        inputName.type = 'text'
        inputName.className = 'form-control'
        inputName.id = 'name'
        inputName.name = 'name'
        inputName.placeholder = 'Enter your name'
        inputName.required = true
        divName.appendChild(lblName);
        divName.appendChild(inputName);
        newCommentForm.appendChild(divName)

        const divComment = document.createElement('div');
        divComment.className = 'form-group'
        const lblComment = document.createElement('label');
        lblComment.innerText = 'Comment'
        const inputCommment = document.createElement('input')
        inputCommment.type = 'text'
        inputCommment.className = 'form-control'
        inputCommment.id = 'comment'
        inputCommment.name = 'comment'
        inputCommment.placeholder = 'Enter a comment'
        inputCommment.required = true
        divComment.appendChild(lblComment);
        divComment.appendChild(inputCommment);
        newCommentForm.appendChild(divComment)

        const btnNewComment = document.createElement('button');
        btnNewComment.innerText = 'Comment'
        btnNewComment.classList.add('btn', 'btn-primary')
        btnNewComment.type = 'button'
        btnNewComment.style.marginLeft = '10px'
        btnNewComment.onclick = () => saveComment(post.postID)
        newCommentForm.appendChild(btnNewComment)

        mainDiv.appendChild(newCommentForm)

        mainDiv.appendChild(document.createElement('br'))
        mainDiv.appendChild(document.createElement('br'))

        const allComments = document.createElement('h3')
        allComments.innerText = 'Comments'
        mainDiv.appendChild(allComments)
        for (const comment of post.comments) {
            const commentName = document.createElement('h5')
            commentName.innerText = comment.author
            mainDiv.appendChild(commentName)
            const commentNew = document.createElement('h6')
            commentNew.innerText = comment.content
            mainDiv.appendChild(commentNew)
            mainDiv.appendChild(document.createElement('br'))
        }

        mainDiv.appendChild(document.createElement('hr'))

    }

    // --------------------------------------------------

    function savePost() {

        const author = document.getElementById('author').value
        const title = document.getElementById('title').value
        const content = document.getElementById('content').value
        fetch('api/posts', {
            method: 'POST',
            headers:{
                'Content-Type':'application/json'
            },
            body: JSON.stringify({
                author: author,
                title: title,
                content: content
            })
        }).then(post=> {
                makePostCard(post)
                console.log(post)
                window.location.reload()
            }
        )
    }
    function saveComment(postID) {
        const mainDiv = document.getElementById('main');
        const name = document.getElementById('name').value
        const comment = document.getElementById('comment').value
        fetch('api/posts/'+postID+'/comments', {
            method: 'POST',
            headers:{
                'Content-Type':'application/json'
            },
            body: JSON.stringify({
                author: name,
                content: comment
            })
        }).then(response=>response.json()
        ).then(comment=>{
            const commentName = document.createElement('h5')
            commentName.innerText = comment.author
            mainDiv.appendChild(commentName)
            const commentContent = document.createElement('h6')
            commentContent.innerText = comment.content
            mainDiv.appendChild(commentContent)
        })

    }



</script>
</body>
</html>