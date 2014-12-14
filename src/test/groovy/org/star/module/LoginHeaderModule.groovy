package org.star.module

import geb.Module

/**
 * Created by yamakan on 2014/12/14.
 */
class LoginHeaderModule extends Module {
    static content = {
        name {$("textarea", name="name")}
        scenario {$("textarea", name="scenario")}
        create {$("input", value="作成")}
    }

}
