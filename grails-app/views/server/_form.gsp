<%@ page import="shiro_test.Server" %>



<div class="fieldcontain ${hasErrors(bean: serverInstance, field: 'serverName', 'error')} required">
	<label for="serverName">
		<g:message code="server.serverName.label" default="Server Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="serverName" required="" value="${serverInstance?.serverName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: serverInstance, field: 'location', 'error')} required">
	<label for="location">
		<g:message code="server.location.label" default="Location" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="location" required="" value="${serverInstance?.location}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: serverInstance, field: 'rack', 'error')} required">
	<label for="rack">
		<g:message code="server.rack.label" default="Rack" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="rack" required="" value="${serverInstance?.rack}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: serverInstance, field: 'floor', 'error')} required">
	<label for="floor">
		<g:message code="server.floor.label" default="Floor" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="floor" required="" value="${serverInstance?.floor}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: serverInstance, field: 'costcenters', 'error')} ">
	<label for="costcenters">
		<g:message code="server.costcenters.label" default="Costcenters" />
		
	</label>
	

</div>

<div class="fieldcontain ${hasErrors(bean: serverInstance, field: 'results', 'error')} ">
	<label for="results">
		<g:message code="server.results.label" default="Results" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${serverInstance?.results?}" var="r">
    <li><g:link controller="result" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="result" action="create" params="['server.id': serverInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'result.label', default: 'Result')])}</g:link>
</li>
</ul>


</div>

