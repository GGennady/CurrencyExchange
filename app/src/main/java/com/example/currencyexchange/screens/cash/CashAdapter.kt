package com.example.currencyexchange.screens.cash

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyexchange.R
import com.example.currencyexchange.databinding.ItemMoneyBinding
import com.example.currencyexchange.model.cash.CashItem

class CashAdapter: RecyclerView.Adapter<CashAdapter.CashViewHolder> () {

    private var listCashItems = emptyList<CashItem>()

    class CashViewHolder(item: View): RecyclerView.ViewHolder(item){
        val binding = ItemMoneyBinding.bind(item)
        fun bind(cashItem: CashItem) = with(binding) {
            currencyName.text = cashItem.Name
            todayValue.text = cashItem.Value.toString()
            previousValue.text = cashItem.Previous.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CashViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_money, parent, false)
        return CashViewHolder(view)
    }


    override fun onBindViewHolder(holder: CashViewHolder, position: Int) {
        holder.bind(listCashItems[position])
    }

    override fun getItemCount(): Int {
        return listCashItems.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<CashItem>) {
        listCashItems = list
        notifyDataSetChanged()
    }
}