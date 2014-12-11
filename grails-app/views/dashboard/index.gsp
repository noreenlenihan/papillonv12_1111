<!DOCTYPE html>
<html lang="en">
<head>
<gvisualization:apiImport/>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Admin Dashboard</title>

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

    <script>


	function alertBtnClicked(){
		alertBtn.className = 'btn';
		alertBtn.innerHTML = 'Alerts (0)';
	}


    </script>

    
    <script type="text/javascript">
        google.load("visualization", "1", {packages:["corechart"]});
        google.setOnLoadCallback(drawChart);
        function drawChart() {

	    
            var data = google.visualization.arrayToDataTable();

	    var time = ${timestamps};
	    var power = ${powerratings};
	    data.addColumn('number', 'time');
	    data.addColumn('number', 'power');

	    for(i = 0; i < ${timestamplength}; i++){
		data.addRow([time[i], power[i]]);
	    }


            var options = {
                title: 'Daily Projection',
                'chartArea': {'width': '70%', 'height': '80%'}
            };

            var chart = new google.visualization.LineChart(document.getElementById('chart_div_daily'));

            chart.draw(data, options);
        }
    </script>

	<%
   def myDailyActivitiesColumns = [['datetime', 'Time'], ['number', 'Cents/Kw/Hour (Expenditure)'], ['number', 'Cents/Kw/Hour (Budget)']]
   def myDailyActivitiesColumns2 = [['datetime', 'Time'], ['number', 'Cents/Min (Expenditure)'], ['number', 'Cents/Min (Budget)']]
   def dailyBudgetColumns = [['datetime', 'time'], ['number', 'Cents'], ['number', 'Cents']]
   
   def myDailyActivitiesData = [[1, 11], [2, 2], [3, 2], [4, 2], [5, 7]]

%>

<gvisualization:lineCoreChart elementId="linechart" title="Daily Power Expenditure" width="${900}" height="${500}" 
 columns="${myDailyActivitiesColumns2}" data="${dailyGraphData}" />

<gvisualization:lineCoreChart elementId="chart_div_weekly" title="Weekly Consumption" width="${900}" height="${500}" 
 columns="${myDailyActivitiesColumns}" data="${weekresults}" />

<gvisualization:lineCoreChart elementId="chart_div_weekly_budget" title="Weekly Cumulative Budget vs Actual Expenditure" width="${900}" height="${500}" 
 columns="${dailyBudgetColumns}" data="${weeklyBudgetData}" />

<gvisualization:lineCoreChart elementId="chart_div_monthly" title="Monthly Consumption" width="${900}" height="${500}" 
 columns="${myDailyActivitiesColumns}" data="${monthlyGraphData}" />

<gvisualization:lineCoreChart elementId="chart_div_monthly_budget" title="Monthly Cumulative Budget vs Actual Expenditure" width="${900}" height="${500}" 
 columns="${dailyBudgetColumns}" data="${monthlyBudgetData}" />

<gvisualization:lineCoreChart elementId="chart_div_annual" title="Annual Consumption" width="${900}" height="${500}" 
 columns="${myDailyActivitiesColumns}" data="${annualGraphData}" />

