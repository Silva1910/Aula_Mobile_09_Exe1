package com.fatec.zl.amos.aula_mobile_09_exe1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fatec.zl.amos.aula_mobile_09_exe1.model.AtletaJuvenil;
import com.fatec.zl.amos.aula_mobile_09_exe1.model.AtletaOutros;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AtletaJuvenilFragment extends Fragment {


    private View view;
    private EditText etNomeJuvenil;
    private EditText etBairroJuvenil;
    private EditText etDataJuvenil;
    private EditText etAnosJuvenil;

    private Button btnCadastrarJ;




    public AtletaJuvenilFragment() {
        super();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        view = inflater.inflate(R.layout.fragment_atleta_juvenil, container, false);
        etNomeJuvenil = view.findViewById(R.id.etNomeJuvenil);
        etBairroJuvenil = view.findViewById(R.id.etBairroJuvenil);
        etDataJuvenil = view.findViewById(R.id.etDataJuvenil);
        etAnosJuvenil= view.findViewById(R.id.etAnosJuvenil);
        btnCadastrarJ = view.findViewById(R.id.btnCadastrarJ);


        btnCadastrarJ.setOnClickListener(op -> cadastrar());


        return view;



    }
    private void cadastrar() {
        AtletaJuvenil j = new AtletaJuvenil();
        j.setBairro(etBairroJuvenil.getText().toString());
        j.setNome(etNomeJuvenil.getText().toString());
        String dataNascText = etDataJuvenil.getText().toString();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        try {
            Date dataNasc = sdf.parse(dataNascText);
            j.setDataNasc(dataNasc);
        } catch (ParseException e) {
            e.printStackTrace();
            Toast.makeText(getContext(), "Formato de data inválido", Toast.LENGTH_SHORT).show();
        }
        j.setQuantAno(Integer.parseInt(etAnosJuvenil.getText().toString()));

        String mensagem =  j.getNome()  + "  " +
                 sdf.format(j.getDataNasc()) + "  " +
                j.getBairro()  + "  "+
                 j.getQuantAno();


        Toast.makeText(view.getContext(), mensagem, Toast.LENGTH_LONG).show();


        limparCampos();


    }

    private void limparCampos() {
        etDataJuvenil.setText("");
        etNomeJuvenil.setText("");
        etBairroJuvenil.setText("");
        etDataJuvenil.setText("");
        etAnosJuvenil.setText("");


    }
}