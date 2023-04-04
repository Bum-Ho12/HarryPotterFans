package com.example.harrypotterfans
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.harrypotterfans.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityMainBinding
    private lateinit var postAdapter: PostAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        postAdapter = PostAdapter(mutableListOf())
        val recycleView = findViewById<RecyclerView>(R.id.myRecycleView)
        val serviceGenerator = ServiceGenerator.buildService(ApiService::class.java)
        val call = serviceGenerator.getCharacters()

        call.enqueue(object:Callback<MutableList<PostModel>>{
            override fun onResponse(
                call: Call<MutableList<PostModel>>,
                response: Response<MutableList<PostModel>>
            ) {

                if (response.isSuccessful){
//                    postAdapter = PostAdapter(response.body()!!)
                    recycleView.apply {
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        adapter = PostAdapter(response.body()!!)
                    }
                    postAdapter.onItemClick={
                        Toast.makeText(this@MainActivity,"You have ${postAdapter.postModel}",Toast.LENGTH_LONG).show()
                        val i = Intent(this@MainActivity,UserActivity::class.java)
                        i.putExtra("id", it)
                        i.putExtra("name",it)
                        i.putExtra("house",it)
                        i.putExtra("alternateName",it)
                        i.putExtra("dateOfBirth",it)
                        i.putExtra("species",it)
                        i.putExtra("gender",it)
                        i.putExtra("ancestry",it)
                        i.putExtra("eyeColor",it)
                        i.putExtra("hairColor",it)
                        i.putExtra("actor",it)
                        i.putExtra("imageId",it)
                        startActivity(i)
                    }
                }

            }


            override fun onFailure(call: Call<MutableList<PostModel>>, t: Throwable) {
                Log.e("error",t.message.toString())
            }

        })


    }
}