package jp.co.yumemi.features.sample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import jp.co.yumemi.core.foundation.contract
import jp.co.yumemi.core.foundation.setNavController
import jp.co.yumemi.core.utils.composeView

@AndroidEntryPoint
class SampleFragment : Fragment() {

    @Inject
    lateinit var navigator: SampleNavigator

    private val viewModel: SampleViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View = composeView {
        SampleScreenRoot(
            contract = contract(store = viewModel.store),
            navigator = navigator.setNavController(),
        )
    }
}
