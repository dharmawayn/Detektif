package com.example.detektif;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FragmentSatu extends Fragment {

    View wayan;
    EditText edt;
    TextView txv;
    Button btn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //cara memanggil tampilan xml gabung dengan class
        wayan = inflater.inflate(R.layout.activity_fragment_satu, container, false);

        edt = wayan.findViewById(R.id.editText1);
        txv = wayan.findViewById(R.id.textView1);
        btn = wayan.findViewById(R.id.button1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = edt.getText().toString();
                input = input.toLowerCase();

                String[] arrayInput = input.split(" ");

                String hasil = "";
                for(int i=arrayInput.length-1;i>0;i--)
                {
                    System.out.println(arrayInput[i]);
                    if (arrayInput[i].equals("bohong"))
                    {
                        arrayInput[i-1] = malek(arrayInput[i-1]);
                    }
                    hasil = arrayInput[0];
                }

                txv.setText(hasil);
            }
        });
        return wayan;
    }

    public String malek (String inputan) {
        String result="";

        //memakai equals karena String
        if(inputan.equals("bohong"))
        {
            result="jujur";
        }
        else
        {
            result="bohong";
        }

        return result;
    }
}
