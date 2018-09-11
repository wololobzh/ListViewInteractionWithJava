package fr.acos.listviewinteractionwithjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import fr.acos.listviewinteractionwithjava.adapter.PersonneAdapter;
import fr.acos.listviewinteractionwithjava.bo.Personne;

/**
 * Activité principal
 */
public class MainActivity extends AppCompatActivity
{
    //Adapter de la liste
    PersonneAdapter adapter = null;

    /**
     * Callback exécuté au moment de la création de l'activité
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bouchon
        ArrayList<Personne> liste = new ArrayList<>();
        Personne personne1 = new Personne(1,"Anthony","Lundi");
        Personne personne2 = new Personne(2,"Anthony","Mardi");
        Personne personne3 = new Personne(3,"Anthony","Mercredi");
        Personne personne4 = new Personne(4,"Anthony","Jeudi");
        Personne personne5 = new Personne(5,"Anthony","Vendredi");
        Personne personne6 = new Personne(6,"Anthony","Samedi");
        liste.add(personne1);
        liste.add(personne2);
        liste.add(personne3);
        liste.add(personne4);
        liste.add(personne5);
        liste.add(personne6);

        //Initialisation de l'adapter.
        adapter = new PersonneAdapter(this,R.layout.presentation_ligne,liste);

        //Récupération d'un objet représentant la ListView
        ListView listeView = findViewById(R.id.ma_listview);

        //Lien entre la liste et l'adapter
        listeView.setAdapter(adapter);

        //Définition de l'action réalisée lors d'un clic sur un élément
        listeView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                    {
                        //Récupération de l'élément sur lequel l'utilisateur a cliqué.
                        Personne personne = (Personne) parent.getItemAtPosition(position);
                        //On affiche dans un toast la valeur de l'élément.
                        Toast.makeText(MainActivity.this, "Vous avez cliqué sur " + personne, Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}
