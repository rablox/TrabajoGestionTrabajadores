package com.example.trabajogestiontrabajadores.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.trabajogestiontrabajadores.R

class DialogDetalles : DialogFragment() {

    private lateinit var contexto: Context
    private lateinit var textoNombre: TextView
    private lateinit var textoEdad: TextView
    private lateinit var textoCorreo: TextView
    private lateinit var boton: Button


    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.contexto = context
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(contexto)
        val vista = LayoutInflater.from(context).inflate(R.layout.dialogo_detalles, null)
        textoEdad = vista.findViewById(R.id.texto_edad)
        textoCorreo = vista.findViewById(R.id.texto_correo)
        textoNombre = vista.findViewById(R.id.texto_nombre)
        boton = vista.findViewById(R.id.boton_dialogo)
        builder.setView(vista)
        return builder.create()
    }

    override fun onStart() {
        super.onStart()
        textoNombre.text = this.arguments?.getString("nombre")
        textoCorreo.text = this.arguments?.getString("correo")
        textoEdad.text = this.arguments?.getString("edad")
        boton.setOnClickListener { dismiss() }
    }
}