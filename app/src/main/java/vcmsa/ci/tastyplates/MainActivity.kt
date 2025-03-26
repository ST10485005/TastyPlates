package vcmsa.ci.tastyplates

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // Get references to UI elements
        val inputTime = findViewById<EditText>(R.id.inputTime)
        val btnSuggest = findViewById<Button>(R.id.btnSuggest)
        val tvSuggestion = findViewById<TextView>(R.id.tvSuggestion)
        val btnReset = findViewById<Button>(R.id.btnReset)

        // Button click event to suggest a meal
        btnSuggest.setOnClickListener {
            val timeOfDay = inputTime.text.toString().trim().lowercase()

            // Use when statement to determine the meal
            val mealSuggestion = when (timeOfDay) {
                "morning" -> "Breakfast: Scrambled Eggs with one slice of Toast"
                "mid-morning" -> "Snack: Fruit slices or an Oats Bar"
                "afternoon" -> "Lunch: Chicken Sandwich"
                "mid-afternoon" -> "Snack: Carrot Cake"
                "dinner" -> "Main Course: Pasta"
                "dessert" -> "Dessert: Ice Cream"
                else -> {
                    Toast.makeText(this, "Invalid input! Please enter a valid time of day.", Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }
            }

            // Display the meal suggestion
            tvSuggestion.text = mealSuggestion
        }

        // Button click event to reset fields
        btnReset.setOnClickListener {
            inputTime.text.clear()
            tvSuggestion.text = "Meal Suggestion will appear here"
        }
    }
}