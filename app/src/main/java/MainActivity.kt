package com.example.platformbasedcriticalthinkingthree
import ListManager
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {  // Extend AppCompatActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)  // Call the parent class method
        setContentView(R.layout.activity_main)  // Link to the XML layout


        val myManager = ListManager()

        val buttonForTaskAdd = findViewById<Button>(R.id.buttonForTaskAdd)
        val textFieldForTasks = findViewById<EditText>(R.id.textFieldForTasks)
        val markTaskDoneButton = findViewById<Button>(R.id.markTaskDoneButton)
        val textFieldForID = findViewById<EditText>(R.id.textFieldForID)
        val spaceForTaskList = findViewById<TextView>(R.id.spaceForTaskList)

        buttonForTaskAdd.setOnClickListener {
            val taskName = textFieldForTasks.text.toString()
            if (taskName.isNotEmpty()) {
                myManager.addItem(taskName)
                spaceForTaskList.setText(myManager.showAllTasks().toString())
            }
        }

        markTaskDoneButton.setOnClickListener {
            val finishedTaskID = textFieldForID.text.toString().toInt()
            if (finishedTaskID.toString().isNotEmpty() && finishedTaskID.toString()
                    .toIntOrNull() != null
            ) {
                myManager.markItemAsComplete(finishedTaskID)
                spaceForTaskList.setText(myManager.showAllTasks().toString())
            }

        }
    }
}







