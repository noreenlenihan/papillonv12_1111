import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_shiro_test_resultcreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/result/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'charset':("utf-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("description"),'content':("")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("author"),'content':("noreen_kevin")],-1)
printHtmlPart(2)
expressionOut.print(assetPath(src: 'butterfly_icon.gif'))
printHtmlPart(3)
createTagBody(2, {->
createClosureForHtmlPart(4, 3)
invokeTag('captureTitle','sitemesh',11,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],2)
printHtmlPart(5)
invokeTag('stylesheet','asset',13,['src':("application.css")],-1)
printHtmlPart(6)
invokeTag('javascript','asset',14,['src':("application.js")],-1)
printHtmlPart(7)
invokeTag('stylesheet','asset',17,['src':("bootstrap.min.css")],-1)
printHtmlPart(8)
invokeTag('stylesheet','asset',21,['src':("jumbotron.css")],-1)
printHtmlPart(9)
invokeTag('set','g',32,['var':("entityName"),'value':(message(code: 'result.label', default: 'Result'))],-1)
printHtmlPart(10)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',33,['code':("default.create.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',33,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',33,[:],2)
printHtmlPart(6)
})
invokeTag('captureHead','sitemesh',34,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(11)
invokeTag('message','g',64,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(12)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(13)
invokeTag('message','g',67,['code':("default.home.label")],-1)
printHtmlPart(14)
createTagBody(2, {->
invokeTag('message','g',68,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',68,['class':("list"),'action':("index")],2)
printHtmlPart(15)
invokeTag('message','g',72,['code':("default.create.label"),'args':([entityName])],-1)
printHtmlPart(16)
if(true && (flash.message)) {
printHtmlPart(17)
expressionOut.print(flash.message)
printHtmlPart(18)
}
printHtmlPart(19)
createTagBody(2, {->
printHtmlPart(20)
createTagBody(3, {->
printHtmlPart(21)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(22)
expressionOut.print(error.field)
printHtmlPart(23)
}
printHtmlPart(24)
invokeTag('message','g',79,['error':(error)],-1)
printHtmlPart(25)
})
invokeTag('eachError','g',80,['bean':(resultInstance),'var':("error")],3)
printHtmlPart(26)
})
invokeTag('hasErrors','g',82,['bean':(resultInstance)],2)
printHtmlPart(19)
createTagBody(2, {->
printHtmlPart(27)
invokeTag('render','g',85,['template':("form")],-1)
printHtmlPart(28)
invokeTag('submitButton','g',88,['name':("create"),'class':("save"),'value':(message(code: 'default.button.create.label', default: 'Create'))],-1)
printHtmlPart(29)
})
invokeTag('form','g',90,['url':([resource:resultInstance, action:'save'])],2)
printHtmlPart(30)
})
invokeTag('captureBody','sitemesh',92,[:],1)
printHtmlPart(31)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1414557715000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
