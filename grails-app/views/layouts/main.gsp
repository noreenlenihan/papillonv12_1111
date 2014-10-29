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

    <title>Papillon.this</title>

    <!-- Bootstrap core CSS -->
     <asset:stylesheet src="bootstrap.min.css"/>
    

    <!-- Custom styles for this template -->
     <asset:stylesheet src="jumbotron.css"/>

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

    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation" style='font-family:"Ubuntu-C";' >
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Papillon.this</a>
        </div>
        <div class="navbar-collapse collapse">
        
          <form class="navbar-form navbar-right" role="form" action="home/signin">
            <div class="form-group">
              <input name="username" type="text" placeholder="Username" class="form-control">
            </div>
            <div class="form-group">
              <input name="password" type="password" placeholder="Password" class="form-control">
            </div>
            <button type="submit" class="btn" style="background-color:#EBFAFA; color:#33CCCC;">Sign in</button>
          </form>
          
        </div><!--/.navbar-collapse -->
      </div>
    </div>

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron" style='background-color:#0A2929; color:#33CCCC; text-align:center;'>
      <div class="container" style='font-family:"Ubuntu-C"'>
      	<asset:image src="turquoise_butterfly.png" alt="Butterfly" width="80" height="80"/>
        <h1>Papillon.this</h1>
        <div style="color: white;"><p>Monitoring UCD and all that jazz</p></div>
        <p><a class="btn btn-lg" role="button" style='background-color:#33CCCC; color:#0A2929;'>Register &raquo;</a></p>
      </div>
    </div>

    <div class="container" style='font-family:"Ubuntu-C"; background-color:#EBFAFA;' role="infotime">
      <!-- Example row of columns -->
      <div class="row">
        <div class="col-md-4">
          <h2>Administrator Panel</h2>
          <p>Restricted Access area for administrators to create new departments, servers, and other database tables </p>
          <p><a class="btn btn-default" href="admin" role="button">admin &raquo;</a></p>
        </div>
        <div class="col-md-4">
          <h2>About Papillon.this</h2>
          <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
          <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
       </div>
        <div class="col-md-4">
          <h2>Technology & Metrics</h2>
          <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
          <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div>
      </div>

      <hr>

      <footer>
        <p>&copy; Cloud Computing Group 5 2014</p>
      </footer>
    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <asset:javascript src="bootstrap.min.js"/>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
    
    <!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"> 
	
	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
	
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
  </body>
</html>

