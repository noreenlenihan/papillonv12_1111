import shiro_test.Result
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_shiro_test_resultindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/result/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'charset':("utf-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("description"),'content':("")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("author"),'content':("noreen_kevin")],-1)
printHtmlPart(2)
expressionOut.print(assetPath(src: 'butterfly_icon.gif'))
printHtmlPart(3)
createTagBody(2, {->
createClosureForHtmlPart(4, 3)
invokeTag('captureTitle','sitemesh',12,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',12,[:],2)
printHtmlPart(5)
invokeTag('stylesheet','asset',14,['src':("application.css")],-1)
printHtmlPart(6)
invokeTag('javascript','asset',15,['src':("application.js")],-1)
printHtmlPart(7)
invokeTag('stylesheet','asset',18,['src':("bootstrap.min.css")],-1)
printHtmlPart(8)
invokeTag('stylesheet','asset',22,['src':("jumbotron.css")],-1)
printHtmlPart(9)
invokeTag('set','g',33,['var':("entityName"),'value':(message(code: 'result.label', default: 'Result'))],-1)
printHtmlPart(10)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',34,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',34,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',34,[:],2)
printHtmlPart(6)
})
invokeTag('captureHead','sitemesh',35,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(11)
invokeTag('message','g',65,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(12)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(13)
invokeTag('message','g',68,['code':("default.home.label")],-1)
printHtmlPart(14)
createTagBody(2, {->
invokeTag('message','g',69,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',69,['class':("create"),'action':("create")],2)
printHtmlPart(15)
invokeTag('message','g',73,['code':("default.list.label"),'args':([entityName])],-1)
printHtmlPart(16)
if(true && (flash.message)) {
printHtmlPart(17)
expressionOut.print(flash.message)
printHtmlPart(18)
}
printHtmlPart(19)
invokeTag('sortableColumn','g',81,['property':("dateOfQuery"),'title':(message(code: 'result.dateOfQuery.label', default: 'Date Of Query'))],-1)
printHtmlPart(20)
invokeTag('sortableColumn','g',83,['property':("metric_1"),'title':(message(code: 'result.metric_1.label', default: 'Metric1'))],-1)
printHtmlPart(20)
invokeTag('sortableColumn','g',85,['property':("metric_2"),'title':(message(code: 'result.metric_2.label', default: 'Metric2'))],-1)
printHtmlPart(20)
invokeTag('sortableColumn','g',87,['property':("metric_3"),'title':(message(code: 'result.metric_3.label', default: 'Metric3'))],-1)
printHtmlPart(20)
invokeTag('sortableColumn','g',89,['property':("metric_4"),'title':(message(code: 'result.metric_4.label', default: 'Metric4'))],-1)
printHtmlPart(21)
invokeTag('message','g',91,['code':("result.servers.label"),'default':("Servers")],-1)
printHtmlPart(22)
loop:{
int i = 0
for( resultInstance in (resultInstanceList) ) {
printHtmlPart(23)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(24)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: resultInstance, field: "dateOfQuery"))
})
invokeTag('link','g',99,['action':("show"),'id':(resultInstance.id)],3)
printHtmlPart(25)
expressionOut.print(fieldValue(bean: resultInstance, field: "metric_1"))
printHtmlPart(25)
expressionOut.print(fieldValue(bean: resultInstance, field: "metric_2"))
printHtmlPart(25)
expressionOut.print(fieldValue(bean: resultInstance, field: "metric_3"))
printHtmlPart(25)
expressionOut.print(fieldValue(bean: resultInstance, field: "metric_4"))
printHtmlPart(25)
expressionOut.print(fieldValue(bean: resultInstance, field: "servers"))
printHtmlPart(26)
i++
}
}
printHtmlPart(27)
invokeTag('paginate','g',116,['total':(resultInstanceCount ?: 0)],-1)
printHtmlPart(28)
})
invokeTag('captureBody','sitemesh',119,[:],1)
printHtmlPart(29)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1414558011000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
