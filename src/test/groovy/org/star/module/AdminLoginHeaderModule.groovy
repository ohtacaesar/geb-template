package org.star.module

import geb.Module

class AdminLoginHeaderModule extends UserLoginHeaderModule {
    static content = {
        admin { $(".item-admin > a") }
        secureUser { $(".item-secureUser > a") }
    }

    def secureUser() {
        admin.click()
        secureUser.click()
    }

}
