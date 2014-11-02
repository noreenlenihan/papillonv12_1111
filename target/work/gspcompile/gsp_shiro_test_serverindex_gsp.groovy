import shiro_test.Server
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_shiro_test_serverindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/server/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'charset':("utf-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("description"),'content':("")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("author"),'content':("")],-1)
printHtmlPart(3)
expressionOut.print(assetPath(src: 'butterfly_icon.gif'))
printHtmlPart(4)
createTagBody(2, {->
createClosureForHtmlPart(5, 3)
invokeTag('captureTitle','sitemesh',13,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',13,[:],2)
printHtmlPart(6)
invokeTag('stylesheet','asset',15,['src':("application.css")],-1)
printHtmlPart(7)
invokeTag('javascript','asset',16,['src':("application.js")],-1)
printHtmlPart(8)
invokeTag('stylesheet','asset',19,['src':("bootstrap.min.css")],-1)
printHtmlPart(9)
invokeTag('stylesheet','asset',23,['src':("jumbotron.css")],-1)
printHtmlPart(10)
invokeTag('set','g',35,['var':("entityName"),'value':(message(code: 'server.label', default: 'Server'))],-1)
printHtmlPart(11)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',36,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',36,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',36,[:],2)
printHtmlPart(7)
})
invokeTag('captureHead','sitemesh',37,[:],1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(12)
invokeTag('message','g',67,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(13)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(14)
invokeTag('message','g',70,['code':("default.home.label")],-1)
printHtmlPart(15)
createTagBody(2, {->
invokeTag('message','g',71,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',71,['class':("create"),'action':("create")],2)
printHtmlPart(16)
invokeTag('message','g',75,['code':("default.list.label"),'args':([entityName])],-1)
printHtmlPart(17)
if(true && (flash.message)) {
printHtmlPart(18)
expressionOut.print(flash.message)
printHtmlPart(19)
}
printHtmlPart(20)
invokeTag('sortableColumn','g',83,['property':("serverName"),'title':(message(code: 'server.serverName.label', default: 'Server Name'))],-1)
printHtmlPart(21)
invokeTag('sortableColumn','g',85,['property':("location"),'title':(message(code: 'server.location.label', default: 'Location'))],-1)
printHtmlPart(21)
invokeTag('sortableColumn','g',87,['property':("rack"),'title':(message(code: 'server.rack.label', default: 'Rack'))],-1)
printHtmlPart(21)
invokeTag('sortableColumn','g',89,['property':("floor"),'title':(message(code: 'server.floor.label', default: 'Floor'))],-1)
printHtmlPart(22)
loop:{
int i = 0
for( serverInstance in (serverInstanceList) ) {
printHtmlPart(23)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(24)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: serverInstance, field: "serverName"))
})
invokeTag('link','g',97,['action':("show"),'id':(serverInstance.id)],3)
printHtmlPart(25)
expressionOut.print(fieldValue(bean: serverInstance, field: "location"))
printHtmlPart(25)
expressionOut.print(fieldValue(bean: serverInstance, field: "rack"))
printHtmlPart(25)
expressionOut.print(fieldValue(bean: serverInstance, field: "floor"))
printHtmlPart(26)
i++
}
}
printHtmlPart(27)
invokeTag('paginate','g',110,['total':(serverInstanceCount ?: 0)],-1)
printHtmlPart(28)
})
invokeTag('captureBody','sitemesh',113,[:],1)
printHtmlPart(29)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1414556941000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
