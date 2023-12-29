<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Home Page</title>
        <jsp:include page="../include/css-page.jsp"/>
        <link rel="stylesheet" type="text/css" href='${pageContext.request.getContextPath()}/webjars/bootstrap/5.1.3/css/bootstrap.min.css' />
        <script type="text/javascript" src="${pageContext.request.getContextPath()}/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="../../resources/css/styleSellerHome.css">

    </head>

  <script type="text/javascript" src="${pageContext.request.getContextPath()}/resources/js/my_time_js.js"></script>

    <body>
       <header>
        <jsp:include page="../include/header.jsp"/>
       </header>
       <main>
       		<div class="container" style="margin-top:10px">
       		    <div class="col1">
                <img src="../../resources/img/icon/e5cdbc210d1ab01400816e6021440768.jpg">
                <h3><c:out value="${msg}"/></a></h3>
                <img src="../../resources/img/icon/e5cdbc210d1ab01400816e6021440768.jpg">
              </div>
              <div class="col2-2">
                <mvc:form  action="${action}" method ="post" modelAttribute="product">
                                <fieldset class="scheduler-border">
                                  <c:if test="${type.equals('update')}">
                                    <div class="form-group">
                                      <label class="control-label">Product ID</label>
                                      <mvc:input path="productId" type="text" class="form-control" placeholder="Product ID" disabled="true"/>
                                      <mvc:hidden path="productId"/>
                                    </div>
                                  </c:if>
                                  <div class="form-group">
                                    <label class="control-label">Name(*)</label>
                                    <mvc:input path="productName" type="text" class="form-control" placeholder="Product Name" required="true"/>
                                  </div>
                                  <div class="form-group">
                                    <label class="control-label">Img(*)</label>
                                    <mvc:input path="productImg" type="text" class="form-control" placeholder="Product Img" required="true"/>
                                  </div>
                                  <div class="form-group">
                                    <label class="control-label">Description</label>
                                    <mvc:input path="description" type="text" class="form-control" placeholder="Description" required="true"/>
                                  </div>
                                  <br>
                                    <button type"submit" class="btn btn-info">Save</button>
                                </fieldset>
                </mvc:form>
              </div>
          </div>
       </main>

    </body>

</html>