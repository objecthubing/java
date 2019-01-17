<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>图书列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
	<link href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
	<link href="${pageContext.request.contextPath }/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" media="screen">

    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.js" charset="UTF-8"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.min.js"></script>

</head>

<body>

<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2>商品列表</h2>
        </div>

        <div class="panel-body">
            <table class="table table-hover">
                <thead>
					<tr>
						<th>商品名称</th>
						<th>所属分类</th>
						<th>商品数量</th>
						<th>商品价格</th>
						<th>保质期</th>
					</tr>
                </thead>
				<thead>
				<c:forEach items="${list}" var="goods">
					<tr>
						<td>${goods.goods_name}</td>
						<td>${goods.category.cname}</td>
						<td>${goods.goods_number}</td>
						<td>${goods.goods_price}</td>
						<td><fmt:formatDate value="${goods.guarantee_period}" pattern="yyyy-MM-dd"/></td>
					</tr>
				</c:forEach>

				</thead>

            </table> 
        </div>

        
    </div>
</div>
</body>
</html>

