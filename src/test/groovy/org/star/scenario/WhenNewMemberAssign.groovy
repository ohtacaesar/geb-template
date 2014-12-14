package org.star.scenario

import geb.spock.GebReportingSpec

/**
 * Created by yamakan on 2014/12/14.
 */
class WhenNewMemberAssign  extends GebReportingSpec{

    def "新規ユーザがタグを作成し、テストケースに紐付けられるか"() {
        given: "テストケースが複数作成する"

        when: "管理者でログインする"
        and: "user管理画面に移動し"

        and: "管理者が新規メンバーのアカウントを発行し"

        then: "管理者画面でアカウントが追加されている"



        when: "担当者でログインする"
        and: "担当者がタグを作成する"
        then: "タグが追加されている(担当者画面"

        when: "テストケースにタグをひもづける"

        then: "テストケースにタグが紐付いている"

        when: "別ユーザでログインする"
        then: "タグが紐付いていることを確認する"

    }
}


