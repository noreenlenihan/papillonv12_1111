<%@ page import="shiro_test.Cost_Center" %>


<div class="fieldcontain ${hasErrors(bean: cost_CenterInstance, field: 'costCenterName', 'error')} required">
	<label for="costCenterName">
		<g:message code="cost_Center.costCenterName.label" default="Cost Center Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="costCenterName" required="" value="${cost_CenterInstance?.costCenterName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: cost_CenterInstance, field: 'budget', 'error')} required">
	<label for="budget">
		<g:message code="cost_Center.budget.label" default="Budget" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="budget" type="number" value="${cost_CenterInstance.budget}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: cost_CenterInstance, field: 'permissions', 'error')} ">
	<label for="permissions">
		<g:message code="cost_Center.permissions.label" default="Permissions" />
		
	</label>
	

</div>



<div style="margin-left:100px" class="fieldcontain ${hasErrors(bean: cost_CenterInstance, field: 'servers', 'error')} ">
	<label for="servers">
		<g:message code="cost_Center.servers.label" default="Data Centers" />
		<select id="textbox">
		<option value=""></option>
	    <option value="UCD">UCD</option>
	    <option value="AIB">AIB</option>
	    </select>
 	</label>
</div>



  <fieldset>
 
    <div class="fieldcontain ${hasErrors(bean: cost_CenterInstance, field: 'servers', 'error')} ">
	<label for="servers">
		<g:message  code="cost_Center.servers.label" default="Add Servers" />
		
	</label>
	<g:select style="width:400px" name="selectfrom" id="select-from" multiple size="5" from="${shiro_test.Server.list()}" multiple="multiple" optionKey="id" size="5" value=""/>

	</div>
 
    <a href="JavaScript:void(0);" id="btn-add" style="margin-left:100px;">Add &raquo;</a>
    <a href="JavaScript:void(0);" id="btn-remove">&laquo; Remove</a>
 
    <div class="fieldcontain ${hasErrors(bean: cost_CenterInstance, field: 'servers', 'error')} ">
	<label for="servers">
		<g:message  code="cost_Center.servers.label" default="Current Servers" />
		
	</label>
	<g:select style="width:400px" name="servers" id="select-to" multiple size="5" from="${cost_CenterInstance?.servers}" multiple="multiple" optionKey="id" size="5" value="${cost_CenterInstance?.servers*.id}" class="many-to-many"/>
 	<p style="margin-left:300px;"><em> Note: Use <strong style="color:red"> ctrl+click </strong> or <strong style="color:red">ctrl+shift </strong> to highlight selections of they won't be entered! </em></p>
	</div>
 
  </fieldset>




<fieldset>

	<div style="margin-left:100px" class="fieldcontain ${hasErrors(bean: cost_CenterInstance, field: 'servers', 'error')} ">
	<label for="servers">
		
		<input style="margin-left:123px" placeholder="Search Username" id="textbox2" type="text" />
 	</label>
	</div>
 
    <div class="fieldcontain ${hasErrors(bean: cost_CenterInstance, field: 'users', 'error')} ">
	<label for="users">
		<g:message code="cost_Center.users.label" default="Add Users" />
		
	</label>
	<g:select style="width:400px" id="select-from2" name="selectfrom2" from="${shiro_test.User.list()}" multiple="multiple" optionKey="id" size="5" value="${cost_CenterInstance?.users*.id}" class="many-to-many"/>

	</div>
 
    <a href="JavaScript:void(0);" id="btn-add2" style="margin-left:100px;">Add &raquo;</a>
    <a href="JavaScript:void(0);" id="btn-remove2">&laquo; Remove</a>
 
    <div class="fieldcontain ${hasErrors(bean: cost_CenterInstance, field: 'users', 'error')} ">
	<label for="users">
		<g:message code="cost_Center.users.label" default="Existing Users" />
		
	</label>
	<g:select style="width:400px" id="select-to2" name="users" from="${cost_CenterInstance?.users}" multiple="multiple" optionKey="id" size="5" value="${cost_CenterInstance?.users*.id}" class="many-to-many"/>
 	<p style="margin-left:300px;""><em> Note: Use <strong style="color:red"> ctrl+click </strong> or <strong style="color:red">ctrl+shift </strong> to highlight selections of they won't be entered! </em></p>
 	</div>
</fieldset>


