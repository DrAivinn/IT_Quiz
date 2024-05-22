package com.example.it_quiz

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.it_quiz.databinding.DialogBinding
import com.example.it_quiz.databinding.FragmentQuestionsBinding

class QuestionsFragment : Fragment() {
    private var _binding: FragmentQuestionsBinding? = null
    private val binding get() = _binding!!
    private val quiz = QuestionsStorage.questions
    private var index = 0
    private var timeOffCounter = 0
    private var code = 0
    private val bundle = Bundle()
    private var resultPoints = 0
    private lateinit var timer: CountDownTimer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentQuestionsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            timer =
                object : CountDownTimer(31000L, 1000L) {
                    override fun onTick(millisUntilFinished: Long) {
                        counterTV.text = (millisUntilFinished / 1000).toString()
                        counterPB.progress = (millisUntilFinished / 1000).toInt()
                        counterPB.max = 30
                        if ((millisUntilFinished / 1000).toInt() < 10) counterTV.setTextColor(Color.RED)
                        if ((millisUntilFinished / 1000).toInt() == 0) {
                            code = 3
                            timeOffCounter++
                            showDialog(activity as AppCompatActivity, code, "Время закончилось!")
                        }
                    }

                    override fun onFinish() {
                    }
                }
            initQuestions()
            sendBT.setOnClickListener {
                if (getResult() == 1) {
                    code = 1
                    resultPoints += getResult()
                    showDialog((activity as AppCompatActivity), code, "Счет: $resultPoints")
                } else {
                    code = 2
                    val correctIndex = quiz[index].points.indexOf(1)
                    val correctAnswer = quiz[index].answers[correctIndex]
                    showDialog((activity as AppCompatActivity), code, correctAnswer)
                }

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun initQuestions() {
        with(binding) {
            val numberOfQuestion = "${index + 1}/${quiz.size}"
            val points = "Счет: $resultPoints"
            questionTV.text = quiz[index].question
            answerOneRB.text = quiz[index].answers[0]
            answerTwoRB.text = quiz[index].answers[1]
            answerThreeRB.text = quiz[index].answers[2]
            answerFourRB.text = quiz[index].answers[3]
            numberOfQuestionTV.text = numberOfQuestion
            pointsTV.text = points
            timer.start()
        }
    }

    private fun getResult(): Int {

        with(binding) {
            var result = 0
            when {
                answerOneRB.isChecked -> result = quiz[index].points[0]
                answerTwoRB.isChecked -> result = quiz[index].points[1]
                answerThreeRB.isChecked -> result = quiz[index].points[2]
                answerFourRB.isChecked -> result = quiz[index].points[3]
            }
            return result
        }
    }

    fun showDialog(context: Context, code: Int, text: String) {
        val dialog: AlertDialog?
        val builder = AlertDialog.Builder(context)
        val binding = DialogBinding.inflate(LayoutInflater.from(context))
        builder.setView(binding.root)
        with(binding) {
            when (code) {
                1 -> {
                    timer.cancel()
                    dialogImageIV.setImageResource(R.drawable.ic_check_mark)
                    dialogTextTV.text = text
                }

                2 -> {
                    timer.cancel()
                    dialogImageIV.setImageResource(R.drawable.ic_cross)
                    dialogTextTV.text = text
                }

                3 -> {
                    timer.cancel()
                    dialogImageIV.setImageResource(R.drawable.ic_timer_off)
                    dialogTextTV.text = text
                }
            }
            dialog = builder.create()
            dialog.window?.setBackgroundDrawable(null)
            dialog.show()
            dialogOkBTN.setOnClickListener {
                if (index < quiz.size - 1) {
                    index += 1
                    initQuestions()
                    timer.cancel()
                    dialog.cancel()
                    timer.start()
                } else {
                    timer.cancel()
                    dialog.cancel()
                    bundle.putInt("points",resultPoints)
                    bundle.putInt("timeOff",timeOffCounter)
                    findNavController().navigate(R.id.action_questionsFragment_to_resultFragment,bundle)
                }
            }
        }
    }
}


