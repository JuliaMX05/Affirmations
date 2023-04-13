package com.example.affirmations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.R
import com.example.affirmations.model.Affirmation

//Адаптер для [RecyclerView] в [MainActivity]. Отображает объект данных [Affirmation]

class ItemAdapter(
    private val context:Context,
    private val dataset:List<Affirmation>
    ) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    // Предоставьте ссылку на представления для каждого элемента данных.
    // Для сложных элементов данных может потребоваться более одного представления на элемент, и
    // вы предоставляете доступ ко всем представлениям для элемента данных в держателе представления.
    // Каждый элемент данных - это просто объект Affirmation.
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }

    //Создание новых представлений (вызывается менеджером компоновки)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
    // создаем новое представление
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    //Возвращает размер вашего набора данных (вызывается менеджером компоновки)
    override fun getItemCount() = dataset.size

    //Заменить содержимое представления (вызывается менеджером компоновки)
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.imageView.setImageResource(item.imageResourceId)
        holder.textView.text = context.resources.getString(item.stringResourceId)
    }
}