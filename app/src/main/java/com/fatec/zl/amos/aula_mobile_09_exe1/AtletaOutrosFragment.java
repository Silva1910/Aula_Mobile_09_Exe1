package com.fatec.zl.amos.aula_mobile_09_exe1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.fatec.zl.amos.aula_mobile_09_exe1.model.AtletaOutros;
import com.fatec.zl.amos.aula_mobile_09_exe1.model.AtletaSenior;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AtletaOutrosFragment extends Fragment {

    private View view;
    private EditText etNomeOutros;
    private EditText etBairroOutros;
    private EditText etDataOutros;
    private EditText etAcademiaOutros;
    private EditText etSegundosOutros;

    private Button btnCadastrarO;


    public AtletaOutrosFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_atleta_outros, container, false);
        etNomeOutros = view.findViewById(R.id.etNomeOutros);
        etDataOutros = view.findViewById(R.id.etDataOutros);
        etBairroOutros = view.findViewById(R.id.etBairroOutros);
        etAcademiaOutros = view.findViewById(R.id.etAcademiaOutros);
        etSegundosOutros= view.findViewById(R.id.etSegundoOutros);
        btnCadastrarO = view.findViewById(R.id.btnCadastrarO);


        btnCadastrarO.setOnClickListener(op -> cadastrar());


        return view;
    }
    private void cadastrar() {
        AtletaOutros outros = new AtletaOutros();
        outros.setBairro(etBairroOutros.getText().toString());
        outros.setNome(etNomeOutros.getText().toString());
        String dataNascText = etDataOutros.getText().toString();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        try {
            Date dataNasc = sdf.parse(dataNascText);
            outros.setDataNasc(dataNasc);
        } catch (ParseException e) {
            e.printStackTrace();
            Toast.makeText(getContext(), "Formato de data inválido", Toast.LENGTH_SHORT).show();
        }
        outros.setAcademia(etAcademiaOutros.getText().toString());
        outros.setRecordeSegundos(Double.parseDouble(etSegundosOutros.getText().toString()));


        String mensagem =  outros.getNome()  + "  " +
                sdf.format(outros.getDataNasc()) + "  " +
                outros.getBairro()  + "  "+
                outros.getAcademia() + "  " + outros.getRecordeSegundos();


        Toast.makeText(view.getContext(), mensagem, Toast.LENGTH_LONG).show();




        limparCampos();


    }

    private void limparCampos() {
        etBairroOutros.setText("");
        etNomeOutros.setText("");
        etDataOutros.setText("");
        etAcademiaOutros.setText("");
        etSegundosOutros.setText("");


    }
}