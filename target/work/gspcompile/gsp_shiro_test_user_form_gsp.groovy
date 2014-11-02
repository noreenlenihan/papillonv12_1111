import shiro_test.User
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_shiro_test_user_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/user/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: userInstance, field: 'username', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("user.username.label"),'default':("Username")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("username"),'required':(""),'value':(userInstance?.username)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: userInstance, field: 'passwordHash', 'error'))
printHtmlPart(4)
invokeTag('message','g',17,['code':("user.passwordHash.label"),'default':("Password Hash")],-1)
printHtmlPart(2)
invokeTag('textField','g',20,['name':("passwordHash"),'required':(""),'value':(userInstance?.passwordHash)],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: userInstance, field: 'permissions', 'error'))
printHtmlPart(6)
invokeTag('message','g',26,['code':("user.permissions.label"),'default':("Permissions")],-1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: userInstance, field: 'roles', 'error'))
printHtmlPart(8)
invokeTag('message','g',35,['code':("user.roles.label"),'default':("Roles")],-1)
printHtmlPart(9)
invokeTag('select','g',38,['name':("roles"),'from':(shiro_test.Role.list()),'multiple':("multiple"),'optionKey':("id"),'size':("5"),'value':(userInstance?.roles*.id),'class':("many-to-many")],-1)
printHtmlPart(10)
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
