package org.star.page

import geb.Page

class TestCasePage extends Page{
    static url = "/testCase/index"
    static at = {
        $("h1").text() == "Test Caseリスト"
    }

    static content = {
        name {$("textarea", name:"name")}
        scenario {$("textarea", name:"scenario")}
        create {$("input", value:"作成")}
        succsessMassage {$("div", class:"alert alert-info alert-dismissable")}
    }

    def addTestCase(name, scenario){
       this.name =  name
        this.scenario = scenario
        this.create.click()
    }
}
