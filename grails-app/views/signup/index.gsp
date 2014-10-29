<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
    <link rel="shortcut icon" href="${assetPath(src: 'butterfly_icon.gif')}" type="image/x-icon">

    <title>Register for Papillon</title>

    <!-- Bootstrap core CSS -->
     <asset:stylesheet src="bootstrap.min.css"/>

    <!-- Custom styles for this template -->
     <asset:stylesheet src="signin.css"/>

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
  
  <g:if test="${flash.message}">
    <div class="alert alert-info">${flash.message}</div>
  </g:if>

	<g:hasErrors bean="${user}">
	    <div class="alert alert-error">
	        <g:renderErrors bean="${user}" as="list"/>
	    </div>
	</g:hasErrors>

    <div class="container">

      <g:form class="form-signin" style="color:#33CCCC;" role="form" action="register">
      	<asset:image src="turquoise_butterfly.png" alt="Butterfly" width="80" height="80"/>
        <h2 class="form-signin-heading" style="color:#33CCCC">Please sign up</h2>
        
        <label for="username">Username</label>
        <g:textField name="username" value="${user.username}" class="form-control" placeholder="Username"/>
        
        <label for="password">Password</label>
        <g:passwordField name="password" value="" class="form-control" placeholder="Password"/>
        
        <label for="password">Confirm Password</label>
        <g:passwordField name="password2" value="" class="form-control" placeholder="Confirm password"/>
        
        <g:submitButton name="submit" value="Submit" class="btn btn-lg btn-block" type="submit" style="background-color:#33CCCC; color:#EBFAFA;" />
        
      </g:form>

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>