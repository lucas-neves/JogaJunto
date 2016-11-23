package com.jogajunto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jogajunto.modelo.Cliente;
import com.jogajunto.modelo.Quadra;

import java.util.ArrayList;

/**
 * Created by lucasn on 23/09/2016.
 */
public class Autenticacao  {

    public static boolean autenticado = false;
    public static int idCliente = 0;
    public static Cliente cliente;
}