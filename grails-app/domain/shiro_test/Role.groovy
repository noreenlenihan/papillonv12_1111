package shiro_test

/*
* Domain for Role which pertains to the type of user using site (user, admin)
*/
class Role {
    // define attributes
    String name

    // define relationships
    static hasMany = [ users: User, permissions: String ]
    static belongsTo = User

    // define constraints of name attribute
    static constraints = {
        name(nullable: false, blank: false, unique: true)
    }
}
