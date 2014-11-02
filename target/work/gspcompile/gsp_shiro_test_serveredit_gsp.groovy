import shiro_test.Server
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_shiro_test_serveredit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/server/edit.gsp" }
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
invokeTag('message','g',35,['code':("default.edit.label"),'args':([entityName])],-1)
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
createTagBody(2, {->
invokeTag('message','g',71,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',71,['class':("create"),'action':("create")],2)
printHtmlPart(16)
invokeTag('message','g',75,['code':("default.edit.label"),'args':([entityName])],-1)
printHtmlPart(17)
if(true && (flash.message)) {
printHtmlPart(18)
expressionOut.print(flash.message)
printHtmlPart(19)
}
printHtmlPart(20)
createTagBody(2, {->
printHtmlPart(21)
createTagBody(3, {->
printHtmlPart(22)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(23)
expressionOut.print(error.field)
printHtmlPart(24)
}
printHtmlPart(25)
invokeTag('message','g',82,['error':(error)],-1)
printHtmlPart(26)
})
invokeTag('eachError','g',83,['bean':(serverInstance),'var':("error")],3)
printHtmlPart(27)
})
invokeTag('hasErrors','g',85,['bean':(serverInstance)],2)
printHtmlPart(20)
createTagBody(2, {->
printHtmlPart(28)
invokeTag('hiddenField','g',87,['name':("version"),'value':(serverInstance?.version)],-1)
printHtmlPart(29)
invokeTag('render','g',89,['template':("form")],-1)
printHtmlPart(30)
invokeTag('actionSubmit','g',92,['class':("save"),'action':("update"),'value':(message(code: 'default.button.update.label', default: 'Update'))],-1)
printHtmlPart(31)
})
invokeTag('form','g',94,['url':([resource:serverInstance, action:'update']),'method':("PUT")],2)
printHtmlPart(32)
})
invokeTag('captureBody','sitemesh',96,[:],1)
printHtmlPart(33)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1414557383000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
