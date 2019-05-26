package com.siziksu.ui.model

class Header(val title: String, val subtitle: String) : Node() {

    init {
        type = NodeType.HEADER
    }
}
