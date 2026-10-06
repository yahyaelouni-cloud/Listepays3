package com.example.listepays3
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class ProductAdapter(
    context: Context,
    private val names: Array<String>,
    private val images: List<Int>
) : ArrayAdapter<String>(context, 0, names) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.item_product, parent, false)

        view.findViewById<ImageView>(R.id.imgProduct)
            .setImageResource(images[position % images.size])
        view.findViewById<TextView>(R.id.tvProductName).text = names[position]

        view.findViewById<Button>(R.id.btnBuy).setOnClickListener {
            Toast.makeText(context, "${names[position]} ajouté au panier", Toast.LENGTH_LONG).show()
        }
        return view
    }
}