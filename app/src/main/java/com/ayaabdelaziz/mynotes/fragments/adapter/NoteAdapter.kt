package com.ayaabdelaziz.mynotes.fragments.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ayaabdelaziz.mynotes.R
import com.ayaabdelaziz.mynotes.model.Note
import kotlinx.android.synthetic.main.note_item.view.*

class NoteAdapter() : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    var notes: List<Note> = ArrayList<Note>()

    fun setData(note: List<Note>) {
        this.notes = note
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.noteTitle.text = notes[position].title
        holder.noteDate.text = notes[position].date
        holder.noteDesc.text = notes[position].noteDesc

        if(notes[position].color != null){
            holder.itemView.cardView.setCardBackgroundColor(Color.parseColor(notes[position].color))
        }else{
            holder.itemView.cardView.setCardBackgroundColor(Color.parseColor(R.color.colorlightblack.toString()))

        }

//        holder.itemView.row.setOnClickListener {
//            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(list[position])
//            holder.itemView.findNavController().navigate(action)
//        }
    }

    override fun getItemCount(): Int = notes.size
    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var noteTitle = itemView.tv_title
        var noteDate = itemView.tv_date
        var noteDesc = itemView.tv_desc
    }

}