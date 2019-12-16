package com.example.challengeme.data

import com.example.challengeme.User.UserAchievement
import com.example.challengeme.User.UserChallenge
import com.example.challengeme.data.model.LoggedInUser

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */

// Класс, который хранит юзера на устройстве
class LoginRepository(val dataSource: LoginDataSource) {

    // in-memory cache of the loggedInUser object
    var user: LoggedInUser? = null
        private set

    val isLoggedIn: Boolean
        get() = user != null

    init {
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
        user = null
        // здесь смотрим в кэше - есть ли сохраненный юзер
    }

    fun logout() {
        user = null
        dataSource.logout()
    }

    fun login(username: String, password: String): Result<LoggedInUser> {
        // handle login
        val result = dataSource.login(username, password)

        if (result is Result.Success) {
            setLoggedInUser(result.data)
        }

        return result
    }

    private fun setLoggedInUser(loggedInUser: LoggedInUser) {
        this.user = loggedInUser
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
    }

    // ТЕСТОВАЯ ХРЕНЬ КОГДА НЕКИТ ОПЯТЬ РОНЯЕТ СЕРВАК, НЕ ЗАБЫТЬ УБАРТЬ МЕТОД
    fun setLoggedInUserNoInternet() {

        val userAchievement = UserAchievement()
        userAchievement.id = 0
        userAchievement.name = "Сдай курсач вовремя"
        userAchievement.description = "о, да вы красавчик"
        userAchievement.image = "https://pbs.twimg.com/profile_banners/819426580606881793/1545042538/1500x500"

        val userChallenge = UserChallenge()
        userChallenge.id = 0
        userChallenge.name = "Убеги от Некита за рулём"
        userChallenge.difficulty = 4
        userChallenge.image = "https://avatars.mds.yandex.net/get-pdb/34158/a7ca4842-b60a-48b5-b062-3be63e4dd18c/s1200"

        val fakeUser = LoggedInUser()
        fakeUser.displayName = "Это"
        fakeUser.login = "fake"
        fakeUser.password = "fake"
        fakeUser.position = "наш"
        fakeUser.userLevel = "сервермэн"
        fakeUser.challengeCount = 228
        fakeUser.lastChallenge = userChallenge
        fakeUser.lastAchievement = userAchievement
        fakeUser.profilePicture = "https://pp.userapi.com/c841132/v841132276/123b/VXUYSrgUD0A.jpg?ava=1"

        this.user = fakeUser
    }
}
