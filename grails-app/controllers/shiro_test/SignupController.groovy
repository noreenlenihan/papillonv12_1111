package shiro_test

import org.apache.shiro.authc.UsernamePasswordToken
import org.apache.shiro.SecurityUtils
import shiro_test.User
import shiro_test.Role
import org.apache.shiro.crypto.hash.Sha512Hash


/*
* Controller for registration
**/
class SignupController {
    // define service to be invoked
    def shiroSecurityService

    // index page function
    def index() {
        User user = new User()
        [user: user]
    }
	
    def register() {

        // Check to see if the username already exists
        def user = User.findByUsername(params.username)
        if (user) {
            flash.message = "User already exists with the username '${params.username}'"
            redirect(action: 'index')
        }

        // User doesn't exist with username. Let's create one
        else {

            // Make sure the passwords match
            if (params.password != params.password2) {
                flash.message = "Passwords do not match"
                redirect(action: 'index')
            }

            // Passwords match. Let's attempt to save the user
            else {
                // Create user
				
                user = new User(
                        username: params.username,
                        passwordHash: shiroSecurityService.encodePassword(params.password)
                )

				
                if (user.save(flush:true)) {
					
                    // Add USER role to new user
					
                    def userRole = Role.findByName("User")
					user.addToRoles(userRole)
					user.save(flush:true)

                    // Login user
                    def authToken = new UsernamePasswordToken(user.username, params.password)
                    SecurityUtils.subject.login(authToken)

					
                    redirect(controller: "dashboard")
                }
                else {
					redirect(controller: 'auth', action: 'login')
				}

            }
            }
        }
    }
