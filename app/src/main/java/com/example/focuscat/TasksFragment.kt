package com.example.focuscat

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isInvisible
import androidx.core.view.isVisible

class TasksFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tasks, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity : MainActivity = context as MainActivity


        val enterTask : EditText = view.findViewById(R.id.enterTask)
        val addTaskBtn : Button = view.findViewById(R.id.addTask)
        val checkbox1 : CheckBox = view.findViewById(R.id.checkBox)
        val checkbox2 : CheckBox = view.findViewById(R.id.checkBox2)
        val checkbox3 : CheckBox = view.findViewById(R.id.checkBox3)
        val checkbox4 : CheckBox = view.findViewById(R.id.checkBox4)
        val checkbox5 : CheckBox = view.findViewById(R.id.checkBox5)
        val checkbox6 : CheckBox = view.findViewById(R.id.checkBox6)
        val checkbox7 : CheckBox = view.findViewById(R.id.checkBox7)
        val checkbox8 : CheckBox = view.findViewById(R.id.checkBox8)
        val checkboxList = listOf(checkbox1, checkbox2, checkbox3, checkbox4, checkbox5, checkbox6, checkbox7, checkbox8)

        // make all the checkboxes invisible
        for (checkbox in checkboxList) {
            checkbox.visibility = View.INVISIBLE
        }

        // when the user clicks the addTaskBtn, a checkbox will appear
        addTaskBtn.setOnClickListener {
            for (checkbox in checkboxList) {
                if (checkbox.isInvisible) {
                    checkbox.visibility = View.VISIBLE

                    // set the checkbox text the same as the task
                    checkbox.text = enterTask.text
                    // clear enterTask text
                    enterTask.text.clear()
                    break
                }
            }
        }

        // if the user checks the checkbox, the checkbox will disappear and the check will get uncheck
        checkbox1.setOnCheckedChangeListener { compoundButton, isChecked ->
            checkboxDisappear(checkbox1)
            // for every task the user completes, they will earn $1 or $2
            activity.addMoney()
        }

        checkbox2.setOnCheckedChangeListener { compoundButton, isChecked ->
            checkboxDisappear(checkbox2)
            activity.addMoney()
        }

        checkbox3.setOnCheckedChangeListener { compoundButton, isChecked ->
            checkboxDisappear(checkbox3)
            activity.addMoney()
        }

        checkbox4.setOnCheckedChangeListener { compoundButton, isChecked ->
            checkboxDisappear(checkbox4)
            activity.addMoney()
        }

        checkbox5.setOnCheckedChangeListener { compoundButton, isChecked ->
            checkboxDisappear(checkbox5)
            activity.addMoney()
        }

        checkbox6.setOnCheckedChangeListener { compoundButton, isChecked ->
            checkboxDisappear(checkbox6)
            activity.addMoney()
        }

        checkbox7.setOnCheckedChangeListener { compoundButton, isChecked ->
            checkboxDisappear(checkbox7)
            activity.addMoney()
        }

        checkbox8.setOnCheckedChangeListener { compoundButton, isChecked ->
            checkboxDisappear(checkbox8)
            activity.addMoney()
        }

    }


    private fun checkboxDisappear(checkBox: CheckBox) {
        checkBox.visibility = View.INVISIBLE
        checkBox.toggle()
    }
}