package com.example.agendauniversitaria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
//import jdk.nashorn.internal.runtime.ECMAException.getException
//import androidx.test.orchestrator.junit.BundleJUnitUtils.getResult
import com.google.firebase.firestore.QueryDocumentSnapshot
//import org.junit.experimental.results.ResultMatchers.isSuccessful
import com.google.firebase.firestore.QuerySnapshot
import com.google.android.gms.tasks.Task
import androidx.annotation.NonNull
import com.google.android.gms.tasks.OnCompleteListener
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.util.Log


class MainActivity : AppCompatActivity() {
    //creando instancia de la base de datos
    var bd= FirebaseFirestore.getInstance()
    var materias=ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //consultando las materias en firebase
        bd.collection("materias")  //consulta a la colecion
          //  .document("android").collection("parciales")   //si tenemos una colecion podemos consultar sus documentos que en nuestro caso son cada materia
            .get()
            .addOnSuccessListener {  result ->
                for (document in result) {
                    Log.d("colecionmat", "${document.id} => ${document.data}")
                    materias.add(document.data["materia"].toString())
                    Log.d("materias",materias.size.toString())

                }
            }
            .addOnFailureListener { exception ->
                Log.d("error", "Error getting documents: ", exception)
            }

        //fin de consulta
    }
}


/*
val docRef = db.collection("cities").document("SF")
docRef.get()
.addOnSuccessListener { document ->
    if (document != null) {
        Log.d(TAG, "DocumentSnapshot data: ${document.data}")
    } else {
        Log.d(TAG, "No such document")
    }
}
.addOnFailureListener { exception ->
    Log.d(TAG, "get failed with ", exception)
}

referencia de como hacer la consulta a un document en firebase */
/*
db.collection("cities")
.get()
.addOnSuccessListener { result ->
    for (document in result) {
        Log.d(TAG, "${document.id} => ${document.data}")
    }
}
.addOnFailureListener { exception ->
    Log.d(TAG, "Error getting documents: ", exception)
}

referencia de como consultar todos los documentos de una colecion */