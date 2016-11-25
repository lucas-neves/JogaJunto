package com.jogajunto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jogajunto.modelo.Endereco;
import com.jogajunto.modelo.Quadra;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by lucasn on 23/09/2016.
 */
public class AdapterQuadra extends BaseAdapter {

    private Context context;
    List<Quadra> quadras;
    Endereco endereco;

    public AdapterQuadra(Context context, List<Quadra> quadras)
    {
        this.context = context;
        this.quadras = quadras;
    }
    @Override
    public int getCount() {
        return quadras.size();
    }

    @Override
    public String[] getItem(int position) {
        String[] quadra = new String[8];
        quadra[0] = quadras.get(position).getImage_Path();
        quadra[1] = quadras.get(position).getDescricao();
        quadra[2] = quadras.get(position).getEndereco().getLogradouro();
        quadra[3] = quadras.get(position).getDono().getTelefone();
        quadra[4] = String.valueOf(quadras.get(position).getValor_Quadra());
        quadra[5] = quadras.get(position).getOpcionais();
        quadra[6] = quadras.get(position).getCoordenateOne();
        quadra[7] = quadras.get(position).getCoordenateTwo();
        return quadra;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.list_item_favoritos, null);

        if(view != null){
            ImageView imgQuadra = (ImageView) view.findViewById(R.id.imageView);
            TextView nome = (TextView) view.findViewById(R.id.textViewNome);
            TextView descricao = (TextView) view.findViewById(R.id.textViewDescricao);

            Quadra quadra = quadras.get(position);

            nome.setText(quadra.getDescricao());
            descricao.setText(quadra.getOpcionais());

            Picasso.with(context)
                   .load(quadra.getImage_Path())
                   .into(imgQuadra);
        }
        return view;
    }
}