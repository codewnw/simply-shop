<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to SimplyShop</title>
</head>
<body>
	<%@ include file="/common/header.jsp"%>

	<div class="container mt-5 mb-5">
		<div class="row">
			<c:forEach var="item" items="${requestScope.items}">
				<div class="col col-md-4 mb-4">
					<div class="card">
						<a href="${pageContext.request.contextPath}/items/${item.id}/"><img
							src="${item.imageUrl}" height="300" class="card-img-top"
							alt="..."></a>
						<div class="card-body">
							<h5 class="card-title">${item.name}</h5>
							<p class="card-text">
								<strong>Price: </strong> ${item.price}
							</p>
							<div class="row">
								<div class="col">
									<a href="#" onclick="f1('${item.id}'); return false;"
										id="add-to-cart" class="btn btn-primary">Add to Cart</a> <a
										href="${pageContext.request.contextPath}/checkouts/${item.id}/"
										class="btn btn-success float-right">Buy Now</a>
								</div>
							</div>
						</div>

					</div>
				</div>
			</c:forEach>


		</div>
	</div>

	<script type="text/javascript">
		function f1(itemId) {
			var count = document.getElementById("item-count").textContent;
			count = +count + 1;
			document.getElementById("item-count").textContent = count;
			//alert(itemId);
			//alert(document.getElementById("cart").href);
			var link = document.getElementById("cart").href;
			link = link + "itemId=" + itemId + "&";
			//alert(link);
			document.getElementById("cart").href = link;
			return false;
		};
	</script>


	<%@ include file="/common/footer.jsp"%>
</body>
</html>