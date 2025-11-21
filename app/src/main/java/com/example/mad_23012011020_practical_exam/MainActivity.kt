package com.example.mad_23012011020_practical_exam

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {

    private lateinit var selectedTab: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize UI components
        setupBuyTicketButton()
        setupCalendarButton()
        setupTabSelection()
    }

    private fun setupBuyTicketButton() {
        val buyTicketButton = findViewById<Button>(R.id.buy_ticket_button)
        buyTicketButton.setOnClickListener {
            Toast.makeText(this@MainActivity, "Redirecting to ticket purchase...", Toast.LENGTH_SHORT).show()
            // Add your ticket purchase logic here
        }
    }

    private fun setupCalendarButton() {
        val calendarButton = findViewById<ImageButton>(R.id.calendar_button)
        calendarButton.setOnClickListener {
            Toast.makeText(this@MainActivity, "Adding to calendar...", Toast.LENGTH_SHORT).show()
            // Add calendar integration logic here
        }
    }

    private fun setupTabSelection() {
        // Initialize tabs
        val tabAll = findViewById<TextView>(R.id.tab_all)
        val tabNetworking = findViewById<TextView>(R.id.tab_networking)
        val tabWorkshop = findViewById<TextView>(R.id.tab_workshop)

        // Set initial selected tab
        selectedTab = tabAll
        updateTabAppearance()

        // Set click listeners for tabs
        tabAll.setOnClickListener {
            selectedTab = tabAll
            updateTabAppearance()
            showTabContent("ALL")
        }

        tabNetworking.setOnClickListener {
            selectedTab = tabNetworking
            updateTabAppearance()
            showTabContent("NETWORKING")
        }

        tabWorkshop.setOnClickListener {
            selectedTab = tabWorkshop
            updateTabAppearance()
            showTabContent("WORKSHOP")
        }
    }

    private fun updateTabAppearance() {
        // Reset all tabs to default appearance
        val tabAll = findViewById<TextView>(R.id.tab_all)
        val tabNetworking = findViewById<TextView>(R.id.tab_networking)
        val tabWorkshop = findViewById<TextView>(R.id.tab_workshop)

        tabAll.setBackgroundResource(R.drawable.tab_background_unselected)
        tabNetworking.setBackgroundResource(R.drawable.tab_background_unselected)
        tabWorkshop.setBackgroundResource(R.drawable.tab_background_unselected)

        tabAll.setTextColor(getColor(R.color.tab_text_unselected))
        tabNetworking.setTextColor(getColor(R.color.tab_text_unselected))
        tabWorkshop.setTextColor(getColor(R.color.tab_text_unselected))

        // Set selected tab appearance
        selectedTab.setBackgroundResource(R.drawable.tab_background_selected)
        selectedTab.setTextColor(getColor(R.color.tab_text_selected))
    }

    private fun showTabContent(tabName: String) {
        // Update schedule content based on selected tab
        val scheduleTitle = findViewById<TextView>(R.id.schedule_title)
        val scheduleTime = findViewById<TextView>(R.id.schedule_time)

        when (tabName) {
            "ALL" -> {
                scheduleTitle.text = "Opening Ceremony"
                scheduleTime.text = "9:00 AM"
            }
            "NETWORKING" -> {
                scheduleTitle.text = "Networking Session"
                scheduleTime.text = "10:30 AM"
            }
            "WORKSHOP" -> {
                scheduleTitle.text = "Tech Workshop"
                scheduleTime.text = "2:00 PM"
            }
        }
    }
}