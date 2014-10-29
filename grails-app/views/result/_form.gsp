<%@ page import="shiro_test.Result" %>



<div class="fieldcontain ${hasErrors(bean: resultInstance, field: 'dateOfQuery', 'error')} required">
	<label for="dateOfQuery">
		<g:message code="result.dateOfQuery.label" default="Date Of Query" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dateOfQuery" precision="day"  value="${resultInstance?.dateOfQuery}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: resultInstance, field: 'metric_1', 'error')} required">
	<label for="metric_1">
		<g:message code="result.metric_1.label" default="Metric1" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="metric_1" type="number" value="${resultInstance.metric_1}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: resultInstance, field: 'metric_2', 'error')} required">
	<label for="metric_2">
		<g:message code="result.metric_2.label" default="Metric2" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="metric_2" type="number" value="${resultInstance.metric_2}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: resultInstance, field: 'metric_3', 'error')} required">
	<label for="metric_3">
		<g:message code="result.metric_3.label" default="Metric3" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="metric_3" type="number" value="${resultInstance.metric_3}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: resultInstance, field: 'metric_4', 'error')} required">
	<label for="metric_4">
		<g:message code="result.metric_4.label" default="Metric4" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="metric_4" type="number" value="${resultInstance.metric_4}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: resultInstance, field: 'servers', 'error')} required">
	<label for="servers">
		<g:message code="result.servers.label" default="Servers" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="servers" name="servers.id" from="${shiro_test.Server.list()}" optionKey="id" required="" value="${resultInstance?.servers?.id}" class="many-to-one"/>

</div>

