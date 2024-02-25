package com.hw5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.hw5.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            textTvWorks.text = null
            txtResult.text = null
            nm0.appendClick("0")
            nm1.appendClick("1")
            nm2.appendClick("2")
            nm3.appendClick("3")
            nm4.appendClick("4")
            nm5.appendClick("5")
            nm6.appendClick("6")
            nm7.appendClick("7")
            nm8.appendClick("8")
            nm9.appendClick("9")
            btnAC.setOnClickListener {
                binding.txtResult.text = ""
                binding.textTvWorks.text = null
            }
            btnModu.appendClick("%")
            btnposNeg.appendClick("*(-1)")
            cikarma.appendClick("-")
            toplama.appendClick("+")
            carpma.appendClick("*")
            bolme.appendClick("/")
            virgul.appendClick(".")

            esittir.setOnClickListener {
                try {
                    val expression = ExpressionBuilder(binding.textTvWorks.text.toString()).build()
                    val result = expression.evaluate()
                    val longResult = result.toLong()

                    if (result == longResult.toDouble()){
                        binding.txtResult.text = longResult.toString()
                    }else{
                        binding.txtResult.text = result.toString()
                    }
                }catch (e:Exception){
                    Log.d("Exception","Message : ${e.message}")
                }
            }
        }
    }

    private fun View.appendClick(string: String) {
        setOnClickListener {
            binding.textTvWorks.append(string)

        }
    }


}