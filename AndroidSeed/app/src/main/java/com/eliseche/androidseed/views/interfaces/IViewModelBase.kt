package com.eliseche.androidseed.views.interfaces

/**
 * Used for binding every list item to a ViewModel instance of type item.
 * For simple items without manipulation the idea is to bind every item
 * with it's model. But when we need to do some data manipulation we bind with
 * a ViewModel.
 */
interface IViewModelBase {
    // Set item of type Any to the ViewModel
    fun setItem(item: Any?)
}