<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/custom.css" rel="stylesheet">
    <link href="/css/font-awesome.min.css" rel="stylesheet">

    <script src="/js/jquery.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/ckeditor.js"></script>
</head>
<body>
<%@ include file="include/header.jsp" %>
<div class="container main-container">
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <div class="col-sm-3 assignment-blog-preview" style="padding: 0 0 0 0;">
            <button class="btn btn-primary" data-toggle="modal" data-target="#myModalNorm">Create a post</button>
        </div>
    </sec:authorize>
    <%@ include file="include/blogs.jsp" %>
</div>
<!-- Modal -->
<%@ include file="include/blogModal.jsp" %>
<script>
    // Replace the <textarea id="editor1"> with a CKEditor
    // instance, using default configuration.
    CKEDITOR.replace('editor1');

    $(document).ready(function () {

        // Attach Button click event listener
        $(".blogEditor").click(function(){
            var blogId = $(this).attr('blogId');
            var elementId = $(this).attr('id');
            populateModalData(blogId);
            // show Modal
            $('#myModalNorm').modal('show');
        });

        function populateModalData(blogId) {
            var postId= 'post-'+blogId;
            $('#blogTitle').val(
                    $('#'+postId+'').find('.title').text().trim());
            $('#blogTitle').attr('readonly','readonly');
            $('#myModalNorm').find('form').append('<input type="hidden" name="blogId" value="'+blogId+'">');
        }
    });
</script>
</body>
</html>