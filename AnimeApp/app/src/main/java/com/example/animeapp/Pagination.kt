package com.example.animeapp

data class Pagination(
    val has_next_page: Boolean,
    val items: Items,
    val last_visible_page: Int
)