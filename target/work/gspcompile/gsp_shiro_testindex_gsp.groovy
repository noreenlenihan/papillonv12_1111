import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_shiro_testindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',4,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',4,[:],2)
printHtmlPart(3)
expressionOut.print(assetPath(src: 'butterfly_icon.gif'))
printHtmlPart(4)
invokeTag('stylesheet','asset',6,['src':("fonts.css")],-1)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',22,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
invokeTag('image','asset',26,['src':("sittingbutterfly-animation.gif"),'alt':("Butterfly"),'width':("100"),'height':("80")],-1)
printHtmlPart(8)
invokeTag('image','asset',30,['src':("orangebutterflyanimated.gif"),'alt':("Butterfly"),'width':("80"),'height':("80")],-1)
printHtmlPart(9)
})
invokeTag('captureBody','sitemesh',33,['style':('color:#33CCCC; text-align:center; font-family:"Ubuntu-C";')],1)
printHtmlPart(10)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1414555043000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
