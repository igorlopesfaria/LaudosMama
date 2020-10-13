package br.com.laudosmama.reports

import android.R
import android.os.Bundle
import android.view.MenuItem
import br.com.laudosmama.features.base.BaseActivity
import br.com.laudosmama.reports.databinding.ReportActivityBinding
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class ReportActivity: BaseActivity() {
    private lateinit var binding: ReportActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadKoinModules(reportModule)
        binding = ReportActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = null
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        unloadKoinModules(reportModule)
        super.onDestroy()
    }
}