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

    <title>Papillon-Express</title>

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
          <a class="navbar-brand" href="/Shiro_test/home">Papillon-Express</a>
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
        <h1>Papillon-<em>Express</em></h1>
        <div style="color: white;"><p>A Simple Data Center Management Tool for Businesses</p></div>
        <p><a class="btn btn-lg" role="button" style='background-color:#33CCCC; color:#0A2929;' href="signup">Register &raquo;</a></p>
      </div>
    </div>

    <div class="container" style='font-family:"Ubuntu-C"; background-color:#EBFAFA; '>
      <!-- Example row of columns -->
      <div class="row">
        <div class="col-md-4">
          <h2>Administrator Panel</h2>
          <p>Restricted Access area for administrators to create new departments, users, admin, roles, permissions, servers, and other database tables </p>
          <p><a class="btn btn-default" href="/Shiro_test/admin" role="button">Admin &raquo;</a></p>
        </div>
        <div class="col-md-4">
          <h2>About Papillon-<em>Express</em></h2>
          <p>This tool was developed by a team of MSc Conversion students as part of the module COMP47300 Cloud Software Project. The aim of Papillon-<em>Express</em> is to help businesses understand data center metrics and the power consumption/costs associated with their servers, and how it aligns to their budget. This tool further informs the IT/Finance Manager about the carbon footprint of its servers. Papillon-<em>Express</em> relies on the software monitoring API, Papillon, to provide its analyses.</p>
       </div>
        <div class="col-md-4">
          <h2>Value</h2>
          <p>Papillon-<em>Express</em> helps bridge the divide in communication between the IT and Finance/Accounting departments in organizations. Papillon-<em>Express</em> allows managers from any department to quickly and intuitively assess their servers' power and carbon costs, and evaluate periods when the budget has been exceeded. In this way, companies can easily learn how close their projections for power and carbon are to actual expenditure, without having to understand technical or confusing metrics.</p>
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
    
