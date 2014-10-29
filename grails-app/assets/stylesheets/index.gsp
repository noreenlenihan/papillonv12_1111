<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Dashboard</title>

    <!-- Bootstrap core CSS -->
    <asset:stylesheet src="bootstrap.min.css"/>

    <!-- Custom styles for this template -->
    <asset:stylesheet src="dashboard.css"/>

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">
        google.load("visualization", "1", {packages:["corechart"]});
        google.setOnLoadCallback(drawChart);
        function drawChart() {
            var data = google.visualization.arrayToDataTable([
                ['Month', 'Est. Budget', 'Est. Spending'],
                ['1',  100,      120],
                ['2',  200,      180],
                ['3',  300,       250],
                ['4',  400,      350],
                ['5',  500,      490],
                ['6',  600,      570],
                ['7',  800,      830],
                ['8',  1000,      930],
                ['9',  1400,      1250],
                ['10',  1550,      1350],
                ['11',  1700,      1500],
                ['12',  1800,      1600]
            ]);
            var options = {
                title: 'Annual Projection',
                'chartArea': {'width': '70%', 'height': '80%'}
            };

            var chart = new google.visualization.LineChart(document.getElementById('chart_div_annual'));

            chart.draw(data, options);
        }
    </script>
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">
        google.load("visualization", "1", {packages:["corechart"]});
        google.setOnLoadCallback(drawChart);
        function drawChart() {
            var data = google.visualization.arrayToDataTable([
                ['Month', 'Est. Budget', 'Est. Spending'],
                ['1',  100,      120],
                ['2',  200,      180],
                ['3',  300,       250],
                ['4',  400,      350],
                ['5',  500,      490],
                ['6',  600,      570],
                ['7',  800,      830],
                ['8',  1000,      930],
                ['9',  1400,      1250],
                ['10',  1550,      1350],
                ['11',  1700,      1500],
                ['12',  1800,      1600]
            ]);
            var options = {
                title: 'Monthly Projection',
                'chartArea': {'width': '70%', 'height': '80%'}
            };

            var chart = new google.visualization.LineChart(document.getElementById('chart_div_monthly'));

            chart.draw(data, options);
        }
    </script>
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">
        google.load("visualization", "1", {packages:["corechart"]});
        google.setOnLoadCallback(drawChart);
        function drawChart() {
            var data = google.visualization.arrayToDataTable([
                ['Month', 'Est. Budget', 'Est. Spending'],
                ['1',  100,      120],
                ['2',  200,      180],
                ['3',  300,       250],
                ['4',  400,      350],
                ['5',  500,      490],
                ['6',  600,      570],
                ['7',  800,      830],
                ['8',  1000,      930],
                ['9',  1400,      1250],
                ['10',  1550,      1350],
                ['11',  1700,      1500],
                ['12',  1800,      1600]
            ]);
            var options = {
                title: 'Weekly Projection',
                'chartArea': {'width': '70%', 'height': '80%'}
            };

            var chart = new google.visualization.LineChart(document.getElementById('chart_div_weekly'));

            chart.draw(data, options);
        }
    </script>
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">
        google.load("visualization", "1", {packages:["corechart"]});
        google.setOnLoadCallback(drawChart);
        function drawChart() {
            var data = google.visualization.arrayToDataTable([
                ['Month', 'Est. Budget', 'Est. Spending'],
                ['1',  100,      120],
                ['2',  200,      180],
                ['3',  300,       250],
                ['4',  400,      350],
                ['5',  500,      490],
                ['6',  600,      570],
                ['7',  800,      830],
                ['8',  1000,      930],
                ['9',  1400,      1250],
                ['10',  1550,      1350],
                ['11',  1700,      1500],
                ['12',  1800,      1600]
            ]);
            var options = {
                title: 'Daily Projection',
                'chartArea': {'width': '70%', 'height': '80%'}
            };

            var chart = new google.visualization.LineChart(document.getElementById('chart_div_daily'));

            chart.draw(data, options);
        }
    </script>

</head>

<body>

<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">Papillon Express</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="dashboard">Dashboard</a></li>
                <li><a href="admin">Administrator</a></li>

            </ul>
            <form class="navbar-form navbar-right">
                <input type="text" class="form-control" placeholder="Search...">
            </form>
        </div>
    </div>
</div>

