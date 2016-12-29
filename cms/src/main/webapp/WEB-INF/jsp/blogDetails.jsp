<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/custom.css" rel="stylesheet">

    <script src="/js/jquery.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/ckeditor.js"></script>
</head>
<body>
<%@ include file="include/header.jsp" %>
<div class="container">
    <div class="blog-container col-sm-7">
        <c:if test="${!empty blog}">
            <h2 class="title">${blog.title}</h2>
            <c:if test="${!empty blog.media.id}">
                <c:choose>
                    <c:when test="${fn:contains(blog.media.contentType, 'image')}">
                        <img class="main-media" src="/imageController/${blog.media.id}"/>
                    </c:when>
                    <c:otherwise>
                        <video class="main-media" controls>
                            <source src="/imageController/${blog.media.id}" type="video/mp4">
                        </video>
                    </c:otherwise>
                </c:choose>
            </c:if>
            <div class="description">${blog.blogContent}</div>
            <span style="display: none" id="blogId">${blog.id}</span>
            <div style="margin-top: 10px;"></div>
            <div style="margin-bottom: 10px;"></div>
            <table class="comment-output" style="border-spacing: 10px;">
                    <span class="commentor" <c:choose>
                        <c:when test="${!empty comments}">
                            style="display: block"
                        </c:when>
                        <c:otherwise>
                            style="display: none"
                        </c:otherwise>
                    </c:choose>>Comments :-<br/></span>
                <c:if test="${!empty comments}">
                    <c:forEach var="comment" items="${comments}" varStatus="status">
                        <tr id="comment-${comment.commentId}">
                            <c:if test="${!empty comment.comment}">
                                <td>${comment.comment}</td>
                                <td></td>
                            </c:if>
                            <c:if test="${!empty comment.userName}">
                                <td>, ${comment.userName}</td>
                                <td></td>
                            </c:if>
                            <c:if test="${!empty comment.creationTime}">
                                <td>, ${comment.creationTime}</td>
                            </c:if>
                        </tr>
                    </c:forEach>
                </c:if>
            </table>
            <div style="margin-top: 10px;"></div>
            <div style="margin-bottom: 10px;"></div>
            <form id="addComments">
                <table>
                    <tr>
                        <td>
                            <input type="text"
                                   name="userName"
                                   id="comment-user"
                                   placeholder="Enter your name or comment anonymously .."
                                    <c:if test="${!empty pageContext.request.userPrincipal.name}">
                                        value="${pageContext.request.userPrincipal.name}"
                                        style="display: none"
                                    </c:if>
                                   style="width: 100%;"/>
                        </td>
                    </tr>
                    <tr>
                        <td><textarea rows="4" cols="50" name="comment" id="user-comment"
                                      placeholder="Type your comments..."></textarea></td>
                    </tr>
                    <tr>
                        <td style="padding: 5px 0 0 305px;">
                            <button type="button" class="btn btn-primary" id="btn-save">add comment</button>
                        </td>
                    </tr>
                </table>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
        </c:if>
        <div style="margin-bottom: 20px;"></div>
    </div>
    <div class="col-sm-5">
        <form method="get">
            <input type="text" placeholder="Search Tweets" id="tweetUser"/>
            <a href="#" class="btn btn-default btn-sm" onclick="loadResult()">search tweets based on user</a>
        </form>
        <ul id="tweets">
        </ul>
    </div>
</div>
</body>
</html>


<script>

    function loadResult() {
        var tweetUser = $('#tweetUser').val();
        $("#tweets").empty();
        $.get('/timeline/tweets/'+tweetUser, function (data) {
            $.each(data, function (i, item) {
                $("#tweets").append('<li style="font-size:9px;">' + item.text + ' at ' + new Date(item.createdAt) + '</li>');
            });
        });
    }

    jQuery(document).ready(
            function ($) {

                $.get("/timeline/tweets/Mindtree_ltd", function (data) {
                    $.each(data, function (i, item) {
                        $("#tweets").append('<li style="font-size:9px;">' + item.text + ' at ' + new Date(item.createdAt) + '</li>');
                    });
                });


                $("#btn-save").click(function (event) {

                    var data = {}
                    data["commentUser"] = $("#comment-user").val();
                    data["userComment"] = $("#user-comment").val();
                    data["blogId"] = parseInt($("#blogId").text());

                    $.ajax({
                        type: "POST",
                        contentType: "application/json",
                        url: "/addComments",
                        data: JSON.stringify(data),
                        dataType: 'json',
                        timeout: 600000,
                        success: function (out) {
                            if (out.blogId == data.blogId) {
                                $('.commentor').css('display', 'block');
                                $(".comment-output").append('<tr id="comment-' + out.commentId + '">' +
                                        '<td>' + out.comment + '</td>' +
                                        '<td>, ' + out.userName + '</td>' +
                                        '<td>, ' + out.creationTime + '</td></tr>');
                            }
                        },
                        error: function (e) {
                            console.log(e.responseJSON);
                        }
                    });


                });

            });
</script>