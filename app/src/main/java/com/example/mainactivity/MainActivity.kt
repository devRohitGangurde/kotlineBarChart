package com.example.mainactivity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mainactivity.model.BarChart
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.bottom_sheet_layout.view.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView
        //adding a layoutmanager
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        val barchatData = ArrayList<BarChart>()
        //adding some dummy data to the list
        barchatData.add(BarChart("bar chart 1"))
        barchatData.add(BarChart("bar chart 2"))
        barchatData.add(BarChart("bar chart 3"))
        //creating our adapter
        val adapter = BarChartAdapter(barchatData)
        //now adding the adapter to recyclerview
        recyclerView.adapter = adapter
        val btn_sort_by = findViewById(R.id.btn_sort_by) as LinearLayout

        btn_sort_by.setOnClickListener(View.OnClickListener {
            showBottomSheetDialog();
        })

    }
    private fun showBottomSheetDialog() {
        val view = layoutInflater.inflate(R.layout.bottom_sheet_layout, null)
        val dialog = BottomSheetDialog(this,R.style.BottomSheetDialog)

        dialog.setContentView(view)
        view.textViewTotalSales.setOnClickListener {
//            Toast.makeText(this, "", Toast.LENGTH_SHORT).show()
        }
        view.textViewAddToCart.setOnClickListener {
            Toast.makeText(this, "Click item 1", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        view.textViewDownloads.setOnClickListener {
            Toast.makeText(this, "Click item 2", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        view.textViewUserSessions.setOnClickListener {
            Toast.makeText(this, "Click item 3", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        view.textViewSortBy.setOnClickListener {
            Toast.makeText(this, "Click item 4", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        dialog.show()
    }
}