<div class="container-fluid">
    <div class="row">
        <div id="sidebar" class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <p class="sub-header" style="padding-left: 15px;"><strong>Overall</strong></p>
                <li><a href="#annual">Annual</a></li>
                <li><a href="#monthly">Monthly</a></li>
                <li><a href="#weekly">Weekly</a></li>
                <li><a href="#daily">Daily</a></li>
            </ul>

            <ul class="nav nav-sidebar">
                <p class="sub-header" style="padding-left: 15px;padding-top:10px"><strong>Faculty</strong></p>
                <li><a href="/science">College of Science</a></li>
                <li><a href="/human">College of Human Sciences</a></li>
                <li><a href="/health">College of Health Sciences</a></li>
                <li><a href="/engineering">College of Engineering & Architecture</a></li>
                <li><a href="/business">College of Business & Law</a></li>
                <li><a href="/arts">College of Arts & Celtic Studies</a></li>
                <li><a href="/agriculture">College of Agriculture, Food Science and Veterinary Medicine</a></li>
            </ul>

        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
        <h1 id="annual" style="text-align:center" class="page-header"><%= title %></h1>


        <div class="row placeholders">

            <div id="chart_div_annual" style="width: 1000px; height: 500px;"></div>
            <h4>Budget Projection</h4>
            <span class="text-muted">UCD Colleges 2014</span>
        </div>

        <h2 style="text-align:center" class="sub-header">Annual Energy Consumption</h2>
        <div class="table-responsive">
            <table style="width:800px; margin-left:100px" class="table table-striped">
                <thead>
                <tr>
                    <th>Faculty</th>
                    <th>Server</th>
                    <th>Power Usage</th>
                    <th>Annual Budget</th>
                    <th>Projected Cost</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>College of Science</td>
                    <td>Lorem</td>
                    <td>123</td>
                    <td>100</td>
                    <td>100</td>
                </tr>
                <tr>
                    <td>College of Human Sciences</td>
                    <td>amet</td>
                    <td>123</td>
                    <td>100</td>
                    <td>100</td>
                </tr>
                <tr>
                    <td>College of Health Sciences</td>
                    <td>Integer</td>
                    <td>nec</td>
                    <td>100</td>
                    <td>100</td>
                </tr>
                <tr>
                    <td>College of Engineering & Architecture</td>
                    <td>libero</td>
                    <td>123</td>
                    <td>100</td>
                    <td>100</td>
                </tr>
                <tr>
                    <td>College of Business & Law</td>
                    <td>dapibus</td>
                    <td>123</td>
                    <td>100</td>
                    <td>100</td>
                </tr>
                <tr>
                    <td>College of Arts & Celtic Studies</td>
                    <td>Nulla</td>
                    <td>123</td>
                    <td>100</td>
                    <td id="monthly">100</td>
                </tr>
                <tr>
                    <td>College of Agriculture, Food Science and Veterinary Medicine</td>
                    <td>nibh</td>
                    <td>123</td>
                    <td>100</td>
                    <td>100</td>
                </tr>

                </tbody>
            </table>
        </div>


        <div class="row placeholders">

            <div id="chart_div_monthly" style="width: 1000px; height: 500px;"></div>
            <h4>Budget Projection</h4>
            <span class="text-muted">UCD Colleges 2014</span>
        </div>
        <h2 style="text-align:center" class="sub-header">Monthly Energy Consumption</h2>
        <div class="table-responsive">
            <table style="width:800px; margin-left:100px" class="table table-striped">
                <thead>
                <tr>
                    <th>Faculty</th>
                    <th>Server</th>
                    <th>Power Usage</th>
                    <th>Annual Budget</th>
                    <th>Projected Cost</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>College of Science</td>
                    <td>Lorem</td>
                    <td>123</td>
                    <td>100</td>
                    <td>100</td>
                </tr>
                <tr>
                    <td>College of Human Sciences</td>
                    <td>amet</td>
                    <td>123</td>
                    <td>100</td>
                    <td>100</td>
                </tr>
                <tr>
                    <td>College of Health Sciences</td>
                    <td>Integer</td>
                    <td>nec</td>
                    <td>100</td>
                    <td>100</td>
                </tr>
                <tr>
                    <td>College of Engineering & Architecture</td>
                    <td>libero</td>
                    <td>123</td>
                    <td>100</td>
                    <td>100</td>
                </tr>
                <tr>
                    <td>College of Business & Law</td>
                    <td>dapibus</td>
                    <td>123</td>
                    <td>100</td>
                    <td>100</td>
                </tr>
                <tr>
                    <td>College of Arts & Celtic Studies</td>
                    <td>Nulla</td>
                    <td>123</td>
                    <td>100</td>
                    <td id="weekly">100</td>
                </tr>
                <tr>
                    <td>College of Agriculture, Food Science and Veterinary Medicine</td>
                    <td>nibh</td>
                    <td>123</td>
                    <td>100</td>
                    <td>100</td>
                </tr>

                </tbody>
            </table>
        </div>
        <div class="row placeholders">

            <div id="chart_div_weekly" style="width: 1000px; height: 500px;"></div>
            <h4>Budget Projection</h4>
            <span class="text-muted">UCD Colleges 2014</span>
        </div>
        <h2 style="text-align:center" class="sub-header">Weekly Energy Consumption</h2>
        <div class="table-responsive">
            <table style="width:800px; margin-left:100px" class="table table-striped">
                <thead>
                <tr>
                    <th>Faculty</th>
                    <th>Server</th>
                    <th>Power Usage</th>
                    <th>Annual Budget</th>
                    <th>Projected Cost</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>College of Science</td>
                    <td>Lorem</td>
                    <td>123</td>
                    <td>100</td>
                    <td>100</td>
                </tr>
                <tr>
                    <td>College of Human Sciences</td>
                    <td>amet</td>
                    <td>123</td>
                    <td>100</td>
                    <td>100</td>
                </tr>
                <tr>
                    <td>College of Health Sciences</td>
                    <td>Integer</td>
                    <td>nec</td>
                    <td>100</td>
                    <td>100</td>
                </tr>
                <tr>
                    <td>College of Engineering & Architecture</td>
                    <td>libero</td>
                    <td>123</td>
                    <td>100</td>
                    <td>100</td>
                </tr>
                <tr>
                    <td>College of Business & Law</td>
                    <td>dapibus</td>
                    <td>123</td>
                    <td>100</td>
                    <td>100</td>
                </tr>
                <tr>
                    <td>College of Arts & Celtic Studies</td>
                    <td>Nulla</td>
                    <td>123</td>
                    <td>100</td>
                    <td id="daily">100</td>
                </tr>
                <tr>
                    <td>College of Agriculture, Food Science and Veterinary Medicine</td>
                    <td>nibh</td>
                    <td>123</td>
                    <td>100</td>
                    <td>100</td>
                </tr>

                </tbody>
            </table>
        </div>
        <div class="row placeholders">

            <div id="chart_div_daily" style="width: 1000px; height: 500px;"></div>
            <h4>Budget Projection</h4>
            <span class="text-muted">UCD Colleges 2014</span>
        </div>
        <h2 style="text-align:center" class="sub-header">Daily Energy Consumption</h2>
        <div class="table-responsive">
            <table style="width:800px; margin-left:100px"  class="table table-striped">
                <thead>
                <tr>
                    <th>Faculty</th>
                    <th>Server</th>
                    <th>Power Usage</th>
                    <th>Annual Budget</th>
                    <th>Projected Cost</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>College of Science</td>
                    <td>Lorem</td>
                    <td>123</td>
                    <td>100</td>
                    <td>100</td>
                </tr>
                <tr>
                    <td>College of Human Sciences</td>
                    <td>amet</td>
                    <td>123</td>
                    <td>100</td>
                    <td>100</td>
                </tr>
                <tr>
                    <td>College of Health Sciences</td>
                    <td>Integer</td>
                    <td>nec</td>
                    <td>100</td>
                    <td>100</td>
                </tr>
                <tr>
                    <td>College of Engineering & Architecture</td>
                    <td>libero</td>
                    <td>123</td>
                    <td>100</td>
                    <td>100</td>
                </tr>
                <tr>
                    <td>College of Business & Law</td>
                    <td>dapibus</td>
                    <td>123</td>
                    <td>100</td>
                    <td>100</td>
                </tr>
                <tr>
                    <td>College of Arts & Celtic Studies</td>
                    <td>Nulla</td>
                    <td>123</td>
                    <td>100</td>
                    <td>100</td>
                </tr>
                <tr>
                    <td>College of Agriculture, Food Science and Veterinary Medicine</td>
                    <td>nibh</td>
                    <td>123</td>
                    <td>100</td>
                    <td>100</td>
                </tr>

                </tbody>
            </table>
        </div>
    </div>
</div>
</div>

</body>

<footer>
    <p>&copy; Company 2014</p>
</footer>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <asset:stylesheet src="bootstrap.min.css"/>
    <script src="../../assets/js/docs.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</html>

