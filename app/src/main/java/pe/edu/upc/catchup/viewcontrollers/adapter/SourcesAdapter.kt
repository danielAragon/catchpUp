package pe.edu.upc.catchup.viewcontrollers.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_source.view.*
import pe.edu.upc.catchup.R
import pe.edu.upc.catchup.models.Source

class SourcesAdapter(val sources: List<Source>, val context: Context) : RecyclerView.Adapter<SourcesAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        return ViewHolder(
                LayoutInflater.from(context)
                        .inflate(R.layout.item_source,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return sources.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var source = sources.get(position)
        holder.nameTextView.text = source.name
        //TODO: Assign picture
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val pictureImageView = view.logoImageView
        val nameTextView = view.nameTextView
    }
}