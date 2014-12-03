
<%@ page import="shiro_test.Cost_Center" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="noreen_kevin">
    <link rel="shortcut icon" href="${assetPath(src: 'butterfly_icon.gif')}" type="image/x-icon">

    <title>Show Cost Centre</title>

	<asset:stylesheet src="application.css"/>
	<asset:javascript src="application.js"/>
	
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
		<g:set var="entityName" value="${message(code: 'cost_Center.label', default: 'Cost_Center')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
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
	  <a class="navbar-brand" style="float:left" href="/Shiro_test/dashboard/index">Go To Dashboard</a>
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
	
	
		<a href="#show-cost_Center" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation" style='font-family:"Ubuntu-C";'>
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-cost_Center" class="content scaffold-show" role="main" style='font-family:"Ubuntu-C"; padding: 20px;'>
			<h1 style="color: #33CCCC"><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list cost_Center">
			
				<g:if test="${cost_CenterInstance?.costCenterName}">
				<li class="fieldcontain">
					<span id="costCenterName-label" class="property-label"><g:message code="cost_Center.costCenterName.label" default="Cost Center Name" /></span>
					
						<span class="property-value" aria-labelledby="costCenterName-label"><g:fieldValue bean="${cost_CenterInstance}" field="costCenterName"/></span>
					
				</li>
				</g:if>

				<g:if test="${cost_CenterInstance?.centsPerKiloWatt}">
				<li class="fieldcontain">
					<span id="centsPerKiloWatt-label" class="property-label"><g:message code="cost_Center.centsPerKiloWatt.label" default="Cents Per KiloWatt" /></span>
					
						<span class="property-value" aria-labelledby="centsPerKiloWatt-label"><g:fieldValue bean="${cost_CenterInstance}" field="centsPerKiloWatt"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${cost_CenterInstance?.permissions}">
				<li class="fieldcontain">
					<span id="permissions-label" class="property-label"><g:message code="cost_Center.permissions.label" default="Permissions" /></span>
					
						<span class="property-value" aria-labelledby="permissions-label"><g:fieldValue bean="${cost_CenterInstance}" field="permissions"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${cost_CenterInstance?.servers}">
				<li class="fieldcontain">
					<span id="servers-label" class="property-label"><g:message code="cost_Center.servers.label" default="Servers" /></span>
					
						<g:each in="${cost_CenterInstance.servers}" var="s">
						<span class="property-value" aria-labelledby="servers-label"><g:link controller="server" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${cost_CenterInstance?.users}">
				<li class="fieldcontain">
					<span id="users-label" class="property-label"><g:message code="cost_Center.users.label" default="Users" /></span>
					
						<g:each in="${cost_CenterInstance.users}" var="u">
						<span class="property-value" aria-labelledby="users-label"><g:link controller="user" action="show" id="${u.id}">${u?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:cost_CenterInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${cost_CenterInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
