package com.example.noteit
import android.content.Context
import android.view.LayoutInflater
import android.view.OrientationEventListener
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteRVAdapter(private val context: Context, private val listener:NoteClicked): RecyclerView.Adapter<NoteRVAdapter.NoteViewHolder>() {

    val allNotes = ArrayList<Note>()
    inner class NoteViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        val textView:TextView=itemView.findViewById(R.id.text)
        val deletebutton:ImageView=itemView.findViewById(R.id.deletebutton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {

        val viewHolder= NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.item_note,parent,false))
        viewHolder.deletebutton.setOnClickListener{
            listener.OnNoteItemClicked(allNotes[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote=allNotes[position]
        holder.textView.text= currentNote.text


    }

    override fun getItemCount(): Int {
       return allNotes.size

    }

    fun updateList( newList: List<Note>){
        allNotes.clear()
        allNotes.addAll(newList)
        notifyDataSetChanged()
    }


}

interface NoteClicked {
    fun OnNoteItemClicked(note: Note)
}