package com.example.trabajogestiontrabajadores

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trabajogestiontrabajadores.adapter.UsuarioAdapter
import com.example.trabajogestiontrabajadores.databinding.ActivityMainBinding
import com.example.trabajogestiontrabajadores.model.Usuario

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: UsuarioAdapter
    private val usuarios: ArrayList<Usuario> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        setupFormulario()
    }

    private fun setupRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = UsuarioAdapter(usuarios) { usuario ->
            mostrarDetallesUsuario(usuario)
        }
        binding.recyclerView.adapter = adapter
    }

    private fun setupFormulario() {
        binding.botonEnviar.setOnClickListener {
            val nombre = binding.editNombre.text.toString()
            val apellido = binding.editApellido.text.toString()
            val correo = binding.editCorreo.text.toString()
            val edad = binding.editEdad.text.toString().toIntOrNull() ?: 0
            val puesto = binding.spinner.selectedItem.toString()

            val usuario = Usuario(nombre, apellido, correo, edad, puesto)
            usuarios.add(usuario)
            adapter.notifyItemInserted(usuarios.size - 1)

            limpiar()
        }
    }

    private fun limpiar() {
        with(binding) {
            editNombre.text.clear()
            editApellido.text.clear()
            editCorreo.text.clear()
            editEdad.text.clear()
            spinner.setSelection(0)
        }
    }

    private fun mostrarDetallesUsuario(usuario: Usuario) {
        AlertDialog.Builder(this)
            .setTitle("Detalles del Usuario")
            .setMessage("Nombre: ${usuario.nombre}\nApellido: ${usuario.apellido}\nCorreo: ${usuario.correo}\nEdad: ${usuario.edad}\n Puesto: ${usuario.puesto}")
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
}