package com.ayaabdelaziz.mynotes.fragments

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.navigation.fragment.findNavController
import com.ayaabdelaziz.mynotes.R
import com.ayaabdelaziz.mynotes.model.Note
import com.ayaabdelaziz.mynotes.util.BottomSheetFragment
import com.ayaabdelaziz.mynotes.viewmodel.NoteViewModel
import kotlinx.android.synthetic.main.fragment_create_note.*
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*


class CreateNoteFragment : Fragment() {

    private lateinit var noteViewModel: NoteViewModel
    var selectcolor = "#171515"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_note, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        noteViewModel = ViewModelProvider(this)[NoteViewModel::class.java]

        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val currentDate = sdf.format(Date())
        date.text = currentDate.toString()
//        viewChange.setBackgroundColor(Color.parseColor(selectcolor))
//        val noteTitle = title.text.toString()
//        val noteSubTitle = note_sub_title.text.toString()
//        val noteDesc = desc.text.toString()

        icon_done.setOnClickListener {
            var note = Note()
            note.title = title.text.toString()
            note.subTitle = note_sub_title.text.toString()
            note.noteDesc = desc.text.toString()
            note.color = selectcolor
            note.date = currentDate
            noteViewModel.insertNote(note)
            Toast.makeText(requireContext(), "Added successfully", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.homeFragment)
        }
        LocalBroadcastManager.getInstance(requireContext())
            .registerReceiver(broadcastReceiver, IntentFilter("bottom_sheet_action"))
        icon_back.setOnClickListener {
            findNavController().navigate(R.id.homeFragment)
        }
        ivMore.setOnClickListener {
            var noteBottomSheetFragment = BottomSheetFragment.getInstance()
            noteBottomSheetFragment.show(
                requireActivity().supportFragmentManager,
                "Note Bottom Sheet Fragment"
            )
        }
    }

    private val broadcastReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            var actioncolor = intent!!.getStringExtra("actionColor")

            when (actioncolor) {
                "blue" -> {
                    try {
                        selectcolor = intent!!.getStringExtra("selectedColor")!!
                        viewChange.setBackgroundColor(Color.parseColor(selectcolor))
                    }catch (e : Exception){
                        Toast.makeText(requireContext(), "${e.printStackTrace()}", Toast.LENGTH_SHORT).show()
                    }


                }
                "green" -> {
                    try {
                        selectcolor = intent!!.getStringExtra("selectedColor")!!
                        viewChange.setBackgroundColor(Color.parseColor(selectcolor))
                    }catch (e : Exception){
                        Toast.makeText(requireContext(), "${e.printStackTrace()}", Toast.LENGTH_SHORT).show()
                    }


                }
                "orange" -> {
                    try {
                        selectcolor = intent!!.getStringExtra("selectedColor")!!
                        viewChange.setBackgroundColor(Color.parseColor(selectcolor))
                    }catch (e : Exception){
                        Toast.makeText(requireContext(), "${e.printStackTrace()}", Toast.LENGTH_SHORT).show()
                    }

                }
                "mary" -> {
                    try {
                        selectcolor = intent!!.getStringExtra("selectedColor")!!
                        viewChange.setBackgroundColor(Color.parseColor(selectcolor))
                    }catch (e : Exception){
                        Toast.makeText(requireContext(), "${e.printStackTrace()}", Toast.LENGTH_SHORT).show()
                    }

                }
                "purple" -> {
                    try {
                        selectcolor = intent!!.getStringExtra("selectedColor")!!
                        viewChange.setBackgroundColor(Color.parseColor(selectcolor))
                    }catch (e : Exception){
                        Toast.makeText(requireContext(), "${e.printStackTrace()}", Toast.LENGTH_SHORT).show()
                    }

                }
                "yellow" -> {
                    try {
                        selectcolor = intent!!.getStringExtra("selectedColor")!!
                        viewChange.setBackgroundColor(Color.parseColor(selectcolor))
                    }catch (e : Exception){
                        Toast.makeText(requireContext(), "${e.printStackTrace()}", Toast.LENGTH_SHORT).show()
                    }

                }
                "black" -> {
                    try {
                        selectcolor = intent!!.getStringExtra("selectedColor")!!
                        viewChange.setBackgroundColor(Color.parseColor(selectcolor))
                    }catch (e : Exception){
                        Toast.makeText(requireContext(), "${e.printStackTrace()}", Toast.LENGTH_SHORT).show()
                    }

                }
                else -> {
                    try {
                        selectcolor = intent!!.getStringExtra("selectedColor")!!
                        viewChange.setBackgroundColor(Color.parseColor(selectcolor))
                    }catch (e : Exception){
                        Toast.makeText(requireContext(), "${e.printStackTrace()}", Toast.LENGTH_SHORT).show()
                    }

                }
            }
        }

    }

    override fun onDestroy() {
        LocalBroadcastManager.getInstance(requireContext()).unregisterReceiver(broadcastReceiver)
        super.onDestroy()

    }
}