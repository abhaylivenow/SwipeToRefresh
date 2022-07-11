package com.example.swipetorefreshdemo

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var rv: RecyclerView
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    var listOfCourse = mutableListOf<CourseModel>()
    var rvAdapter = Adapter(listOfCourse)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionBar = supportActionBar
        actionBar?.title = ("GFG | SwipeToRefresh")
        actionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#0F9D58")))

        rv = findViewById(R.id.rv)
        swipeRefreshLayout = findViewById(R.id.refresh_layout)

        listOfCourse.add(
            CourseModel(
                courseImage = R.drawable.course1_image,
                courseDes = "This is the course description....",
                courseName = "Java Spring Boot",
                coursePrice = 1000
            )
        )

        listOfCourse.add(
            CourseModel(
                courseImage = R.drawable.course2_image,
                courseDes = "This is the course description....",
                courseName = "Android developer",
                coursePrice = 3000
            )
        )

        listOfCourse.add(
            CourseModel(
                courseImage = R.drawable.course3_image,
                courseDes = "This is the course description....",
                courseName = "Web developer",
                coursePrice = 3000
            )
        )

        listOfCourse.add(
            CourseModel(
                courseImage = R.drawable.course4_image,
                courseDes = "This is the course description....",
                courseName = "Machine Learning",
                coursePrice = 3000
            )
        )

        listOfCourse.add(
            CourseModel(
                courseImage = R.drawable.course5_image,
                courseDes = "This is the course description....",
                courseName = "Backend developer",
                coursePrice = 3000
            )
        )

        listOfCourse.add(
            CourseModel(
                courseImage = R.drawable.course1_image,
                courseDes = "This is the course description....",
                courseName = "FullStack developer",
                coursePrice = 3000
            )
        )

        listOfCourse.add(
            CourseModel(
                courseImage = R.drawable.course2_image,
                courseDes = "This is the course description....",
                courseName = "Data Scientist",
                coursePrice = 1000
            )
        )

        listOfCourse.add(
            CourseModel(
                courseImage = R.drawable.course3_image,
                courseDes = "This is the course description....",
                courseName = "UI/UX Developer",
                coursePrice = 3000
            )
        )

        listOfCourse.add(
            CourseModel(
                courseImage = R.drawable.course4_image,
                courseDes = "This is the course description....",
                courseName = "Software Testing",
                coursePrice = 3000
            )
        )

        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = rvAdapter

        swipeRefreshLayout.setOnRefreshListener {
            Handler().postDelayed({
                addNewCourse()
            },2000)
        }
    }

    private fun addNewCourse() {
        val listOfImages = listOf(
            R.drawable.course1_image,
            R.drawable.course2_image,
            R.drawable.course3_image,
            R.drawable.course4_image,
            R.drawable.course5_image
        )

        val listOfCourseName = listOf(
            "Android Developer",
            "FullStack Developer",
            "Java Backend Developer",
            "Frontend Developer"
        )

        val courseModel = CourseModel(
            coursePrice = 2000,
            courseName = listOfCourseName[Random.nextInt(listOfCourseName.size)],
            courseImage = listOfImages[Random.nextInt(listOfImages.size)],
            courseDes = "This is the course description...."
        )

        listOfCourse.add(0,courseModel)
        swipeRefreshLayout.isRefreshing = false
        rvAdapter.notifyDataSetChanged()
    }
}







