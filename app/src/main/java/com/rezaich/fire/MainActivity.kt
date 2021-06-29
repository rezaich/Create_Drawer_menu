package com.rezaich.fire

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var actionBarToggle: ActionBarDrawerToggle
    private lateinit var navDrawerView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //call findByid on the drawerLayout
        drawerLayout = findViewById(R.id.activity_main)

        //pass the actionToggle action into the drawerlistener
        actionBarToggle = ActionBarDrawerToggle(this, drawerLayout, 0, 0)
        drawerLayout.addDrawerListener(actionBarToggle)

        // display the hamburger icon to lunch the drawer
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // call syncState() on actiom bar so it'll automatically
        //change to the back button when the drawer layout is open
        actionBarToggle.syncState()

        navDrawerView = findViewById(R.id.navDrawer)

        navDrawerView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.myProfile -> {
                    Toast.makeText(this, "Go to my porfile", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.myEmployee -> {
                    Toast.makeText(this, "Go to our employee", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.register -> {
                    Toast.makeText(this, "Go to register now", Toast.LENGTH_SHORT).show()
                    true
                } else -> (false)
            }
        }
    }
    
    override fun onSupportNavigateUp(): Boolean {
        if(this.drawerLayout.isDrawerOpen(GravityCompat.START)){
            this.drawerLayout.closeDrawer(GravityCompat.START)
        }else {
            this.drawerLayout.openDrawer(GravityCompat.START)
        }
        return true
    }
}