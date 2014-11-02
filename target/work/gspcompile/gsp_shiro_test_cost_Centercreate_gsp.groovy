import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_shiro_test_cost_Centercreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/cost_Center/create.gsp" }
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
invokeTag('set','g',32,['var':("entityName"),'value':(message(code: 'cost_Center.label', default: 'Cost_Center'))],-1)
printHtmlPart(10)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',33,['code':("default.create.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',33,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',33,[:],2)
printHtmlPart(11)
})
invokeTag('captureHead','sitemesh',110,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(12)
invokeTag('message','g',141,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(13)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(14)
invokeTag('message','g',144,['code':("default.home.label")],-1)
printHtmlPart(15)
createTagBody(2, {->
invokeTag('message','g',145,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',145,['class':("list"),'action':("index")],2)
printHtmlPart(16)
invokeTag('message','g',149,['code':("default.create.label"),'args':([entityName])],-1)
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
invokeTag('message','g',156,['error':(error)],-1)
printHtmlPart(26)
})
invokeTag('eachError','g',157,['bean':(cost_CenterInstance),'var':("error")],3)
printHtmlPart(27)
})
invokeTag('hasErrors','g',159,['bean':(cost_CenterInstance)],2)
printHtmlPart(20)
createTagBody(2, {->
printHtmlPart(28)
invokeTag('render','g',162,['template':("form")],-1)
printHtmlPart(29)
invokeTag('submitButton','g',165,['name':("create"),'class':("save"),'value':(message(code: 'default.button.create.label', default: 'Create'))],-1)
printHtmlPart(30)
})
invokeTag('form','g',167,['url':([resource:cost_CenterInstance, action:'save'])],2)
printHtmlPart(31)
})
invokeTag('captureBody','sitemesh',170,[:],1)
printHtmlPart(32)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1414558443000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
