<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="description" content="Male_Fashion Template">
        <meta name="keywords" content="Male_Fashion, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Home Page</title>
        <jsp:include page="include/css-page.jsp"/>
        <link rel="stylesheet" type="text/css" href='${pageContext.request.getContextPath()}/webjars/bootstrap/5.1.3/css/bootstrap.min.css' />
        <script type="text/javascript" src="${pageContext.request.getContextPath()}/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="resources/css/styleHome.css">
<script src="https://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>

	<script
  	type="text/javascript">
  	$( document ).ready(function() {
       setInterval(updateCountdown, 1000);
    });
  </script>
    </head>



    <body>
       <header>
        <jsp:include page="include/header.jsp"/>
       </header>
       <main>
       		<div class="container">
       			<div class="col1">
              <h2>Tài sản đang đấu giá</h2>
       			</div>
       			<div class="col2">
       			    <div class="auction-time">
                   <c:forEach items="${auctionEntityList}" var="auction" varStatus="loop">
                      <div class="item" style="padding-left: 70px; padding-top: 10px;border-radius:50px 50px 0 0; background-color: #BEBEBE;width: 276px;margin: 7px;height: 70px;">
                           <div id="countdown"></div>
                              <table>
                                  <tr>
                                    <td>Ngày- </td>
                                    <td>Giờ- </td>
                                    <td>Phút- </td>
                                    <td>Giây</td>
                                  </tr>
                                  <tr>
                                     <td><span id="d${loop.index}"></span></td>
                                     <td><span id="h${loop.index}"></span></td>
                                     <td><span id="p${loop.index}"></span></td>
                                     <td><span id="s${loop.index}"></span></td>
                                  </tr>
                              </table>
                           <input type="hidden"  class="targetDate" value="${auction.endTime}">
                           <input type="hidden"  class="targetAuctionId" value="${auction.auction_id}">
                      </div>
                   </c:forEach>
                </div>
       			    <div class="auction-product">
                  <c:forEach items="${productEntityList}" var="products">
                    <div class="item">
                       <img src="${products.productImg}" alt="">
                       <h5>${products.productName}</h5>
                       <a class="btn btn-outline-danger" onclick="location.href='user/auction/${products.productId}'" role="button" >Đấu Giá</a>
                    </div>
                  </c:forEach>
       			   </div>
       			</div>
          </div>
       </main>

    </body>
<script type="text/javascript" src="${pageContext.request.getContextPath()}/resources/js/my_time_js.js"></script>
</html>