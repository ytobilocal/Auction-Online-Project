<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Shop Item - Start Bootstrap Template</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
                <link rel="stylesheet" type="text/css" href='${pageContext.request.getContextPath()}/webjars/bootstrap/5.1.3/css/bootstrap.min.css' />
                <script type="text/javascript" src="${pageContext.request.getContextPath()}/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>

        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="../resources/css/item.css" rel="stylesheet" />
    </head>
    <body>
           <header>
            <jsp:include page="include/header.jsp"/>
           </header>
        <!-- Product section-->
    <section class="py-5">|
        <c:forEach items="${products}" var="product">
            <div class="container px-4 px-lg-5 my-5">
                <div class="row gx-4 gx-lg-5 align-items-center">
                    <div class="col-md-6"><img class="card-img-top mb-5 mb-md-0" src="${product.productImg}" alt=""/></div>
                    <div class="col-md-6">
                        <div class="small mb-1">SKU:${product.productId}</div>
                        <h1 class="display-5 fw-bolder">${product.productName}</h1>
                        <div class="fs-5 mb-5">
                            <span>${auction.startPrice}</span>
                        </div>
                        <p class="lead">${product.description}</p>
                        <div class="d-flex">
                            <input class="form-control text-center me-3" id="inputQuantity" type="num" value="1" style="max-width: 3rem" />
                            <button class="btn btn-outline-dark flex-shrink-0" type="button">
                                <i class="bi-cart-fill me-1"></i>
                                Đấu giá
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </section>
    </body>
</html>
