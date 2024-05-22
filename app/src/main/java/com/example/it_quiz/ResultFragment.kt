package com.example.it_quiz

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.it_quiz.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val resultPoints = requireArguments().getInt("points", 0)
        val timeOffCounter = requireArguments().getInt("timeOff", 0)
        with(binding) {
            if (resultPoints > 6) {
                imageIV.setImageResource(R.drawable.ic_cheerful_smiley)
                Toast.makeText(requireContext(),"Супер! Так держать!",Toast.LENGTH_LONG).show()
            }
            else {
                imageIV.setImageResource(R.drawable.ic_angry_smiley)
                Toast.makeText(requireContext(),"Ты можешь лучше! Дерзай!",Toast.LENGTH_LONG).show()
            }
            exitBT.setOnClickListener { activity?.finish() }
            sharePointsTV.setOnClickListener { sharePoints(resultPoints) }
            startGameTV.setOnClickListener { findNavController().navigate(R.id.action_resultFragment_to_startFragment) }
            resultPointsTV.text = "Счет: $resultPoints"
            correctAnswersTV.text = "Правильные ответы: $resultPoints"
            notCorrectAnswersTV.text = "Неправильные ответы: ${10 - resultPoints}"
            missedAnswersTV.text = "Пропущенные: $timeOffCounter"
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun sharePoints(points: Int){
        val shareIntent = Intent()
        shareIntent.action = Intent.ACTION_SEND
        shareIntent.type="text/plain"
        shareIntent.putExtra(Intent.EXTRA_TEXT, points.toString())
        startActivity(Intent.createChooser(shareIntent,"Share via"))
    }
}