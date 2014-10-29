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

    <title>Edit Cost Centre</title>

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
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
		<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
	<script>
	    jQuery.fn.filterByText = function(textbox, selectSingleMatch) {
	        return this.each(function() {
	            var select = this;
	            var options = [];
	            $(select).find('option').each(function() {
	                options.push({value: $(this).val(), text: $(this).text()});
	            });
	            $(select).data('options', options);
	            $(textbox).bind('change keyup', function() {
	                var options = $(select).empty().data('options');
	                var search = $.trim($(this).val());
	                var regex = new RegExp(search,"gi");
	              
	                $.each(options, function(i) {
	                    var option = options[i];
	                    if(option.text.match(regex) !== null) {
	                        $(select).append(
	                           $('<option>').text(option.text).val(option.value)
	                        );
	                    }
	                });
	                if (selectSingleMatch === true && $(select).children().length === 1) {
	                    $(select).children().get(0).selected = true;
	                }
	            });            
	        });
	    };
	
	    $(function() {
	        $('#select-from').filterByText($('#textbox'), true);
	    }); 
	    $(function() {
	        $('#select-from2').filterByText($('#textbox2'), true);
	    }); 
	</script> 
	<script>
	$(document).ready(function() {
		 
	    $('#btn-add').click(function(){
	        $('#select-from option:selected').each( function() {
	                $('#select-to').append("<option value='"+$(this).val()+"'>"+$(this).text()+"</option>");
	            $(this).remove();
	        });
	    });
	    $('#btn-remove').click(function(){
	        $('#select-to option:selected').each( function() {
	            $('#select-from').append("<option value='"+$(this).val()+"'>"+$(this).text()+"</option>");
	            $(this).remove();
	        });
	    });
	 
	});
	</script>
	<script>
	$(document).ready(function() {
		 
	    $('#btn-add2').click(function(){
	        $('#select-from2 option:selected').each( function() {
	                $('#select-to2').append("<option value='"+$(this).val()+"'>"+$(this).text()+"</option>");
	            $(this).remove();
	        });
	    });
	    $('#btn-remove2').click(function(){
	        $('#select-to2 option:selected').each( function() {
	            $('#select-from2').append("<option value='"+$(this).val()+"'>"+$(this).text()+"</option>");
	            $(this).remove();
	        });
	    });
	 
	});
	</script>
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
	
	
		<a href="#edit-cost_Center" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation" style='font-family:"Ubuntu-C";'>
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="edit-cost_Center" class="content scaffold-edit" role="main" style='font-family:"Ubuntu-C"; padding: 20px;'>
			<h1 style="color: #33CCCC"><g:message code="default.edit.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${cost_CenterInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${cost_CenterInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form url="[resource:cost_CenterInstance, action:'update']" method="PUT" >
				<g:hiddenField name="version" value="${cost_CenterInstance?.version}" />
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
