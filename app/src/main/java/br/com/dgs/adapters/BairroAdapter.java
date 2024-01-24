package br.com.dgs.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.dgs.R;
import br.com.dgs.model.Bairro;
import br.com.dgs.view.ListBairroActivity;

public class BairroAdapter extends ArrayAdapter {
    private final LayoutInflater inflater;
    private final int resouceId;

    public BairroAdapter (ListBairroActivity activity, int listaModeloBairro, List<Bairro> bairros) {
        super(activity, listaModeloBairro, bairros);
        this.inflater  = LayoutInflater.from(activity);
        this.resouceId = listaModeloBairro;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Bairro bairro = (Bairro) getItem(position);
        convertView = inflater.inflate(resouceId, parent, false);

        TextView txvId = convertView.findViewById(R.id.txvIdBairroLista);
        txvId.setText(String.valueOf(bairro.getId()));

        TextView txvNome = convertView.findViewById(R.id.txvNomeBairroLista);
        txvNome.setText(bairro.getNome());

        TextView txvUf = convertView.findViewById(R.id.txvUfBairroLista);
        txvUf.setText(bairro.getUf());


        return convertView;
    }

}
