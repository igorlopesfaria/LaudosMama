package br.com.laudosmama.onboarding.register.view

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.laudosmama.features.base.BaseActivity
import br.com.laudosmama.features.base.BaseFragment
import br.com.laudosmama.features.onboarding.databinding.OnboardingFragmentRegisterBinding
import java.text.SimpleDateFormat
import java.util.*

class RegisterFragment: BaseFragment() {
    private lateinit var binding: OnboardingFragmentRegisterBinding
    private val myCalendar = Calendar.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = OnboardingFragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as BaseActivity).setSupportActionBar(binding.toolbar)
        (activity as BaseActivity).supportActionBar?.title = null

        setupListeners()
    }

    private fun setupListeners() {

        val date =
            DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                myCalendar.set(Calendar.YEAR, year)
                myCalendar.set(Calendar.MONTH, monthOfYear)
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateLabel()
            }

        binding.birthdayEditText.setOnClickListener{
            DatePickerDialog(
                requireContext(), date, myCalendar[Calendar.YEAR],
                myCalendar[Calendar.MONTH],
                myCalendar[Calendar.DAY_OF_MONTH]
            ).show()

        }

    }
    private fun updateLabel() {
        val myFormat = "dd/MM/yyyy" //In which you need put here
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        binding.birthdayEditText.setText(sdf.format(myCalendar.time))
    }

}
