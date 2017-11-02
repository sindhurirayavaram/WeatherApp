<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/NewFile.css">
</head>
<body class="action" style="margin: 0px">
	<td style="color: white;">>
		<div class="login">
			<h1>Weather Application</h1>
			<form method="post" action="login">
				<input type="email" name="email" placeholder="Email"
					required="required" /> <select id="sel" name="location" onchange="show(this)">
					<option value="">-- Select --</option>
				</select>

				<script>
					window.onload = populateSelect();

					function populateSelect() {

						// CREATE AN XMLHttpRequest OBJECT, WITH GET METHOD.
						var xhr = new XMLHttpRequest(), method = 'GET', overrideMimeType = 'application/json', url = 'cities.json'; // ADD THE URL OF THE FILE.
						xhr.onreadystatechange = function() {
							if (xhr.readyState === XMLHttpRequest.DONE
									&& xhr.status === 200) {

								// PARSE JSON DATA.
								var cities = JSON.parse(xhr.responseText);

								var ele = document.getElementById('sel');
								for (var i = 0; i < cities.length; i++) {
									// BIND DATA TO <select> ELEMENT.
									ele.innerHTML = ele.innerHTML
											+ '<option value="' + cities[i].city +"," + cities[i].state + '">'
											+ cities[i].city + " , " + cities[i].state + '</option>';
								}
							}
						};
						xhr.open(method, url, true);
						xhr.send();
					}
				</script>


				<button type="submit" class="btn btn-primary btn-block btn-large"
					name="go">Submit</button>
			</form>
		</div>
</body>
</html>