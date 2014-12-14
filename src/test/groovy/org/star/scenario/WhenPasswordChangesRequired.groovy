package org.star.scenario

import geb.spock.GebReportingSpec
import org.star.page.*

/**
 * 低規定なパスワードの変更を要求された際の処理を定義する
 */
class WhenPasswordChangesRequired extends GebReportingSpec {

    // PasswordExpiredが設定されたユーザーは、いままでのパスワードを利用してログインすることができない
    def "Password Expiredが設定されたユーザーは、いままでのパスワードを利用してログインすることができない"() {
        given: "トップページにアクセスする"
        to TopPage

        when: "管理者としてログインすると"
        login "admin", "admin"
        then: "ダッシュボードが表示される"
        at DashBoardPage

        when: "ユーザー管理ページに遷移する"
        header.secureUser()
        then: "アカウント管理ページが表示される"
        at SecureUserPage

        def username = (new Date()).format('yyMMddHHmmss')

        when: "新規ユーザーを登録する"
        usernameInput = username
        passwordInput = "test"
        emailInput = "ohtacaesar@gmail.com"
        enabledCheckbox.click()
        createButton.click()
        then: "新規ユーザーの登録に成功する"
        at SecureUserPage

        when: "ログアウトする"
        header.logout.click()
        then: "トップページが表示される"
        at TopPage

        when: "新規ユーザーでログインすると"
        login username, "test"
        then: "ダッシュボードが表示される"
        at DashBoardPage

        when: "ログアウトする"
        header.logout.click()
        then: "トップページが表示される"
        at TopPage

        when: "管理者としてログインすると"
        login "admin", "admin"
        then: "ダッシュボードが表示される"
        at DashBoardPage

        when: "ユーザー管理ページに遷移する"
        header.secureUser()
        then: "アカウント管理ページが表示される"
        at SecureUserPage

        when: "Password Expiredにする"
        def row = getUserRowByUsername(username)
        row.editButton.click()
        waitFor { usernameInput.value() == username }
        passwordExpiredCheckbox.click()
        waitFor { updateButton.isDisplayed() }
        updateButton.click()
        waitFor { $(".loading").css("display") == "none" }
        then: "成功する"
        at SecureUserPage

        when: "ログアウトする"
        header.logout.click()
        then: "トップページが表示される"
        at TopPage

        when: "新規ユーザーでログインすると"
        login username, "test"
        then: "ログインできずトップページが表示される"
        at TopPage
    }

}
