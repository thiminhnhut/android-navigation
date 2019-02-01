package io.github.thiminhnhut.bottomnavigationview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import io.github.thiminhnhut.bottomnavigationview.view.SearchFragment
import io.github.thiminhnhut.bottomnavigationview.view.FavoritesFragment
import io.github.thiminhnhut.bottomnavigationview.view.HomeFragment
import android.support.v4.app.Fragment
import android.view.MenuItem

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.setOnNavigationItemSelectedListener(navListener)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment())
                .commit()
        }
    }

    private val navListener = object : BottomNavigationView.OnNavigationItemSelectedListener {
        override fun onNavigationItemSelected(item: MenuItem): Boolean {
            var selectedFragment: Fragment? = null

            when (item.itemId) {
                R.id.nav_home -> selectedFragment = HomeFragment()
                R.id.nav_favorites -> selectedFragment = FavoritesFragment()
                R.id.nav_search -> selectedFragment = SearchFragment()
            }

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, selectedFragment!!)
                .commit()

            return true
        }
    }
}
