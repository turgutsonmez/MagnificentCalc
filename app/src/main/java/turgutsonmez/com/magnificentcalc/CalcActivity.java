package turgutsonmez.com.magnificentcalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class CalcActivity extends Activity {

  TextView txtSonuc;

  public enum Operation {
    ARTI, EKSI, BOLME, CARPMA, ESIT
  }

  String runningNumber = "";
  String leftValueStr = "";
  String rightValueStr = "";
  Operation currentOperation;
  int sonuc = 0;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_calc);

    Button btn0 = findViewById(R.id.btn0);
    Button btn1 = findViewById(R.id.btn1);
    Button btn2 = findViewById(R.id.btn2);
    Button btn3 = findViewById(R.id.btn3);
    Button btn4 = findViewById(R.id.btn4);
    Button btn5 = findViewById(R.id.btn5);
    Button btn6 = findViewById(R.id.btn6);
    Button btn7 = findViewById(R.id.btn7);
    Button btn8 = findViewById(R.id.btn8);
    Button btn9 = findViewById(R.id.btn9);
    Button btnTemizle = findViewById(R.id.btnTemizle);

    txtSonuc = findViewById(R.id.txtSonuc);

    ImageButton imgEqual = findViewById(R.id.imgEqual);
    ImageButton imgEksi = findViewById(R.id.imgEksi);
    ImageButton imgBolme = findViewById(R.id.imgBolme);
    ImageButton imgCarpma = findViewById(R.id.imgCarpma);
    ImageButton imgArtı = findViewById(R.id.imgArtı);

    txtSonuc.setText("");

    btn1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        numberPressed(1);
      }
    });

    btn2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        numberPressed(2);
      }
    });

    btn3.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        numberPressed(3);
      }
    });

    btn4.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        numberPressed(4);
      }
    });

    btn5.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        numberPressed(5);
      }
    });

    btn6.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        numberPressed(6);
      }
    });

    btn7.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        numberPressed(7);
      }
    });

    btn8.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        numberPressed(8);
      }
    });

    btn9.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        numberPressed(9);
      }
    });

    btn0.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        numberPressed(0);
      }
    });

    btnTemizle.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        leftValueStr = "";
        rightValueStr = "";
        sonuc = 0;
        runningNumber = "";
        currentOperation = null;
        txtSonuc.setText("0");
      }
    });

    imgArtı.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        processOperation(Operation.ARTI);
      }
    });

    imgBolme.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        processOperation(Operation.BOLME);
      }
    });

    imgCarpma.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        processOperation(Operation.CARPMA);
      }
    });

    imgEksi.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        processOperation(Operation.EKSI);
      }
    });

    imgEqual.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        processOperation(Operation.ESIT);
      }
    });

  }

  void processOperation(Operation operation) {
    if (currentOperation != null) {

      if (runningNumber != "") {
        rightValueStr = runningNumber;
        runningNumber = "";

        switch (currentOperation) {
          case ARTI:
            sonuc = Integer.parseInt(leftValueStr) + Integer.parseInt(rightValueStr);
            break;
          case EKSI:
            sonuc = Integer.parseInt(leftValueStr) - Integer.parseInt(rightValueStr);
            break;
          case BOLME:
            sonuc = Integer.parseInt(leftValueStr) / Integer.parseInt(rightValueStr);
            break;
          case CARPMA:
            sonuc = Integer.parseInt(leftValueStr) * Integer.parseInt(rightValueStr);
            break;
          case ESIT:
            break;
        }
        leftValueStr = String.valueOf(sonuc);
        txtSonuc.setText(leftValueStr);
      }


    } else {
      leftValueStr = runningNumber;
      runningNumber = "";
      currentOperation = operation;
    }
    currentOperation = operation;
  }

  void numberPressed(int number) {
    runningNumber += String.valueOf(number);
    txtSonuc.setText(runningNumber);
  }
}
