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
//        val noteTitle = title.text.toString()
//        val noteSubTitle = note_sub_title.text.toString()
//        val noteDesc = desc.text.toString()

        icon_done.setOnClickListener {
            var note = Note()
            viewChange.setBackgroundColor(Color.parseColor(selectcolor))
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
                    selectcolor = intent!!.getStringExtra("selectedColor")!!
                    viewChange.setBackgroundColor(Color.parseColor(selectcolor))

                }
                "green" -> {
                    selectcolor = intent!!.getStringExtra("selectedColor")!!
                    viewChange.setBackgroundColor(Color.parseColor(selectcolor))

                }
                "orange" -> {
                    selectcolor = intent!!.getStringExtra("selectedColor")!!
                    viewChange.setBackgroundColor(Color.parseColor(selectcolor))

                }
                "mary" -> {
                    selectcolor = intent!!.getStringExtra("selectedColor")!!
                    viewChange.setBackgroundColor(Color.parseColor(selectcolor))

                }
                "purple" -> {
                    selectcolor = intent!!.getStringExtra("selectedColor")!!
                    viewChange.setBackgroundColor(Color.parseColor(selectcolor))

                }
                "yellow" -> {
                    selectcolor = intent!!.getStringExtra("selectedColor")!!
                    viewChange.setBackgroundColor(Color.parseColor(selectcolor))

                }
                "black" -> {
                    selectcolor = intent!!.getStringExtra("selectedColor")!!
                    viewChange.setBackgroundColor(Color.parseColor(selectcolor))

                }
                else -> {
                    selectcolor = intent!!.getStringExtra("selectedColor")!!
                    viewChange.setBackgroundColor(Color.parseColor(selectcolor))
                }
            }
        }

    }

    override fun onDestroy() {
        LocalBroadcastManager.getInstance(requireContext()).unregisterReceiver(broadcastReceiver)
        super.onDestroy()

    }
}