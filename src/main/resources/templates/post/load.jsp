<%@page import="java.util.ArrayList"%>
<%@page import="com.sherwin.sherwinblog.data.Post"%>
<%@page import="com.sherwin.sherwinblog.data.PostDB"%>
<jsp:include page="/includes/header.jsp" />

<section class="content">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <div class="leftcolumn">
        <c:forEach var="item" items="${PostDB.select()}">
            <div class="card">
                <h2>${item.id}</h2>
                <h5>Title description, Dec 7, 2017</h5>
                <div class="fakeimg" style="height:200px;">Image</div>
                <p id="message1">${item.title}</p>
            </div>
        </c:forEach>

    </div>
</section>

<jsp:include page="/includes/asideright.jsp" />
<jsp:include page="/includes/footer.jsp" />
