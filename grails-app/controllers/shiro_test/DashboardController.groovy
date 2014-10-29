package shiro_test

import org.apache.shiro.SecurityUtils
import org.apache.shiro.subject.Subject

class DashboardController {

    def index() { 
	
		def currentUser = SecurityUtils.getSubject()
		currentUser = currentUser.getPrincipal()
		def centerInstance = Cost_Center.list()
		
		
	
		[centerInstanceList: centerInstance, User: currentUser]
	
    }
}
