
package com.example.agendauniversitaria
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class AdapterMateria(items:ArrayList<String>): RecyclerView.Adapter<AdapterMateria.ViewHolder>() {

    var ListDatos=ArrayList<String>()

    init {
        this.ListDatos=items
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterMateria.ViewHolder {
        var view: View = LayoutInflater.from(parent.context).inflate(R.layout.menu_materias
            ,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return ListDatos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.boton.text="{${ListDatos[position]}}"
        holder.boton.setOnClickListener {
            //enviar como parametro el nombre de la materia
            // realizar trancision de cambio para llenar los datos de la meteria

        }


    }

    class ViewHolder(itemView: View /**/) : RecyclerView.ViewHolder(itemView){
        //buscar los widget de la vista
        var boton=itemView.findViewById<Button>(R.id.button_item)





//        fun asignarDatos(datos: HistorialViaje) {
//            //asignar datos
//            tipovehiculo.text=datos.idTipoVehiculo.toString()
//            fecha.text=datos.fecha
//            placa.text=datos.placa
//            tipovehiculo.text=datos.modelo
//            origendesc.text="Origen:${datos.origen_desc}"
//            destinodesc.text="Destino:${datos.destino_desc}"
//            //tipovehiculo=datos.
//            //
//            costo.text=datos.precio.toString()
//
//
//        }







    }
}