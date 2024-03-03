package com.example.trabajogestiontrabajadores.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trabajogestiontrabajadores.databinding.ItemRecyclerBinding
import com.example.trabajogestiontrabajadores.model.Usuario

class UsuarioAdapter(
    private val usuarios: List<Usuario>,
    private val onClick: (Usuario) -> Unit
) : RecyclerView.Adapter<UsuarioAdapter.UsuarioViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UsuarioViewHolder(binding, onClick)
    }

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        val usuario = usuarios[position]
        holder.bind(usuario)
    }

    override fun getItemCount(): Int = usuarios.size

    class UsuarioViewHolder(private val binding: ItemRecyclerBinding, val onClick: (Usuario) -> Unit) : RecyclerView.ViewHolder(binding.root) {
        fun bind(usuario: Usuario) {
            binding.usuarioNombre.text = "${usuario.nombre} ${usuario.apellido}"
            itemView.setOnClickListener {
                onClick(usuario)
            }
        }
    }
}