package com.example.platzifakestore.presentation.fragments

interface BaseFragment {
    fun bindViewModel()
    fun initObservers()
    fun initUI()
    fun loadData()
}