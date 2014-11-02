import shiro_test.Server
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_shiro_test_server_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/server/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: serverInstance, field: 'serverName', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("server.serverName.label"),'default':("Server Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("serverName"),'required':(""),'value':(serverInstance?.serverName)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: serverInstance, field: 'location', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("server.location.label"),'default':("Location")],-1)
printHtmlPart(2)
invokeTag('textField','g',19,['name':("location"),'required':(""),'value':(serverInstance?.location)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: serverInstance, field: 'rack', 'error'))
printHtmlPart(5)
invokeTag('message','g',25,['code':("server.rack.label"),'default':("Rack")],-1)
printHtmlPart(2)
invokeTag('textField','g',28,['name':("rack"),'required':(""),'value':(serverInstance?.rack)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: serverInstance, field: 'floor', 'error'))
printHtmlPart(6)
invokeTag('message','g',34,['code':("server.floor.label"),'default':("Floor")],-1)
printHtmlPart(2)
invokeTag('textField','g',37,['name':("floor"),'required':(""),'value':(serverInstance?.floor)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: serverInstance, field: 'costcenters', 'error'))
printHtmlPart(7)
invokeTag('message','g',43,['code':("server.costcenters.label"),'default':("Costcenters")],-1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: serverInstance, field: 'results', 'error'))
printHtmlPart(9)
invokeTag('message','g',52,['code':("server.results.label"),'default':("Results")],-1)
printHtmlPart(10)
for( r in (serverInstance?.results) ) {
printHtmlPart(11)
createTagBody(2, {->
expressionOut.print(r?.encodeAsHTML())
})
invokeTag('link','g',58,['controller':("result"),'action':("show"),'id':(r.id)],2)
printHtmlPart(12)
}
printHtmlPart(13)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'result.label', default: 'Result')]))
})
invokeTag('link','g',61,['controller':("result"),'action':("create"),'params':(['server.id': serverInstance?.id])],1)
printHtmlPart(14)
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
