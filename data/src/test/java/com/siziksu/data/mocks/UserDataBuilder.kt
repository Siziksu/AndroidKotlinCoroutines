package com.siziksu.data.mocks

import com.siziksu.data.model.UserData

class UserDataBuilder {

    fun getAlbumData(id: Int): UserData = UserData(
        id,
        "name",
        "username",
        "email",
        "phone",
        "website"
    )
}
