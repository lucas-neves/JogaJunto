package com.jogajunto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jogajunto.modelo.Quadra;

import java.util.ArrayList;

/**
 * Created by lucasn on 23/09/2016.
 */
public class AdapterQuadra extends BaseAdapter {

    private Context context;
    private ArrayList<Quadra> quadras;

    public AdapterQuadra(Context context, ArrayList<Quadra> quadras)
    {
        this.context = context;
        this.quadras = quadras;
    }
    @Override
    public int getCount() {
        return quadras.size();
    }

    @Override
    public Object getItem(int position) {
        return quadras.get(position);
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
            ImageView iconMap = (ImageView) view.findViewById(R.id.imageMaps);
            ImageView iconRat = (ImageView) view.findViewById(R.id.imageRating);

            Quadra quadra = quadras.get(position);

            nome.setText(quadra.nome);
            descricao.setText(quadra.descricao);
            imgQuadra.setImageResource(quadra.icon);
            iconMap.setImageResource(quadra.icon1);
            iconRat.setImageResource(quadra.icon2);
        }
        return view;
    }
}