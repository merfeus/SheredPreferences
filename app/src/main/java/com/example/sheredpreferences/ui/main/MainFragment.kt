package com.example.sheredpreferences.ui.main

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.content.edit
import com.example.sheredpreferences.R

class MainFragment : Fragment() {

    private lateinit var preferences : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        preferences = requireActivity().getSharedPreferences("preferences_session", Context.MODE_PRIVATE)
        val inputEmailTextView = view.findViewById<EditText>(R.id.editTextEmail)

        val emailSalvo = preferences.getString("chave_email", "")
        if (!emailSalvo.isNullOrEmpty()){
            inputEmailTextView.setText(emailSalvo)
        }

        view.findViewById<Button>(R.id.buttonSave).apply {
            setOnClickListener{
                preferences.edit {
                    putString("chave_email", inputEmailTextView.text.toString())
                    commit()
                }
            }
        }

    }

}