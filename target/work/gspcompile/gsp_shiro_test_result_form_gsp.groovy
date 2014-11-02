import shiro_test.Result
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_shiro_test_result_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/result/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: resultInstance, field: 'dateOfQuery', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("result.dateOfQuery.label"),'default':("Date Of Query")],-1)
printHtmlPart(2)
invokeTag('datePicker','g',10,['name':("dateOfQuery"),'precision':("day"),'value':(resultInstance?.dateOfQuery)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: resultInstance, field: 'metric_1', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("result.metric_1.label"),'default':("Metric1")],-1)
printHtmlPart(2)
invokeTag('field','g',19,['name':("metric_1"),'type':("number"),'value':(resultInstance.metric_1),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: resultInstance, field: 'metric_2', 'error'))
printHtmlPart(5)
invokeTag('message','g',25,['code':("result.metric_2.label"),'default':("Metric2")],-1)
printHtmlPart(2)
invokeTag('field','g',28,['name':("metric_2"),'type':("number"),'value':(resultInstance.metric_2),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: resultInstance, field: 'metric_3', 'error'))
printHtmlPart(6)
invokeTag('message','g',34,['code':("result.metric_3.label"),'default':("Metric3")],-1)
printHtmlPart(2)
invokeTag('field','g',37,['name':("metric_3"),'type':("number"),'value':(resultInstance.metric_3),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: resultInstance, field: 'metric_4', 'error'))
printHtmlPart(7)
invokeTag('message','g',43,['code':("result.metric_4.label"),'default':("Metric4")],-1)
printHtmlPart(2)
invokeTag('field','g',46,['name':("metric_4"),'type':("number"),'value':(resultInstance.metric_4),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: resultInstance, field: 'servers', 'error'))
printHtmlPart(8)
invokeTag('message','g',52,['code':("result.servers.label"),'default':("Servers")],-1)
printHtmlPart(2)
invokeTag('select','g',55,['id':("servers"),'name':("servers.id"),'from':(shiro_test.Server.list()),'optionKey':("id"),'required':(""),'value':(resultInstance?.servers?.id),'class':("many-to-one")],-1)
printHtmlPart(9)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1414527974000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
