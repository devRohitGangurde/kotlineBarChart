package com.example.mainactivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mainactivity.model.BarChart
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import kotlinx.android.synthetic.main.list_layout.view.*


class BarChartAdapter(val userList: ArrayList<BarChart>) : RecyclerView.Adapter<BarChartAdapter.ViewHolder>() {
    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BarChartAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_layout, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: BarChartAdapter.ViewHolder, position: Int) {
        setBarChart(holder)
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return userList.size
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val barChart = itemView.barChart
    }
    private fun setBarChart(holder: ViewHolder) {
        val entries = ArrayList<BarEntry>()
        entries.add(BarEntry(4f, 0))
        entries.add(BarEntry(8f, 1))
        entries.add(BarEntry(12f, 2))
        entries.add(BarEntry(16f, 3))
        entries.add(BarEntry(10f, 4))
        entries.add(BarEntry(18f, 5))
        entries.add(BarEntry(20f, 6))
        val barDataSet = BarDataSet(entries, "Cells")

        val labels = ArrayList<String>()
        labels.add("JAN")
        labels.add("FEB")
        labels.add("MAR")
        labels.add("APR")
        labels.add("MAY")
        labels.add("JUN")
        labels.add("JUL")
        val data = BarData(labels, barDataSet)
        holder.barChart.data = data // set the data and list of lables into chart
        holder.barChart.setDescription("")  // set the description
        holder.barChart.animateY(1000)
        holder.barChart.getXAxis().setEnabled(false);
        val rightYAxis: YAxis =  holder.barChart.getAxisRight()
        rightYAxis.isEnabled = false
    }
}