<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="description" content="Male_Fashion Template">
    <meta name="keywords" content="Male_Fashion, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Home Page</title>
    <jsp:include page="include/css-page.jsp"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.getContextPath()}/webjars/bootstrap/5.1.3/css/bootstrap.min.css" />
    <script type="text/javascript" src="${pageContext.request.getContextPath()}/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.getContextPath()}/resources/css/styleHome.css">
    <script type="text/javascript" src="${pageContext.request.getContextPath()}/resources/js/my_time_js.js"></script>
</head>
<body>
    <header>
        <jsp:include page="include/header.jsp"/>
    </header>
    <main>
        <div class="container">
            <div class="col1">
                <h3>Tài sản đang đấu giá</h3>
            </div>
            <div class="col2">
                <div class="flex-container">
                    <c:forEach items="${products}" var="a">
                        <div class="item">
                            <h5>Thời gian còn lại</h5>
                            <div id="countdown"></div>
                            <div>
                                <table>
                                    <tr>
                                        <th><span>Ngày</span></th>
                                        <th><span>Giờ</span></th>
                                        <th><span>Phút</span></th>
                                        <th><span>Giây</span></th>
                                    </tr>
                                    <tr>
                                        <th><div id="d"></div></th>
                                        <th><div id="h"></div></th>
                                        <th><div id="p"></div></th>
                                        <th><div id="s"></div></th>
                                    </tr>
                                </table>
                            </div>
                            <input type="hidden" id="targetDate" name="targetDate" value="${targetDate}">
                            <img src="${a.productImg}" alt="">
                            <h5>
                                ${a.productName}
                            </h5>
                            <a class="btn btn-outline-danger" onclick="location.href='bid/${a.productId}'" role="button">Đấu Giá</a>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </main>
</body>
</html>
