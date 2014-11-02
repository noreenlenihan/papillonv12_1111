import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_shiro_test_signupindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/signup/index.gsp" }
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
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("author"),'content':("")],-1)
printHtmlPart(2)
expressionOut.print(assetPath(src: 'butterfly_icon.gif'))
printHtmlPart(3)
createTagBody(2, {->
createClosureForHtmlPart(4, 3)
invokeTag('captureTitle','sitemesh',12,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',12,[:],2)
printHtmlPart(5)
invokeTag('stylesheet','asset',15,['src':("bootstrap.min.css")],-1)
printHtmlPart(6)
invokeTag('stylesheet','asset',18,['src':("signin.css")],-1)
printHtmlPart(7)
})
invokeTag('captureHead','sitemesh',29,[:],1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
createTagBody(2, {->
printHtmlPart(13)
invokeTag('renderErrors','g',39,['bean':(user),'as':("list")],-1)
printHtmlPart(14)
})
invokeTag('hasErrors','g',41,['bean':(user)],2)
printHtmlPart(15)
createTagBody(2, {->
printHtmlPart(16)
invokeTag('image','asset',46,['src':("turquoise_butterfly.png"),'alt':("Butterfly"),'width':("80"),'height':("80")],-1)
printHtmlPart(17)
invokeTag('textField','g',50,['name':("username"),'value':(user.username),'class':("form-control"),'placeholder':("Username")],-1)
printHtmlPart(18)
invokeTag('passwordField','g',53,['name':("password"),'value':(""),'class':("form-control"),'placeholder':("Password")],-1)
printHtmlPart(19)
invokeTag('passwordField','g',56,['name':("password2"),'value':(""),'class':("form-control"),'placeholder':("Confirm password")],-1)
printHtmlPart(20)
invokeTag('submitButton','g',58,['name':("submit"),'value':("Submit"),'class':("btn btn-lg btn-block"),'type':("submit"),'style':("background-color:#33CCCC; color:#EBFAFA;")],-1)
printHtmlPart(21)
})
invokeTag('form','g',60,['class':("form-signin"),'style':("color:#33CCCC;"),'role':("form"),'action':("register")],2)
printHtmlPart(22)
})
invokeTag('captureBody','sitemesh',67,[:],1)
printHtmlPart(23)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1414555941000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
