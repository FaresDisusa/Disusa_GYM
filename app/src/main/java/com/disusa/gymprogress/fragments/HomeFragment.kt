package com.disusa.gymprogress.fragments

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.disusa.gymprogress.R

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)

        val tv: TextView = rootView.findViewById(R.id.nb_steps)
        val futureText = "10 763 STEPS"

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            // API > 30
            val wm = requireContext().getSystemService(Context.WINDOW_SERVICE) as WindowManager?
            val metrics = wm!!.currentWindowMetrics
            val tvGivenWidth = (0.8389f - 0.3241f) * metrics.bounds.width()
            tv.textSize = 18f
            val tv18Width = tv.paint.measureText(futureText)
            tv.textSize = 0.99f * 18f * tvGivenWidth / tv18Width
        } else {
            // API < 30
            val displayMetrics = DisplayMetrics()
            @Suppress("DEPRECATION")
            requireActivity().windowManager.defaultDisplay.getMetrics(displayMetrics)
            val tvGivenWidth = (0.8389f - 0.3241f) * displayMetrics.widthPixels
            tv.textSize = 18f
            val tv18Width = tv.paint.measureText(futureText)
            tv.textSize = 0.99f * 18f * tvGivenWidth / tv18Width
            tv.text = futureText

            return rootView
        }

        return rootView
    }
}
