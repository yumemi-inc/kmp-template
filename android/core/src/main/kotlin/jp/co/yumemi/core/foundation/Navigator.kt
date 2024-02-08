package jp.co.yumemi.core.foundation

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController

interface Navigator {
    var navController: NavController
}

context(Fragment)
fun <T : Navigator> T.setNavController(): T = apply { navController = findNavController() }
