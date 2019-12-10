package com.example.challengeme.ui.login

import com.example.challengeme.User.UserAchievement
import com.example.challengeme.User.UserChallenge

/**
 * User details post authentication that is exposed to the UI
 */
data class LoggedInUserView(
    var displayName: String? = null,
    var position: String? = null,
    var userLevel: String? = null,
    var challengeCount: Int? = null,
    var lastChallenge: UserChallenge? = null,
    var lastAchievement: UserAchievement? = null,
    var profilePicture: String? = null

    // Все поля юзера, кроме логина и пароля

    // Инфа, которая приходит с сервера (инфа  о пользователе)
    // будет отображаться в профиле

    // Процесс входа по данным из кэша:
    // В кэше хранится логин и пароль (загружаем в сплэшСкрине)
    // по кнопке входа в профиль отправляем их на сервер
    // Варианты ответа сервера:
    // 1. Юзера нет - null
    // 2. Возвращаю все данные о вашем юзере (записываем в кэш)
)
