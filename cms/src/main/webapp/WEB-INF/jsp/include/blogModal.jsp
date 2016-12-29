<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: M1038226
  Date: 12/24/2016
  Time: 4:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="modal fade" id="myModalNorm" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <!-- Modal Header -->
            <div class="modal-header">
                <button type="button" class="close"
                        data-dismiss="modal">
                    <span aria-hidden="true">&times;</span>
                    <span class="sr-only">Close</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    Create a blog
                </h4>
            </div>
            <form:form role="form" action="submitBlog" modelAttribute="blogForm" method="post" enctype="multipart/form-data">
            <!-- Modal Body -->
            <div class="modal-body">
                    <div class="form-group">
                        <label for="blogTitle">Title</label>
                        <form:input path="title" type="text" class="form-control"
                                    id="blogTitle" placeholder="Enter Title" required="required"/>
                    </div>
                    <div class="form-group">
                        <label for="description">Blog Description</label>
                            <form:textarea path="blogContent" name="editor1" id="editor1" rows="10" cols="80" placeholder="Type your Content" required="required"/>
                    </div>
                    <div class="form-group">
                        <label for="multimedia">Multimedia</label>
                        <input type="file" name="file" accept="video/mp4,image/*" required="required"/>
                    </div>
            </div>

            <!-- Modal Footer -->
            <div class="modal-footer">
                <button type="button" class="btn btn-default"
                        data-dismiss="modal">
                    Close
                </button>
                <button type="submit" class="btn btn-primary">
                    Submit
                </button>
            </div>
            </form:form>
        </div>
    </div>
</div>