<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:choose>
    <c:when test="${!empty blogs}">
        <c:forEach var="blog" items="${blogs}" varStatus="status">
            <div class="col-sm-3 assignment-blog-preview" id="post-${blog.id}">
                <h2 class="title">${blog.title}
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <a href="#" id="edit-${blog.id}" class="blogEditor" blogId="${blog.id}"><i class="fa fa-pencil fa-fw"></i></a>
                        <a href="/deleteBlog/${blog.id}">
                            <i class="fa fa-trash-o"></i></a>
                        </a>
                    </sec:authorize>
                </h2>
                <c:if test="${!empty blog.media.id}">
                    <c:choose>
                        <c:when test="${fn:contains(blog.media.contentType, 'image')}">
                            <img class="preview-img" src="/imageController/${blog.media.id}" />
                        </c:when>
                        <c:otherwise>
                            <video  class="preview-img" controls>
                                <source src="/imageController/${blog.media.id}" type="video/mp4">
                            </video>
                        </c:otherwise>
                    </c:choose>
                </c:if>
                <div class="description">${blog.blogContent}</div>
                <div class="created-by"><a href="/showBlog/${blog.id}">Go to Post =></a></div>
            </div>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
            Please create some posts for users
        </sec:authorize>
        <sec:authorize access="!hasAnyRole('ROLE_ADMIN','ROLE_USER')">
            Please <a href="/login">Login</a> / <a href="/registration">Create an Account</a> and ask admin create some posts for users
        </sec:authorize>
        <sec:authorize access="hasRole('ROLE_USER')">
            Please ask admin create some posts for users
        </sec:authorize>
    </c:otherwise>
</c:choose>