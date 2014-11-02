import shiro_test.Cost_Center
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_shiro_test_cost_Centeredit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/cost_Center/edit.gsp" }
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
invokeTag('set','g',33,['var':("entityName"),'value':(message(code: 'cost_Center.label', default: 'Cost_Center'))],-1)
printHtmlPart(10)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',34,['code':("default.edit.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',34,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',34,[:],2)
printHtmlPart(11)
})
invokeTag('captureHead','sitemesh',109,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(12)
invokeTag('message','g',140,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(13)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(14)
invokeTag('message','g',143,['code':("default.home.label")],-1)
printHtmlPart(15)
createTagBody(2, {->
invokeTag('message','g',144,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',144,['class':("list"),'action':("index")],2)
printHtmlPart(16)
createTagBody(2, {->
invokeTag('message','g',145,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',145,['class':("create"),'action':("create")],2)
printHtmlPart(17)
invokeTag('message','g',149,['code':("default.edit.label"),'args':([entityName])],-1)
printHtmlPart(18)
if(true && (flash.message)) {
printHtmlPart(19)
expressionOut.print(flash.message)
printHtmlPart(20)
}
printHtmlPart(21)
createTagBody(2, {->
printHtmlPart(22)
createTagBody(3, {->
printHtmlPart(23)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(24)
expressionOut.print(error.field)
printHtmlPart(25)
}
printHtmlPart(26)
invokeTag('message','g',156,['error':(error)],-1)
printHtmlPart(27)
})
invokeTag('eachError','g',157,['bean':(cost_CenterInstance),'var':("error")],3)
printHtmlPart(28)
})
invokeTag('hasErrors','g',159,['bean':(cost_CenterInstance)],2)
printHtmlPart(21)
createTagBody(2, {->
printHtmlPart(29)
invokeTag('hiddenField','g',161,['name':("version"),'value':(cost_CenterInstance?.version)],-1)
printHtmlPart(30)
invokeTag('render','g',163,['template':("form")],-1)
printHtmlPart(31)
invokeTag('actionSubmit','g',166,['class':("save"),'action':("update"),'value':(message(code: 'default.button.update.label', default: 'Update'))],-1)
printHtmlPart(32)
})
invokeTag('form','g',168,['url':([resource:cost_CenterInstance, action:'update']),'method':("PUT")],2)
printHtmlPart(33)
})
invokeTag('captureBody','sitemesh',170,[:],1)
printHtmlPart(34)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1414558853000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
