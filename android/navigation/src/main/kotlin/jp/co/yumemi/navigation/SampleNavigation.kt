package jp.co.yumemi.navigation

import androidx.navigation.NavController
import jp.co.yumemi.features.sample.SampleFragmentDirections
import jp.co.yumemi.features.sample.SampleNavigator

class SampleNavigation : SampleNavigator {
    override lateinit var navController: NavController

    override fun next() {
        navController.navigate(SampleFragmentDirections.actionSampleToSampleNext())
    }
}
