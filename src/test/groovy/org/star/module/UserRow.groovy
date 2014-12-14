package org.star.module

import geb.Module

class UserRow extends Module {

    static content = {
        cell { $("td", it) }
        username { cell(0).text() }
        email { cell(1).text() }
        editButton { cell(2).$("a", 0) }
        deleteButton { cell(2).$("a", 1) }
    }

}
