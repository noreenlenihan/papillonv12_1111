import shiro_test.Cost_Center
import shiro_test.Role
import shiro_test.Server
import shiro_test.User

class BootStrap {

	def shiroSecurityService
	
		def init = { servletContext ->
	
			// Create the admin role
			def adminRole = new Role(name: "Administrator")
			adminRole.addToPermissions("*:*")
			adminRole.save()
			
			def admin = new User(username: "Admin", passwordHash: shiroSecurityService.encodePassword("password"))
			admin.addToRoles(adminRole)
			admin.save()
	
			// Create the user role
			def userRole = new Role(name: "User")
			userRole.addToPermissions("Home:index")
			userRole.addToPermissions("Home:secured")
			userRole.addToPermissions("dashboard:index")
			userRole.addToPermissions("cost_Center:create")
			userRole.addToPermissions("cost_Center:edit")
			userRole.addToPermissions("cost_Center:update")
			userRole.addToPermissions("cost_Center:delete")
			userRole.addToPermissions("cost_Center:index")
			userRole.addToPermissions("cost_Center:show")
			userRole.save()
			
			def user1 = new User(username: "Kevin", passwordHash: shiroSecurityService.encodePassword("password"))
			user1.addToRoles(userRole)
			user1.save()
			
			def user2 = new User(username: "Laura", passwordHash: shiroSecurityService.encodePassword("password"))
			user2.addToRoles(userRole)
			user2.save()
			
			def user3 = new User(username: "Noreen", passwordHash: shiroSecurityService.encodePassword("password"))
			user3.addToRoles(userRole)
			user3.save()
			
			def user4 = new User(username: "Sharon", passwordHash: shiroSecurityService.encodePassword("password"))
			user4.addToRoles(userRole)
			user4.save()
			
			
			def server1 = new Server(serverName: "dc1fl1rk1ht1", location: "UCD", floor: 1, rack: 2)
			server1.save()
			
			
			def c1 = new Cost_Center(costCenterName: "Kevins Center", budget: 5000)
			c1.save()
			def c2 = new Cost_Center(costCenterName: "Lauras Center", budget: 5000)
			c2.save()
			def c3 = new Cost_Center(costCenterName: "Noreens Center", budget: 5000)
			c3.save()
			def c4 = new Cost_Center(costCenterName: "Sharons Center", budget: 5000)
			c4.save()
			def c5 = new Cost_Center(costCenterName: "Group Center", budget: 5000)
			c5.save()
	}
    def destroy = {
    }
}
