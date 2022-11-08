package com.example.cardview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    lateinit var recycler : RecyclerView
    lateinit var button: FloatingActionButton
    var selected : Int = -1
     var elem : Pair<String,Int>? = null
    var index : Int = -1
    //private val dataList = List<Pair<String,Int>>(1000)
    private val list = ArrayList<Pair<String,Int>>()
    private lateinit var adapter: CustomAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list.add(

            Pair("Ariana", R.drawable.ariana)
        )
        list.add(
            Pair("Béja", R.drawable.tunis)
        )
        list.add(
            Pair("Ben Arous", R.drawable.ben3rouss)
        )
        list.add(
            Pair("Bizerte", R.drawable.bizerte)
        )
        list.add(
            Pair("Gabès", R.drawable.gabess)
        )
        list.add(
            Pair("Gafsa", R.drawable.gafsa)
        )
        list.add(
            Pair("Jendouba", R.drawable.tunis)
        )
        list.add(
            Pair("Kairaouen", R.drawable.tunis)
        )
        list.add(
            Pair("Kasserine", R.drawable.kasserinee)
        )
        list.add(
            Pair("Kébili", R.drawable.tunis)
        )
        list.add(
            Pair("Le Kef", R.drawable.kef)
        )
        list.add(
            Pair("Mahdia", R.drawable.tunis)
        )
        list.add(
            Pair("Médenine", R.drawable.tunis)
        )
        list.add(
            Pair("Monastir", R.drawable.monastiiir)
        )
        list.add(
            Pair("Nabeul", R.drawable.nabel)
        )
        list.add(
            Pair("Sfax", R.drawable.sfax)
        )
        list.add(
                Pair("Sidi Bouzid", R.drawable.sidi_bouzid)
        )
        list.add(
            Pair("Siliana", R.drawable.siliana)
        )
        list.add(
            Pair("Sousse", R.drawable.tunis)
        )
        list.add(
            Pair("Tataouine", R.drawable.tunis)
        )
        list.add(
            Pair("Tozeur", R.drawable.tozeeuur)
        )
        list.add(
            Pair("Tunis", R.drawable.nabel)
        )
        list.add(
            Pair("Zaghouan", R.drawable.tunis)
        )



        button = findViewById(R.id.float_button)
        recycler = findViewById(R.id.recycleView)


        //create adapter
        adapter = CustomAdapter(list)
        //create layoutManager of recycler
        val layoutRecycler = LinearLayoutManager(applicationContext)
        //add layoutManager to recycle
        recycler.layoutManager=layoutRecycler


        //link adapter to recycler
        recycler.adapter = adapter


        adapter.setOnItemClickListener(object : CustomAdapter.onItemClickListener{


            override fun onItemClick(position: Int) {
               index = position
                button.setOnClickListener {
                    list.remove(list.get(index))
                    adapter.notifyItemRemoved(position)
                    adapter.notifyItemRangeChanged(position, list.size)
                    adapter.notifyDataSetChanged()

                }

            }

        })
    }
}


