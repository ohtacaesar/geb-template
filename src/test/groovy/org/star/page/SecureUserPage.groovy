package org.star.page

import geb.Page
import org.star.module.AdminLoginHeaderModule
import org.star.module.UserRow

class SecureUserPage extends Page {

    static at = {
        title == "Grabbit SecureUser"
    }

    static content = {
        header(required: true) { module AdminLoginHeaderModule }

        loading { $(".panel-heading span.loading") }

        userTable { moduleList UserRow, $("tbody tr") }

        usernameInput { $("#username") }
        passwordInput { $("#password") }
        emailInput { $("#email") }

        accountExpiredCheckbox { $("#accountExpired") }
        accountLockedCheckbox { $("#accountLocked") }
        enabledCheckbox { $("#enabled") }
        passwordExpiredCheckbox { $("#passwordExpired") }

        createButton { $("input", name: "create") }
        updateButton { $("input", name: "update") }
    }


    def getUserRowByUsername(username) {

        def row = userTable.find({
            it.username == username
        })

        if (row == null) {
            def lastUsername = userTable.get(0).username
            $("a.nextLink").click()
            println("wait for loading")
            waitFor { loading.css("display") == "none" }
            println("finished waiting for loading")
            row = getUserRowByUsername(username)
        }

        return row
    }

}
