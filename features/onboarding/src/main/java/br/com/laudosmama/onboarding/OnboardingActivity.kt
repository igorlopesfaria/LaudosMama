package br.com.laudosmama.onboarding

import android.os.Bundle
import br.com.laudosmama.features.base.BaseActivity
import br.com.laudosmama.features.navcontroller.navProvider
import br.com.laudosmama.features.onboarding.R
import br.com.laudosmama.features.onboarding.databinding.OnboardingActivityBinding
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class OnboardingActivity : BaseActivity() {
    private lateinit var binding: OnboardingActivityBinding

    private val navController by navProvider(R.id.onboarding_navhost_fragment)

    override fun onSupportNavigateUp() = navController.navigateUp()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadKoinModules(onboardingModule)
        binding = OnboardingActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onBackPressed() {
        when (navController.currentDestination?.id) {
            R.id.onboarding_splash -> {
                finish()
            }
            R.id.onboarding_welcome -> {
                finish()
            }
            android.R.id.home -> {
                onBackPressed()
            }

            else -> onSupportNavigateUp()
        }
    }

    override fun onDestroy() {
        unloadKoinModules(onboardingModule)
        super.onDestroy()
    }
}
