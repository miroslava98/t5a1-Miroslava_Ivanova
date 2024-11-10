package com.example.t5a1_ivanova_miroslava

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.t5a1_ivanova_miroslava.databinding.ItemComidaBinding

class ComidaAdaptador(private val comidas: List<Comida>, private val listener: OnClickListener) :
    RecyclerView.Adapter<ComidaAdaptador.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder { //Inflar la vista en el Recycler
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_comida, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val comida = comidas.get(position)
        with(holder) {
            setListener(comida)
            binding.textoComida.text = comida.nombre
            binding.textoPais.text = comida.pais
            Glide.with(context)
                .load(comida.url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .into(binding.img)
        }
    }

    override fun getItemCount(): Int = comidas.size


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val binding = ItemComidaBinding.bind(view)

        fun setListener(comida:Comida){
            binding.root.setOnClickListener{
                listener.onClick(comida)
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(comida.urlWikipedia)
                context.startActivity(intent)
            }
        }


    }

}