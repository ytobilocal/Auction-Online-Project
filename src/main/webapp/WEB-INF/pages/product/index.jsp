<%@page isELIgnored="false"%>
<html>
<body>
<h2>How to insert image in database using Spring MVC</h2>

<form action="insertImage" method="post" enctype="multipart/form-data">

<pre>
	Name: <input type="text" name="productName">

	Description: <input type="text" name="description">

	Photo: <input type="file" name="photo">

	<input type="submit" value="Submit">

</pre>

</form>

<p>${msg}</p>

</body>
</html>