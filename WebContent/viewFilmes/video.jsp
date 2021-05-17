<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Teste Video</title>
</head>
<body>
	<div class="videoContainer">
		<iframe width="560" height="315" src="https://www.youtube-nocookie.com/embed/4WtpFjzTSgg" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
	</div>

	<style type="text/css">
		.videoContainer {
			position: absolute;
			width: 100%;
			height: 100%;
			top: 0;
			left: 0;
			bottom: 0;
			right: 0;
			display: flex;
			flex-direction: column;
			justify-content: center;
			align-items: center;
		}

		iframe {
			/* optional */
			width: 100%;
			height: 100%; 
		}
	</style>
</body>
</html>