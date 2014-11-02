import shiro_test.Cost_Center
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_shiro_test_cost_Center_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/cost_Center/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: cost_CenterInstance, field: 'costCenterName', 'error'))
printHtmlPart(1)
invokeTag('message','g',6,['code':("cost_Center.costCenterName.label"),'default':("Cost Center Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',9,['name':("costCenterName"),'required':(""),'value':(cost_CenterInstance?.costCenterName)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: cost_CenterInstance, field: 'budget', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("cost_Center.budget.label"),'default':("Budget")],-1)
printHtmlPart(2)
invokeTag('field','g',18,['name':("budget"),'type':("number"),'value':(cost_CenterInstance.budget),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: cost_CenterInstance, field: 'permissions', 'error'))
printHtmlPart(5)
invokeTag('message','g',24,['code':("cost_Center.permissions.label"),'default':("Permissions")],-1)
printHtmlPart(6)
expressionOut.print(hasErrors(bean: cost_CenterInstance, field: 'servers', 'error'))
printHtmlPart(7)
invokeTag('message','g',35,['code':("cost_Center.servers.label"),'default':("Data Centers")],-1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: cost_CenterInstance, field: 'servers', 'error'))
printHtmlPart(7)
invokeTag('message','g',50,['code':("cost_Center.servers.label"),'default':("Add Servers")],-1)
printHtmlPart(9)
invokeTag('select','g',53,['style':("width:400px"),'name':("selectfrom"),'id':("select-from"),'multiple size':("5"),'from':(shiro_test.Server.list()),'multiple':("multiple"),'optionKey':("id"),'size':("5"),'value':("")],-1)
printHtmlPart(10)
expressionOut.print(hasErrors(bean: cost_CenterInstance, field: 'servers', 'error'))
printHtmlPart(7)
invokeTag('message','g',62,['code':("cost_Center.servers.label"),'default':("Current Servers")],-1)
printHtmlPart(9)
invokeTag('select','g',65,['style':("width:400px"),'name':("servers"),'id':("select-to"),'multiple size':("5"),'from':(cost_CenterInstance?.servers),'multiple':("multiple"),'optionKey':("id"),'size':("5"),'value':(cost_CenterInstance?.servers*.id),'class':("many-to-many")],-1)
printHtmlPart(11)
expressionOut.print(hasErrors(bean: cost_CenterInstance, field: 'servers', 'error'))
printHtmlPart(12)
expressionOut.print(hasErrors(bean: cost_CenterInstance, field: 'users', 'error'))
printHtmlPart(13)
invokeTag('message','g',85,['code':("cost_Center.users.label"),'default':("Add Users")],-1)
printHtmlPart(9)
invokeTag('select','g',88,['style':("width:400px"),'id':("select-from2"),'name':("selectfrom2"),'from':(shiro_test.User.list()),'multiple':("multiple"),'optionKey':("id"),'size':("5"),'value':(cost_CenterInstance?.users*.id),'class':("many-to-many")],-1)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: cost_CenterInstance, field: 'users', 'error'))
printHtmlPart(13)
invokeTag('message','g',97,['code':("cost_Center.users.label"),'default':("Existing Users")],-1)
printHtmlPart(9)
invokeTag('select','g',100,['style':("width:400px"),'id':("select-to2"),'name':("users"),'from':(cost_CenterInstance?.users),'multiple':("multiple"),'optionKey':("id"),'size':("5"),'value':(cost_CenterInstance?.users*.id),'class':("many-to-many")],-1)
printHtmlPart(15)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1414561339000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
