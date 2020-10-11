package br.com.laudosmama.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.laudosmama.home.databinding.HomeActivityBinding
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: HomeActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadKoinModules(homeModule)
        binding = HomeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onDestroy() {
        unloadKoinModules(homeModule)
        super.onDestroy()
    }
}