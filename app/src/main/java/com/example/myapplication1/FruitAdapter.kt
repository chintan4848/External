package com.example.myapplication1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication1.MainActivity
import com.example.myapplication1.R
import kotlinx.android.synthetic.main.card_view.view.*
import kotlinx.android.synthetic.main.card_view.view.*


class FruitAdapter(val context:Context, var arr:ArrayList<fruit>)
    :RecyclerView.Adapter<FruitAdapter.PersonViewHolde>()

{


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolde {
       var inflater=LayoutInflater.from(parent.context)
       var view= inflater.inflate(R.layout.card_view,parent,false)
        return PersonViewHolde(view)
    }

    override fun onBindViewHolder(holder: PersonViewHolde, position: Int) {
        holder.bind(arr[position])

        holder.view.imgdelete.setOnClickListener {
            if(context is Viewall)
            {
                context.delete(position)
            }
        }
        holder.view.imgupdate.setOnClickListener{

            if(context is Viewall)
                context.update(position)
        }

    }

    override fun getItemCount(): Int {
        return  arr.size
    }

    class PersonViewHolde(var view:View):RecyclerView.ViewHolder(view)
    {
        fun bind(p:fruit)
        {
            //set value of card view
            view.tvname.setText(p.fr_name)
            view.tvdes.setText(p.fr_des)
            view.tvprice.setText(p.fr_price.toString())

        }
    }
}