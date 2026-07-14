package com.garyrex.tiposdepandemo.ui.transform

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.garyrex.tiposdepandemo.R
import com.garyrex.tiposdepandemo.databinding.FragmentTransformBinding
import com.garyrex.tiposdepandemo.databinding.ItemTransformBinding
import android.content.Intent
import com.garyrex.tiposdepandemo.PanDetailActivity


/**
 * Fragment that demonstrates a responsive layout pattern where the format of the content
 * transforms depending on the size of the screen. Specifically this Fragment shows items in
 * the [RecyclerView] using LinearLayoutManager in a small screen
 * and shows items using GridLayoutManager in a large screen.
 */
class TransformFragment : Fragment() {

    private var _binding: FragmentTransformBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val transformViewModel = ViewModelProvider(this)[TransformViewModel::class.java]
        _binding = FragmentTransformBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val recyclerView = binding.recyclerviewTransform
        val adapter = TransformAdapter()
        recyclerView.adapter = adapter
        transformViewModel.texts.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    class TransformAdapter :
        ListAdapter<String, TransformAdapter.TransformViewHolder>(
            object : DiffUtil.ItemCallback<String>() {

            override fun areItemsTheSame(oldItem: String, newItem: String): Boolean =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: String, newItem: String): Boolean =
                oldItem == newItem
            }
        ) {

        private val drawables = listOf(
            R.drawable.concha,
            R.drawable.bolillo,
            R.drawable.cuernito,
            R.drawable.oreja,
            R.drawable.avatar_5,
            R.drawable.avatar_6,
            R.drawable.avatar_7,
            R.drawable.avatar_8,
            R.drawable.avatar_9,
            R.drawable.avatar_10,
            R.drawable.avatar_11,
            R.drawable.avatar_12,
            R.drawable.avatar_13,
            R.drawable.avatar_14,
            R.drawable.avatar_15,
            R.drawable.avatar_16,
        )

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransformViewHolder {
            val binding = ItemTransformBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return TransformViewHolder(binding)
        }

        override fun onBindViewHolder(holder: TransformViewHolder, position: Int) {
            holder.textView.text = getItem(position)
            holder.imageView.setImageDrawable(
                ResourcesCompat.getDrawable(holder.imageView.resources, drawables[position], null)
            )

            holder.itemView.setOnClickListener {
                val context = holder.itemView.context
                val intent = Intent(context, PanDetailActivity::class.java)
                val descripcion = when (getItem(position)) {
                    "Concha" -> "Pan dulce esponjoso con cubierta crujiente de azúcar, en forma de concha marina."
                    "Bolillo" -> "Pan salado con corteza dorada y miga suave, básico en la cocina mexicana."
                    "Cuernito" -> "Pan en forma de media luna, suave y mantecoso, similar al croissant."
                    "Oreja" -> "Pan hojaldrado en espiral o corazón, crujiente y caramelizado."
                    "Pan de muerto" -> "Pan aromatizado con azahar, decorado con huesos de masa, típico del Día de Muertos."
                    "Rosca de reyes" -> "Pan ovalado con frutas cristalizadas, consumido el 6 de enero con la tradición del Niño Dios."
                    "Telera" -> "Pan ancho con ranuras en la parte superior, ideal para tortas."
                    "Chocolatín" -> "Pan hojaldrado relleno de chocolate, de origen francés."
                    "Rebanada" -> "Pan dulce rectangular cubierto con mantequilla y azúcar."
                    "Bigote" -> "Pan alargado con forma de bigote, suave y ligeramente dulce."
                    "Mantecada" -> "Panecillo esponjoso con sabor a mantequilla, parecido al muffin."
                    "Empanada" -> "Pan relleno de frutas, crema o frijol, horneado o frito."
                    "Bisquet" -> "Pan suave y esponjoso, con sabor mantecoso, ideal para acompañar café."
                    "Dona" -> "Pan dulce frito en forma de aro, cubierto con azúcar o glaseado."
                    "Mollete" -> "Pan blanco abierto y horneado, comúnmente acompañado con frijoles y queso."
                    "Cocol" -> "Pan tradicional con semillas de anís, de sabor ligeramente dulce."
                    else -> "Pan tradicional mexicano."
                }
                intent.putExtra("PAN_DESCRIPCION", descripcion)


                intent.putExtra("PAN_IMAGEN", drawables[position])
                context.startActivity(intent)
        }
    }

    class TransformViewHolder(binding: ItemTransformBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val imageView: ImageView = binding.imageViewItemTransform
        val textView: TextView = binding.textViewItemTransform
    }
}
}