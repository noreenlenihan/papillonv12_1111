import shiro_test.User
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_shiro_test_usershow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/user/show.gsp" }
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
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("author"),'content':("noreen_kevin")],-1)
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
invokeTag('set','g',34,['var':("entityName"),'value':(message(code: 'user.label', default: 'User'))],-1)
printHtmlPart(11)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',35,['code':("default.show.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',35,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',35,[:],2)
printHtmlPart(7)
})
invokeTag('captureHead','sitemesh',36,[:],1)
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
invokeTag('message','g',71,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',71,['class':("list"),'action':("index")],2)
printHtmlPart(16)
createTagBody(2, {->
invokeTag('message','g',72,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',72,['class':("create"),'action':("create")],2)
printHtmlPart(17)
invokeTag('message','g',76,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(18)
if(true && (flash.message)) {
printHtmlPart(19)
expressionOut.print(flash.message)
printHtmlPart(20)
}
printHtmlPart(21)
if(true && (userInstance?.username)) {
printHtmlPart(22)
invokeTag('message','g',84,['code':("user.username.label"),'default':("Username")],-1)
printHtmlPart(23)
invokeTag('fieldValue','g',86,['bean':(userInstance),'field':("username")],-1)
printHtmlPart(24)
}
printHtmlPart(25)
if(true && (userInstance?.passwordHash)) {
printHtmlPart(26)
invokeTag('message','g',95,['code':("user.passwordHash.label"),'default':("Password Hash")],-1)
printHtmlPart(27)
invokeTag('fieldValue','g',97,['bean':(userInstance),'field':("passwordHash")],-1)
printHtmlPart(24)
}
printHtmlPart(28)
if(true && (userInstance?.permissions)) {
printHtmlPart(29)
invokeTag('message','g',104,['code':("user.permissions.label"),'default':("Permissions")],-1)
printHtmlPart(30)
invokeTag('fieldValue','g',106,['bean':(userInstance),'field':("permissions")],-1)
printHtmlPart(24)
}
printHtmlPart(28)
if(true && (userInstance?.roles)) {
printHtmlPart(31)
invokeTag('message','g',113,['code':("user.roles.label"),'default':("Roles")],-1)
printHtmlPart(32)
for( r in (userInstance.roles) ) {
printHtmlPart(33)
createTagBody(4, {->
expressionOut.print(r?.encodeAsHTML())
})
invokeTag('link','g',116,['controller':("role"),'action':("show"),'id':(r.id)],4)
printHtmlPart(34)
}
printHtmlPart(35)
}
printHtmlPart(36)
createTagBody(2, {->
printHtmlPart(37)
createTagBody(3, {->
invokeTag('message','g',125,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',125,['class':("edit"),'action':("edit"),'resource':(userInstance)],3)
printHtmlPart(38)
invokeTag('actionSubmit','g',126,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(39)
})
invokeTag('form','g',128,['url':([resource:userInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(40)
})
invokeTag('captureBody','sitemesh',130,[:],1)
printHtmlPart(41)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1414559375000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