<gvisualization:lineCoreChart elementId="chart_div_annual_budget" title="Annual Cumulative Budget vs Actual Expenditure" width="${900}" height="${500}" 
 columns="${dailyBudgetColumns}" data="${annualBudgetData}" />



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
            <a class="navbar-brand" href="/Shiro_test/home">Papillon-Express</a>
            <a class="navbar-brand" style="float:left">Welcome back, ${User}</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/Shiro_test/admin">Administrator</a></li>
                <li><a href="/Shiro_test/cost_Center/create">Create Cost Center</a></li>
                <li><a href="/Shiro_test/cost_Center/index">Edit Cost Center</a></li>
		<li><!-- Single button -->
		<g:javascript src="../assets/javascripts/bootstrap.min.js"/>
		<div class="btn-group">
		  <button id="alertBtn" style="margin-top:8px;margin-right:8px" type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-expanded="false" onClick="alertBtnClicked()">
		    Alerts (${alertslength}) <span class="caret"></span>
		  </button>
		  <ul class="dropdown-menu" style="width:500px;" role="menu">
		    <g:each in="${dailyAlertsData}">
		    <li style="padding:10px;" onMouseOver="this.style.backgroundColor='#FFCACA'" onMouseOut="this.style.backgroundColor='white'" onclick="location.href = '/Shiro_test/recommend';">Budget exceeded by ${it[1]} cents on ${it[0]}</li>
		    <li class="divider"></li>
		    </g:each>
		  </ul>
		</div></li>
		<li><button style="margin-top:8px;margin-right:8px" onClick="location.href='/Shiro_test/auth/signOut'" class="btn" style="background-color:#EBFAFA; color:#33CCCC;">Sign Out</button></li>	
				
		
            </ul>
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
                <p class="sub-header" style="padding-left: 15px;padding-top:10px"><strong>Cost Centers</strong></p>
                <g:each in="${costc_results}">
					<li><a href="/Shiro_test/dashboard/index/${it.id }"> ${it.costCenterName} </a></li>
				</g:each>
                
		
		
            </ul>

        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
        <h1 style="text-align:center" class="page-header"><%= title %></h1>


        <div class="row placeholders">
	    <h2 id="annual" style="text-align:center" class="sub-header">Annual Energy Consumption</h2>
            <div id="chart_div_annual" style="width: 1000px; height: 500px;"></div>

	    <div id="chart_div_annual_budget" style="width: 1000px; height: 500px;"></div>
            <h4>Budget Projection</h4>
            <span class="text-muted">UCD Colleges 2014</span>
        </div>

 
        <div class="table-responsive">
            <table style="width:800px; margin-left:100px" class="table table-striped">
                <thead>
                <tr>
                    <th>Host</th>
                    <th>Total Annual Power</th>
                    <th>Total Annual Power Cost</th>
                    <th>Total Annual Carbon Footprint</th>
                    <th>Surplus(+)/Deficit(-) Cost</th>
                </tr>
                </thead>
                <tbody>
                
		<g:each status="m" in="${servers_needed}" var="unique_server">
		<tr>
                    <td>${unique_server}</td>
                    <td>${totalAnnualPowerList[m]}</td>
                    <td>${totalAnnualPowerCostList[m]}</td>
                    <td>${totalAnnualCarbonList[m]}</td>
                    <td>n/a</td>
                </tr>
               </g:each>
		<tr>
		    <td>All Servers</td>
		    <td>${overallTotalAnnualPower}</td>
		    <td>${overallTotalAnnualPowerCost}</td>
		    <td>${overallTotalAnnualCarbon}</td>
		    <td>${annualBudgetDiff}</td>
		</tr>

                </tbody>
            </table>
        </div>


        <div class="row placeholders">
		<h2 id="monthly" style="text-align:center" class="sub-header">Monthly Energy Consumption</h2>
            <div id="chart_div_monthly" style="width: 1000px; height: 500px;"></div>

	    <div id="chart_div_monthly_budget" style="width: 1000px; height: 500px;"></div>
            <h4>Budget Projection</h4>
            <span class="text-muted">UCD Colleges 2014</span>
        </div>
        <div class="table-responsive">
            <table style="width:800px; margin-left:100px" class="table table-striped">
                <thead>
                <tr>
                    <th>Host</th>
                    <th>Total Monthly Power</th>
                    <th>Total Monthly Power Cost</th>
                    <th>Total Monthly Carbon Footprint</th>
                    <th>Surplus(+)/Deficit(-) Cost</th>
                </tr>
                </thead>
                <tbody>
                
		<g:each status="k" in="${servers_needed}" var="each_server">
		<tr>
                    <td>${each_server}</td>
                    <td>${totalMonthlyPowerList[k]}</td>
                    <td>${totalMonthlyPowerCostList[k]}</td>
                    <td>${totalMonthlyCarbonList[k]}</td>
                    <td>n/a</td>
                </tr>
               </g:each>
		<tr>
		    <td>All Servers</td>
		    <td>${overallTotalMonthlyPower}</td>
		    <td>${overallTotalMonthlyPowerCost}</td>
		    <td>${overallTotalMonthlyCarbon}</td>
		    <td>${monthlyBudgetDiff}</td>
		</tr>

                </tbody>
            </table>
        </div>
        <div class="row placeholders">
	    <h2 id="weekly" style="text-align:center" class="sub-header">Weekly Energy Consumption</h2>
            <div id="chart_div_weekly" style="width: 1000px; height: 500px;"></div>

	    <div id="chart_div_weekly_budget" style="width: 1000px; height: 500px;"></div>
            <h4>Budget Projection</h4>
            <span class="text-muted">UCD Colleges 2014</span>
        </div>
        <div class="table-responsive">
            <table style="width:800px; margin-left:100px" class="table table-striped">
                <thead>
                <tr>
                    <th>Host</th>
                    <th>Total Weekly Power (Kw/h)</th>
                    <th>Total Weekly Power Cost</th>
                    <th>Total Weekly Carbon Footprint</th>
                    <th>Surplus(+)/Deficit(-) Cost</th>
                </tr>
                </thead>
                <tbody>
                
		<g:each status="j" in="${servers_needed}" var="server">
		<tr>
                    <td>${server}</td>
                    <td>${totalWeeklyPowerList[j]}</td>
                    <td>${totalWeeklyPowerCostList[j]}</td>
                    <td>${totalWeeklyCarbonList[j]}</td>
                    <td>n/a</td>
                </tr>
               </g:each>
		<tr>
		    <td>All Servers</td>
		    <td>${overallTotalWeeklyPower}</td>
		    <td>${overallTotalWeeklyPowerCost}</td>
		    <td>${overallTotalWeeklyCarbon}</td>
		    <td>${totalWeeklyBudgetDifference}</td>
		</tr>

                </tbody>
            </table>
        </div>
        <div class="row placeholders">
	<h2 id="daily" style="text-align:center" class="sub-header">Daily Energy Consumption</h2>
	<div id="linechart"></div>
            <h4>Budget Projection</h4>
            <span class="text-muted">UCD Colleges 2014</span>
        </div>
	<!-- Testing  
	Users retrieved: ${user_results}
	Cost centers retrieved: ${costc_results}
	Cost center chosen: ${cost_center_chosen}
	First cc redirect: ${first_cc}
	Yesterday: ${yesterday}
	Week ago: ${weekAgo}
	Month ago: ${monthAgo}
	Year ago: ${yearAgo}
	Servers in this cost center: ${servers_included}
	Servers needed: ${servers_needed}
	totalDailyPowerList: ${totalDailyPowerList}
	This Cost Center's cents pwe kw: ${costCenterCentsPerKw}
	Daily Timestamps length: ${dailyTimestampsLength}
	Days in month: ${daysInMonth}
	Month: ${month}
	month budget: ${monthBudget}
	result1: ${res}
	weekResults: ${weekresults}
	dailyAlerts: ${dailyAlertsData}
	weeklyPowerCostTotalsAllServers: ${weeklyPowerCostTotalsAllServers}
	weeklyPowerCostCounterTotalsAllServers: ${weeklyPowerCostCounterTotalsAllServers}
	monthlyPowerCostTotalsAllServers: ${monthlyPowerCostTotalsAllServers}
	monthlyPowerCostCounterTotalsAllServers: ${monthlyPowerCostCounterTotalsAllServers}
	annualPowerCostTotalsAllServers: ${annualPowerCostTotalsAllServers}
	annualPowerCostCounterTotalsAllServers: ${annualPowerCostCounterTotalsAllServers}-->

        <div class="table-responsive">
            <table style="width:800px; margin-left:100px"  class="table table-striped">
                <thead>
                <tr>
                    <th>Host</th>
                    <th>Total Daily Power (Kw)</th>
                    <th>Total Daily cost (cents)</th>
                    <th>KgCO2/Kwh (Daily)</th>
                    <th>Surplus(+)/Deficit(-) Cost</th>
                </tr>
                </thead>
                <tbody>
                
		<g:each status="i" in="${servers_needed}" var="item">
		<tr>
                    <td>${item}</td>
                    <td>${totalDailyPowerList[i]}</td>
                    <td>${totalDailyPowerCostList[i]}</td>
                    <td>${totalDailyCarbonList[i]}</td>
                    <td>n/a</td>
                </tr>
               </g:each>
		<tr>
		    <td>All Servers</td>
		    <td>${overallTotalDailyPower}</td>
		    <td>${overallTotalDailyPowerCost}</td>
		    <td>${overallTotalDailyCarbon}</td>
		    <td>${dailyTotalBudgetEvaluation}</td>	
		</tr>

                </tbody>
            </table>
        </div>
    </div>
</div>
</div>

$('.dropdown-toggle').dropdown()

</body>

<footer>
    <p>&copy; Company 2014</p>
</footer>
	
	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" />
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-theme.min.css" />
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />

<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>

<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

<script type="text/javascript">
	if (${alertslength} === 0){
		var alertBtn2;
		alertBtn2 = document.getElementById("alertBtn");
		alertBtn2.className = 'btn';
		alertBtn2.innerHTML = 'Alerts (0)';
	}
</script>


    <!-- Bootstrap core JavaScript
    ================================================== 
    <!-- Placed at the end of the document so the pages load faster 
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <asset:stylesheet src="bootstrap.min.css"/>
    <script src="../../assets/js/docs.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script> -->
</html>

