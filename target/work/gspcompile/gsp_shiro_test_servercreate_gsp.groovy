import shiro_test.Server
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_shiro_test_servercreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/server/create.gsp" }
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
invokeTag('set','g',34,['var':("entityName"),'value':(message(code: 'server.label', default: 'Server'))],-1)
printHtmlPart(10)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',35,['code':("default.create.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',35,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',35,[:],2)
printHtmlPart(6)
})
invokeTag('captureHead','sitemesh',36,[:],1)
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
invokeTag('message','g',74,['code':("default.create.label"),'args':([entityName])],-1)
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
invokeTag('message','g',81,['error':(error)],-1)
printHtmlPart(25)
})
invokeTag('eachError','g',82,['bean':(serverInstance),'var':("error")],3)
printHtmlPart(26)
})
invokeTag('hasErrors','g',84,['bean':(serverInstance)],2)
printHtmlPart(19)
createTagBody(2, {->
printHtmlPart(27)
invokeTag('render','g',87,['template':("form")],-1)
printHtmlPart(28)
invokeTag('submitButton','g',90,['name':("create"),'class':("save"),'value':(message(code: 'default.button.create.label', default: 'Create'))],-1)
printHtmlPart(29)
})
invokeTag('form','g',92,['url':([resource:serverInstance, action:'save'])],2)
printHtmlPart(30)
})
invokeTag('captureBody','sitemesh',94,[:],1)
printHtmlPart(31)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1414557492000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
