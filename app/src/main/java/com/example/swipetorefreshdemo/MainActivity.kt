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

        // set background color and title over the action bar
        val actionBar = supportActionBar
        actionBar?.title = ("GFG | SwipeToRefresh")
        actionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#0F9D58")))

        // init recycler view
        rv = findViewById(R.id.rv)
        swipeRefreshLayout = findViewById(R.id.refresh_layout)

        // add random courses to the list
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

        // add 2 second delay before the course is added so that it mimic the network call
        swipeRefreshLayout.setOnRefreshListener {
            Handler().postDelayed({
                addNewCourse()
            },2000)
        }
    }

    // this method will add new course to the course list
    private fun addNewCourse() {
        // list of images to be chosen randomly for newly added course
        val listOfImages = listOf(
            R.drawable.course1_image,
            R.drawable.course2_image,
            R.drawable.course3_image,
            R.drawable.course4_image,
            R.drawable.course5_image
        )

        // list of course name that can be chosen randomly for newly added course
        val listOfCourseName = listOf(
            "Android Developer",
            "FullStack Developer",
            "Java Backend Developer",
            "Frontend Developer"
        )

        // this will create a new course randomly
        val courseModel = CourseModel(
            coursePrice = 2000,
            courseName = listOfCourseName[Random.nextInt(listOfCourseName.size)],
            courseImage = listOfImages[Random.nextInt(listOfImages.size)],
            courseDes = "This is the course description...."
        )

        // add the newly created course at the top of the list and update recycler view
        listOfCourse.add(0,courseModel)
        swipeRefreshLayout.isRefreshing = false
        rvAdapter.notifyDataSetChanged()
    }
}







