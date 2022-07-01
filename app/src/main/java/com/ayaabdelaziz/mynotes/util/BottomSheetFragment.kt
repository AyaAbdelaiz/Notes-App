package com.ayaabdelaziz.mynotes.util

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.ayaabdelaziz.mynotes.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.note_bottom_sheet.*

class BottomSheetFragment : BottomSheetDialogFragment() {

    var selectedColor = "#1230DC"

    companion object {
        fun getInstance(): BottomSheetFragment {
            val args = Bundle()
            val fragment = BottomSheetFragment()
            fragment.arguments = args
            return fragment

        }
    }

    override fun setupDialog(dialog: Dialog, style: Int) {
        super.setupDialog(dialog, style)
        val view = LayoutInflater.from(context).inflate(R.layout.note_bottom_sheet, null)
        dialog.setContentView(view)

        val params = (view.parent as View).layoutParams as CoordinatorLayout.LayoutParams
        val behavior = params.behavior

        if (behavior is BottomSheetBehavior<*>) {
            behavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
                override fun onStateChanged(bottomSheet: View, newState: Int) {
                    var state = ""
                    when (newState) {
                        BottomSheetBehavior.STATE_DRAGGING -> state = "DRAGGING"
                        BottomSheetBehavior.STATE_COLLAPSED -> state = "COLLAPSED"
                        BottomSheetBehavior.STATE_SETTLING -> state = "SETTLING"
                        BottomSheetBehavior.STATE_EXPANDED -> state = "EXPANDED"
                        BottomSheetBehavior.STATE_HIDDEN -> {
                            state = "HIDDEN"
                            dismiss()
                            behavior.state = BottomSheetBehavior.STATE_COLLAPSED
                        }
                    }
                }

                override fun onSlide(bottomSheet: View, slideOffset: Float) {
                    TODO("Not yet implemented")
                }

            })
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.note_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListner()
    }

    fun setListner() {
        fNote1.setOnClickListener {
            iv1.setImageResource(R.drawable.ic_done)
            iv2.setImageResource(0)
            iv3.setImageResource(0)
            iv4.setImageResource(0)
            iv5.setImageResource(0)
            iv6.setImageResource(0)
            iv7.setImageResource(0)
            selectedColor = "#1230DC"
            val intent = Intent("bottom_sheet_action")
            intent.putExtra("actionColor", "blue")
            intent.putExtra("selectedColor", selectedColor)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)

        }
        fNote2.setOnClickListener {
            iv2.setImageResource(R.drawable.ic_done)
            iv1.setImageResource(0)
            iv3.setImageResource(0)
            iv4.setImageResource(0)
            iv5.setImageResource(0)
            iv6.setImageResource(0)
            iv7.setImageResource(0)
            selectedColor = "#47B14C"
            val intent = Intent("bottom_sheet_action")
            intent.putExtra("actionColor", "green")
            intent.putExtra("selectedColor", selectedColor)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)


        }
        fNote3.setOnClickListener {
            iv3.setImageResource(R.drawable.ic_done)
            iv2.setImageResource(0)
            iv1.setImageResource(0)
            iv4.setImageResource(0)
            iv5.setImageResource(0)
            iv6.setImageResource(0)
            iv7.setImageResource(0)
            selectedColor = "#FF2929"
            val intent = Intent("bottom_sheet_action")
            intent.putExtra("actionColor", "orange")
            intent.putExtra("selectedColor", selectedColor)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)


        }
        fNote4.setOnClickListener {
            iv4.setImageResource(R.drawable.ic_done)
            iv2.setImageResource(0)
            iv3.setImageResource(0)
            iv1.setImageResource(0)
            iv5.setImageResource(0)
            iv6.setImageResource(0)
            iv7.setImageResource(0)
            selectedColor = "#91113D"
            val intent = Intent("bottom_sheet_action")
            intent.putExtra("actionColor", "mary")
            intent.putExtra("selectedColor", selectedColor)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)


        }
        fNote5.setOnClickListener {
            iv5.setImageResource(R.drawable.ic_done)
            iv2.setImageResource(0)
            iv3.setImageResource(0)
            iv4.setImageResource(0)
            iv1.setImageResource(0)
            iv6.setImageResource(0)
            iv7.setImageResource(0)
            selectedColor = "#673AB7"
            val intent = Intent("bottom_sheet_action")
            intent.putExtra("actionColor", "purple")
            intent.putExtra("selectedColor", selectedColor)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)


        }
        fNote6.setOnClickListener {
            iv6.setImageResource(R.drawable.ic_done)
            iv2.setImageResource(0)
            iv3.setImageResource(0)
            iv4.setImageResource(0)
            iv5.setImageResource(0)
            iv1.setImageResource(0)
            iv7.setImageResource(0)
            selectedColor = "#FFE500"
            val intent = Intent("bottom_sheet_action")
            intent.putExtra("actionColor", "yellow")
            intent.putExtra("selectedColor", selectedColor)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)


        }
        fNote7.setOnClickListener {
            iv7.setImageResource(R.drawable.ic_done)
            iv2.setImageResource(0)
            iv3.setImageResource(0)
            iv4.setImageResource(0)
            iv5.setImageResource(0)
            iv6.setImageResource(0)
            iv1.setImageResource(0)
            selectedColor = "#171515"
            val intent = Intent("bottom_sheet_action")
            intent.putExtra("actionColor", "black")
            intent.putExtra("selectedColor", selectedColor)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)

        }

    }

}