import shiro_test.Result
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_shiro_test_resultshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/result/show.gsp" }
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
invokeTag('message','g',34,['code':("default.show.label"),'args':([entityName])],-1)
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
invokeTag('message','g',66,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(12)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(13)
invokeTag('message','g',69,['code':("default.home.label")],-1)
printHtmlPart(14)
createTagBody(2, {->
invokeTag('message','g',70,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',70,['class':("list"),'action':("index")],2)
printHtmlPart(15)
createTagBody(2, {->
invokeTag('message','g',71,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',71,['class':("create"),'action':("create")],2)
printHtmlPart(16)
invokeTag('message','g',75,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(17)
if(true && (flash.message)) {
printHtmlPart(18)
expressionOut.print(flash.message)
printHtmlPart(19)
}
printHtmlPart(20)
if(true && (resultInstance?.dateOfQuery)) {
printHtmlPart(21)
invokeTag('message','g',83,['code':("result.dateOfQuery.label"),'default':("Date Of Query")],-1)
printHtmlPart(22)
invokeTag('formatDate','g',85,['date':(resultInstance?.dateOfQuery)],-1)
printHtmlPart(23)
}
printHtmlPart(24)
if(true && (resultInstance?.metric_1)) {
printHtmlPart(25)
invokeTag('message','g',92,['code':("result.metric_1.label"),'default':("Metric1")],-1)
printHtmlPart(26)
invokeTag('fieldValue','g',94,['bean':(resultInstance),'field':("metric_1")],-1)
printHtmlPart(23)
}
printHtmlPart(24)
if(true && (resultInstance?.metric_2)) {
printHtmlPart(27)
invokeTag('message','g',101,['code':("result.metric_2.label"),'default':("Metric2")],-1)
printHtmlPart(28)
invokeTag('fieldValue','g',103,['bean':(resultInstance),'field':("metric_2")],-1)
printHtmlPart(23)
}
printHtmlPart(24)
if(true && (resultInstance?.metric_3)) {
printHtmlPart(29)
invokeTag('message','g',110,['code':("result.metric_3.label"),'default':("Metric3")],-1)
printHtmlPart(30)
invokeTag('fieldValue','g',112,['bean':(resultInstance),'field':("metric_3")],-1)
printHtmlPart(23)
}
printHtmlPart(24)
if(true && (resultInstance?.metric_4)) {
printHtmlPart(31)
invokeTag('message','g',119,['code':("result.metric_4.label"),'default':("Metric4")],-1)
printHtmlPart(32)
invokeTag('fieldValue','g',121,['bean':(resultInstance),'field':("metric_4")],-1)
printHtmlPart(23)
}
printHtmlPart(24)
if(true && (resultInstance?.servers)) {
printHtmlPart(33)
invokeTag('message','g',128,['code':("result.servers.label"),'default':("Servers")],-1)
printHtmlPart(34)
createTagBody(3, {->
expressionOut.print(resultInstance?.servers?.encodeAsHTML())
})
invokeTag('link','g',130,['controller':("server"),'action':("show"),'id':(resultInstance?.servers?.id)],3)
printHtmlPart(23)
}
printHtmlPart(35)
createTagBody(2, {->
printHtmlPart(36)
createTagBody(3, {->
invokeTag('message','g',138,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',138,['class':("edit"),'action':("edit"),'resource':(resultInstance)],3)
printHtmlPart(37)
invokeTag('actionSubmit','g',139,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(38)
})
invokeTag('form','g',141,['url':([resource:resultInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(39)
})
invokeTag('captureBody','sitemesh',143,[:],1)
printHtmlPart(40)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1414558173000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
