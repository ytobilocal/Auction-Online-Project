<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Shop Item</title>
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
                            <span>Start Price: ${auction.startPrice}</span>
                        </div>
                        <p class="lead">${product.description}</p>

                        <!-- Hiển thị form đấu giá khi nhấn vào nút -->
                        <button class="btn btn-outline-dark flex-shrink-0" type="button" onclick="showBidForm()">
                            <i class="bi-cart-fill me-1"></i>
                            Đấu giá
                        </button>

                        <!-- Form đấu giá -->
                        <form id="bidForm" class="d-none" action="${pageContext.request.contextPath}/bid/addMoney" method="post" onsubmit="addMoneyToTable(event)">
                            <label for="amount">Số tiền cộng thêm:</label>
                            <input type="number" name="amount" step="0.01" required />
                            <button type="submit">Thêm Tiền</button>
                        </form>

                        <!-- Script để hiển thị và ẩn form đấu giá và thêm thông tin vào bảng -->
                        <script>
                            function showBidForm() {
                                // Hiển thị form khi nút đấu giá được nhấn
                                document.getElementById("bidForm").classList.remove("d-none");
                            }

                            // Thêm thông tin vào bảng và ẩn form đấu giá
                            function addMoneyToTable(event) {
                                event.preventDefault();

                                // Lấy giá trị số tiền từ input
                                var amount = parseFloat(document.getElementsByName("amount")[0].value);

                                // Lấy thông tin người đấu giá và thời gian (đã giả sử có sẵn)
                                var bidder = "Người đấu giá"; // Thay bằng thông tin người đấu giá thực tế
                                var time = new Date().toLocaleString(); // Lấy thời gian hiện tại

                                // Tạo một hàng mới trong bảng và thêm vào
                                var table = document.getElementById("moneyTable").getElementsByTagName('tbody')[0];
                                var newRow = table.insertRow(table.rows.length);
                                var cell1 = newRow.insertCell(0);
                                var cell2 = newRow.insertCell(1);
                                var cell3 = newRow.insertCell(2);

                                cell1.innerHTML = amount.toFixed(2); // Hiển thị số tiền với 2 chữ số sau dấu thập phân
                                cell2.innerHTML = bidder;
                                cell3.innerHTML = time;

                                // Ẩn form đấu giá sau khi thêm tiền
                                document.getElementById("bidForm").classList.add("d-none");
                            }
                        </script>

                        <!-- Bảng hiển thị thông tin những người đấu giá-->
                        <table id="moneyTable" class="table">
                            <thead>
                                <tr>
                                    <th>Người đấu giá</th>
                                    <th>Thời gian</th>
                                    <th>Số tiền</th>
                                </tr>
                            </thead>
                            <tbody>
                                <!-- Các hàng trong bảng -->
                                <!-- ... -->
                            </tbody>
                        </table>
    </body>
</html>
