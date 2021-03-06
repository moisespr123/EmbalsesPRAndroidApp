package msc.app.embalsespuertorico

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


class MainActivity : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.activity_main, container, false)
        val listview = v.findViewById<ListView>(R.id.listView1)
        val seleccionEmbalse = v.findViewById<TextView>(R.id.embalse)
        val adFrame = v.findViewById<FrameLayout>(R.id.mainactivityad)
        val mAdFunctions = AdFunctions()
        mAdFunctions.loadBanner(adFrame, R.string.mainad, activity as AppCompatActivity)
        val `as` = app_settings(activity!!)
        if (`as`.language == "Spanish")
            seleccionEmbalse.setText(R.string.seleccione_embalse)
        else
            seleccionEmbalse.setText(R.string.select_reservoir)
        if (activity != null) {
            val ad = ArrayAdapter(activity!!, R.layout.textcenterlistview, resources.getStringArray(R.array.mainlist))
            listview.adapter = ad
            listview.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
                damdata = Intent(activity, DamMoreInfoTab::class.java)
                when (position) {
                    0 //Caonillas
                    -> damdata.putExtra("DamID", "50026140")
                    1 //Carite
                    -> damdata.putExtra("DamID", "50039995")
                    2 //Carraizo
                    -> damdata.putExtra("DamID", "50059000")
                    3 //Cerrillos
                    -> damdata.putExtra("DamID", "50113950")
                    4 //Cidra
                    -> damdata.putExtra("DamID", "50047550")
                    5 //Fajardo
                    -> damdata.putExtra("DamID", "50071225")
                    6 //Guajataca
                    -> damdata.putExtra("DamID", "50010800")
                    7 //La Plata
                    -> damdata.putExtra("DamID", "50045000")
                    8 //Patillas
                    -> damdata.putExtra("DamID", "50093045")
                    9 //Rio Blanco
                    -> damdata.putExtra("DamID", "50076800")
                    10 //Toa Vaca
                    -> damdata.putExtra("DamID", "50111210")
                }
                startActivity(damdata)
            }
        }
        return v
    }

    companion object {
        lateinit var damdata: Intent
    }


}
