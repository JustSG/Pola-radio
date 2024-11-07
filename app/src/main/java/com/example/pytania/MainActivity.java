package com.example.pytania;

import  androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Pytanie> pytania = new ArrayList<>();
    private TextView textViewPytanie;
    private Button buttonSprawdz;
    private Button buttonNastepne;
    private RadioButton[] radioButtons = new RadioButton[3];
    private RadioGroup radioGroup;
    private int licznik = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        pytania.add(new Pytanie("Jaka jest 5 planeta w układzie słonecznym?", "Ziemia", "Jowisz", "Pluton", 1));
        pytania.add(new Pytanie("Kto był pierwszym człowiekiem w kosmosie?", "Jurij Gagarin", "Neal Armstrong", "Vladimír Remek", 0));
        pytania.add(new Pytanie("Która stelita znajduje się najdalej od ziemi?", "Sputnik 1", "Telstar 1", "Voyager 1", 2));

        textViewPytanie = findViewById(R.id.textViewPytanie);
        radioButtons[0] = findViewById(R.id.radioButton1);
        radioButtons[1] = findViewById(R.id.radioButton2);
        radioButtons[2] = findViewById(R.id.radioButton3);
        buttonSprawdz = findViewById(R.id.buttonSprawdz);
        buttonNastepne = findViewById(R.id.buttonNastepne);
        radioGroup = findViewById(R.id.radioGroup);

        wyswietlPytanie();

        buttonSprawdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int odpowiedz = radioGroup.getCheckedRadioButtonId();
                for (int i = 0; i < radioButtons.length; i++) {
                    if(odpowiedz == radioButtons[i].getId()){
                        pytania.get(licznik).sprawdzOdpowiedz(i);
                        if(pytania.get(licznik).isCzyUdzielonoPoprawnejOdpowiedzi()){
                            Toast.makeText(MainActivity.this, "Poprawna odpowiedź", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(MainActivity.this, "Niepoprawna odpowiedź", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    }
                }
            }
        });

        buttonNastepne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(licznik > 2){
                    radioGroup.setVisibility(View.INVISIBLE);
                    buttonNastepne.setVisibility(View.INVISIBLE);
                    buttonSprawdz.setVisibility(View.INVISIBLE);
                }else{
                    licznik++;
                    wyswietlPytanie();
                }
            }
        });
    }

    void wyswietlPytanie(){
        textViewPytanie.setText(pytania.get(licznik).getTresc());
        radioButtons[0].setText(pytania.get(licznik).getTab()[0]);
        radioButtons[1].setText(pytania.get(licznik).getTab()[1]);
        radioButtons[2].setText(pytania.get(licznik).getTab()[2]);
    }
}