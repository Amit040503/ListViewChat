package com.example.listviewchat

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var userArrayList : ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


            val name = arrayOf("Shahrokh Khan","Salman Khan",
                "Aamir Khan",
                "deepika","Rashmi","Prabhas",
                "Ranbir Kapoor",
                "Katrina Kaif",
                "Hrithik Roshan",
                "Rajinikanth")
            val lastMsg = arrayOf(    "Shooting in Dubai!",
                "See you at the party!",
                "Script discussion tomorrow.",
                "Back from Cannes ✨",
                "New movie releasing soon 🎬",
                "Baahubali vibes forever!",
                "Just finished a song shoot.",
                "Vacation in Maldives 🌴",
                "Gym time 💪",
                "Fans are amazing ❤️")
            val lastMsgTime = arrayOf(  "10:15 AM",
                "9:00 PM",
                "9:45 PM",
                "8:20 AM",
                "11:52 AM",
                "11:00 PM",
                "9:00 AM",
                "6:30 PM",
                "5:15 AM",
                "7:37 AM")
            val phoneNumber = arrayOf(
                "+91 9972543696",
                "+91 9123456780",
                "+91 9988776655",
                "+91 9876501234",
                "+91 9123409876",
                "+91 9090909090",
                "+91 9000000007",
                "+91 9000000008",
                "+91 9000000009",
                "+91 9000000010")

            val about = arrayOf(
                "King Khan 👑 | Bollywood ka Badshah",
                "Bhai Jaan 🤜🤛 | Always Dabangg",
                "Mr. Perfectionist 🎯 | Thoughtful & Inspiring",
                "Queen of Hearts 👸 | Style Icon",
                "Sunshine Girl 🌸 | Full of Positivity",
                "Rebel Star 🔥 | Action Hero",
                "Charming Kapoor 😎 | Romantic at Heart",
                "Beauty with Grace 🌹 | Always Elegant",
                "Greek God 💪 | Fitness Freak",
                "Thalaiva 🌟 | Legend of Cinema"
            )
            val imageId = intArrayOf(R.drawable.img,R.drawable.img_1 ,
                R.drawable.img_2,R.drawable.img_3,R.drawable.img_4,
                R.drawable.img_5,R.drawable.img_6,R.drawable.img_7,
                R.drawable.img_8,R.drawable.img_9)

            userArrayList= ArrayList()

            for(eachIndex in name.indices){
                val user = User(name[eachIndex],lastMsg[eachIndex],
                    lastMsgTime[eachIndex],phoneNumber[eachIndex],
                    about[eachIndex],
                    imageId[eachIndex])

                userArrayList.add(user)
            }

            val listView= findViewById<ListView>(R.id.listView)
            listView.isClickable=true
            listView.adapter=MyAdapter(this,userArrayList)

            listView.setOnItemClickListener{ parent,view,position,id ->
                // open a new activity

                val userName=name[position]
                val userPhone= phoneNumber[position]
                val imageId=imageId[ position]
                val about=about[position]

                val i= Intent(this, UserActivity::class.java)

                i.putExtra("name",userName)
                i.putExtra("phone",userPhone)
                i.putExtra("imageId",imageId)
                i.putExtra("about",about)
                startActivity(i)

            }

    }


}