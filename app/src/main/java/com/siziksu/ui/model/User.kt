package com.siziksu.ui.model

data class User(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val phone: String,
    val website: String
) : Node() {

    init {
        type = NodeType.USER
    }
}
