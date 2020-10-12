package br.com.laudosmama.laboratory

import android.R
import android.os.Bundle
import android.view.MenuItem
import br.com.laudosmama.features.base.BaseActivity
import br.com.laudosmama.laboratory.databinding.LaboratoryActivityBinding
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class LaboratoryActivity: BaseActivity() {
    private lateinit var binding: LaboratoryActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadKoinModules(laboratoryModule)
        binding = LaboratoryActivityBinding.inflate(layoutInflater)
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
        unloadKoinModules(laboratoryModule)
        super.onDestroy()
    }
}