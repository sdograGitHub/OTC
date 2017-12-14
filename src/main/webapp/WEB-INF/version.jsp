
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<style>           
.blue-button{
	background: #25A6E1;
	filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#25A6E1',endColorstr='#188BC0',GradientType=0);
	padding:3px 5px;
	color:#fff;
	font-family:'Helvetica Neue',sans-serif;
	font-size:12px;
	border-radius:2px;
	-moz-border-radius:2px;
	-webkit-border-radius:4px;
	border:1px solid #1A87B9
}     
table {
  font-family: "Helvetica Neue", Helvetica, sans-serif;
   width: 50%;
}
th {
  background: SteelBlue;
  color: white;
}
 td,th{
                border: 1px solid gray;
                width: 25%;
                text-align: left;
                padding: 5px 10px;
            }
</style>
</head>
<body>
<table class="table table-striped">
							<thead>
								<tr>
									<th>Rule Number</th>
									<th>Rule Name</th>
									<th>Account Number</th>
									<th>Store Number</th>
									<th>FC</th>
									<th>DGP</th>
									<th>AT</th>
									<th>Isbn</th>
									<th>Discount</th>
									<th>Priority</th>
									<th>Terms</th>
									<th>Frieght Charge</th>
									<th>Combo</th>
									<th>Overriden Explicitly</th>
									<th>Hardcode</th>
									<th>Quantity Range1</th>
									<th>Discount Range1</th>
									<th>Quantity Range2</th>
									<th>Discount Range2</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="revCustomer" varStatus="item"
									items="${revCustomers}">
									<tr>
										<td>${revCustomer.ruleNumber}</td>
										<td>${revCustomer.ruleName}</td>
										<td>${revCustomer.account.accountNumber}</td>
										<td>${revCustomer.account.storeNumber}</td>
										<td>${revCustomer.product.familyCode}</td>
										<td>${revCustomer.product.productGroupCode}</td>
										<td>${revCustomer.account.accountType}</td>
										<td>${revCustomer.product.isbn}</td>
										<td>${revCustomer.discount.percentage}</td>
										<td>${revCustomer.offer.priority}</td>
										<td>${revCustomer.offer.days}</td>
										<td>${revCustomer.offer.frieghtCharge}</td>
										<td>${revCustomer.offer.comboField}</td>
										<td>${revCustomer.offer.overridenExplicitly}</td>
										<td>${revCustomer.offer.hardcode}</td> 
										<td>${revCustomer.quantityRange1}</td>
										<td>${revCustomer.discountRange1}</td>
										<td>${revCustomer.quantityRange2}</td>
										<td>${revCustomer.discountRange2}</td> 
									</tr>
								</c:forEach>
							</tbody>
						</table>
</body>
</html>
