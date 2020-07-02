<jsp:include page="/includes/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section>
<!--    <form action="${pageContext.request.contextPath}/blog" method="post">-->
    <form action="<c:url value='/posts/createPost'/>" method="post">

        <input type="hidden" name="todo" value="create">
        <label>Title</label><br>
        <input type="text" id="title" name="title" placeholder="title" style="width: 100%"><br>
        <label>Content</label><br>
        <textarea id="message" name="content" placeholder="Write something.." 
                  style="height:40vh;width: 100%"></textarea><br>
        <input type="submit" value="Post">
    </form>

</section>

<jsp:include page="/includes/footer.jsp" />