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

import com.fatec.zl.amos.aula_mobile_09_exe1.model.AtletaSenior;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Locale;


public class AtletaSeniorFragment extends Fragment {
    private View view;
    private EditText etNomeSenior;
    private EditText etBairroSenior;
    private EditText etDataSenior;
    private CheckBox cbCariaco;

    private Button btnCadastrarS;


    public AtletaSeniorFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_atleta_senior, container, false);
        etNomeSenior = view.findViewById(R.id.etNomeSenior);
        etBairroSenior = view.findViewById(R.id.etBairroSenior);
        etDataSenior = view.findViewById(R.id.etDataSenior);
        cbCariaco = view.findViewById(R.id.cbCardiaco);
        btnCadastrarS = view.findViewById(R.id.btnCadastrarS);


        btnCadastrarS.setOnClickListener(op -> cadastrar());
        return  view;
    }

    private void cadastrar() {
        String car;
        AtletaSenior senior = new AtletaSenior();
        senior.setBairro(etBairroSenior.getText().toString());
        senior.setNome(etNomeSenior.getText().toString());
        String dataNascText = etDataSenior.getText().toString();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        try {
            Date dataNasc = sdf.parse(dataNascText);
            senior.setDataNasc(dataNasc);
        } catch (ParseException e) {
            e.printStackTrace();
            Toast.makeText(getContext(), "Formato de data inválido", Toast.LENGTH_SHORT).show();
        }
        if (cbCariaco.isChecked()) {
            senior.setProblemaCardiaco(true);
             car = "Cardiaco";
        } else {
            senior.setProblemaCardiaco(false);
             car = " Não Cardiaco";
        }


        String mensagem =  senior.getNome()  + "  " +
                sdf.format(senior.getDataNasc()) + "  " +
                senior.getBairro()  + "  "+
                car;

        Toast.makeText(view.getContext(), mensagem, Toast.LENGTH_LONG).show();



        limparCampos();


    }

    private void limparCampos() {
        etDataSenior.setText("");
        etBairroSenior.setText("");
        etNomeSenior.setText("");
        etDataSenior.setText("");
        if (cbCariaco.isChecked()){
            cbCariaco.setChecked(false);
        }

    }
}


