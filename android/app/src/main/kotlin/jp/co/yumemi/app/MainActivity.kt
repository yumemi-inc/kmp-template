package jp.co.yumemi.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import dagger.hilt.android.AndroidEntryPoint
import jp.co.yumemi.app.R

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContentView(R.layout.activity_main)
        findNavController(R.id.nav_host_fragment).setGraph(jp.co.yumemi.navigation.R.navigation.app_nav_graph)
    }
}
