package shiro_test


import org.apache.shiro.authc.UsernamePasswordToken
import org.apache.shiro.SecurityUtils
import shiro_test.User
import shiro_test.Role

	
class HomeController {
	
	def shiroSecurityService

    def index() {
    }
	
	def secured(){
		render "This is secured"
	}
	
	def signin(){
		
		// Check to see if the username already exists
		def user = User.findByUsername(params.username)
		
		// Login user
		def authToken = new UsernamePasswordToken(user.username, params.password)
		SecurityUtils.subject.login(authToken)

		redirect(controller: 'dashboard', action: 'index')
		
	}

 
}
