<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet" href="/Web_Project/resources/css/main.css">
</head>

<body>
    <div class="wrap">
        <jsp:include page="/include/share_part/header.jsp" flush="false"></jsp:include>

        <div class="container">
            <div class="section">
                <iframe src="/Web_Project/include/iframe/table4.jsp" frameborder="0" width="945" height="850"></iframe>
            </div>
            <jsp:include page="/include/share_part/aside.jsp" flush="false"></jsp:include>

        </div>
        <a style="display:scroll;position:fixed;bottom:50px;right:50px;" href="#" title="맨위로"><img width="70px" height="70px" src="/Web_Project/resources/image/top.PNG"></a>
        

       <jsp:include page="/include/share_part/footer.jsp" flush="false"></jsp:include>
    </div>
    
</body>

</html>