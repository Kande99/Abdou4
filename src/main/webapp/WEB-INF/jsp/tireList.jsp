<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

 	
	<h1>Dear ${usr} you're now on our tires page</h1>
	

	<a href="/add-tire"> <b>Add new Tire</b></a>
	<hr>
		
		<table class="table table-hover table-dark">
			<thead>
					<tr>
						<th scope="col">Image</b></th>
						<th scope="col">Year</b></th>
						<th scope="col">Make</b></th>
						<th scope="col">Model</b></th>
						<th scope="col">Update</b></th>
						<th scope="col">Remove Tire</b></th>
					</tr>
			</thead>
			<tbody>
			<c:forEach items="${tires}" var="tire">
				<tr>
					<td  ><img src = "${tire.image}" width="100" height="100" /></td>
					<td  >${tire.year}</td>
					<td  >${tire.make}</td>
					<td  >${tire.model}</td>
					<td><b>&nbsp; &nbsp;
     <a href="/update-tire?id=${tire.id}">Update</a>&nbsp;</b></td>
					<td><b>&nbsp; &nbsp;
     <a href="/delete-tire?id=${tire.id}">Delete</a></b></td>
				</tr>
			</c:forEach>	
			</tbody>
			
			
		</table>
		
<%@ include file="common/footer.jspf"%>
