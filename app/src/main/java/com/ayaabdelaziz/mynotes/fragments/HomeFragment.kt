package com.ayaabdelaziz.mynotes.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion
import androidx.navigation.fragment.findNavController
import com.ayaabdelaziz.mynotes.R
import com.ayaabdelaziz.mynotes.fragments.adapter.NoteAdapter
import com.ayaabdelaziz.mynotes.viewmodel.NoteViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.withContext


class HomeFragment : Fragment() {

    private lateinit var noteViewModel: NoteViewModel
    private lateinit var noteAdapter: NoteAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        noteViewModel = ViewModelProvider(this)[NoteViewModel::class.java]
        btn.setOnClickListener {
            findNavController().navigate(R.id.createNoteFragment)
        }
        noteViewModel.notes.observe(this, {
            noteAdapter = NoteAdapter()
            noteAdapter.setData(it)
//            Log.d("aya", "onViewCreated:${it[1].subTitle.toString()} ")
//            Toast.makeText(requireContext(), "${it[1].subTitle.toString()}", Toast.LENGTH_SHORT).show()
            recycler_view.adapter = noteAdapter
        })


    }


}