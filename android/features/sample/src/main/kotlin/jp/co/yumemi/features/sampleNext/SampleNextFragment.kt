package jp.co.yumemi.features.sampleNext

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
import jp.co.yumemi.features.sample.SampleNavigator
import jp.co.yumemi.features.sample.SampleViewModel

@AndroidEntryPoint
class SampleNextFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View = composeView {
        SampleNextScreenRoot()
    }
}
