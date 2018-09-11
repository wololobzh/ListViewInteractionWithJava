package fr.acos.listviewinteractionwithjava.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;
import fr.acos.listviewinteractionwithjava.R;
import fr.acos.listviewinteractionwithjava.bo.Personne;

/**
 * Created by acoss on 10/09/2018.
 */

public class PersonneAdapter extends ArrayAdapter<Personne>
{
    private int resource;

    public PersonneAdapter(@NonNull Context context, int resource, @NonNull List<Personne> objects)
    {
        super(context, resource, objects);
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        if(convertView == null)
        {
            LayoutInflater inflater =  (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resource,parent,false);
        }

        Personne personne = getItem(position);

        TextView tvNom = convertView.findViewById(R.id.tv_nom);
        tvNom.setText(personne.getNom());

        TextView tvPrenom = convertView.findViewById(R.id.tv_prenom);
        tvPrenom.setText(personne.getPrenom());

        return convertView;
    }

}
