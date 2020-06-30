<jsp:include page="/includes/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section class="content">
    <div class="leftcolumn">
        <div class="card">
            <h2>${title}</h2>
            <h5>${dateCreated}</h5>
            <p id="postContent_post">${content}</p>
        </div>

        <div style="text-align:left;margin-left: 20px">
            <h2>Comments</h2>
            <div class="column">
                <form action="#" method="get" onsubmit="insertMessage();return false">
                    <input type="text" id="fname" name="firstname" placeholder="Your first name.."><br>
                    <input type="text" id="lname" name="lastname" placeholder="Your last name.."><br>
                    <input type="email" id="email" name="email" placeholder="Your Email.."><br>

                    <label for="message">Message</label><br>
                    <textarea id="message" name="message" placeholder="Write something.." style="height:70px;width: 60%"></textarea><br>
                    <input type="submit" value="Submit">
                </form>
            </div>
        </div>
    </div>
</section>

<jsp:include page="/includes/asideright.jsp" />
<jsp:include page="/includes/footer.jsp" />
