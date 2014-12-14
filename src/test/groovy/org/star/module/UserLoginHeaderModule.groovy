package org.star.module

import geb.Module

class UserLoginHeaderModule extends Module {

    static content = {
        home { $(".item-home a") }
        testTag { $(".item-tag a") }
        testCase { $(".item-testCase a") }
        logout { $("#logout a") }
    }

}
